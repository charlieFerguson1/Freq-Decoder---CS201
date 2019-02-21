//import java.util.Arrays;

public class Decode {
	
	public final int LETTERS = 26;
	private Message message;
	private String encodedStr = "";
	private int shift = 97;
	
	
	char[] key = {'e','t','a','o','i','n','s','h','r','d','l','u','c','m',
			'f','w','y','p','v','b','g','k','q','j','x','z'};
	
	Letter [] letters = new Letter[LETTERS];
	
	
	
	public Decode(Message inMessage)
	{
		message = inMessage;
		encodedStr = message.getEncoded();
	}
	
	
	/*
	 * decode
	 * parameters: none
	 * 
	 * Does: 
	 * 		calls the necessary methods in decode and completes the 
	 * 		conversion of the encoded string to the decoded string
	 * 
	 * returns nothing, but it updates the instance of message.
	 */
	public void decode()
	{
		this.createLetters();
		this.occLetters();
		this.sortLetters();
		this.decodedAlphabet(); // after this method the array, letters, is 
							   // updated so that each instance has its encoded
							   // and decoded value. 
		String temp = encodedToDecoded();
		message.setDecoded(temp);
	}
	
	/*
	 * enccodedToDecoded()
	 * parameters: 
	 * 		none
	 * does: 
	 * 		reads through the message one char at a time. If the char is a 
	 * 		letter then it is decoded and added to the decoded string. If 
	 * 		it is not a letter then it is added to decoded immediately.
	 * returns:
	 * 		
	 * 
	 */
	public String encodedToDecoded()
	{
		String decoded ="";
		
		for(int i = 0; i < message.getLength(); i++)
		{
			char c = encodedStr.charAt(i); //c is the char that is being examined and decoded
										  // it is to be added to the new decoded string
			
			if( Character.isLetter(c))		//checking to see if c is a letter
			{
				int indexOf = indexOf(c, letters); //finds the index of the char from the encdoed string
											   // in the array key
				decoded = decoded + letters[indexOf].getDecodedLetter();
			}
			else
			{
				decoded = decoded + c;
			}
		}
		return decoded;
	}
	
	/*
	 * occLetters:
	 * Parameters:
	 * 		none
	 * Does:
	 * 		calls createLetters, scans the encoded string from message
	 * 		and for each letter the freq value in the corresponding 
	 * 		letter object is increased by 1. 
	 * 
	 * 		ie; if the message contains  an  "a" when the method scans 
	 * 		that letter, the letter object's freq is increased by one 
	 * Returns:
	 * 		the array Letters updated so that each letter has its freq
	 */
	public Letter[] occLetters()
	{
		letters = createLetters();
		for(int i = 0; i < message.getLength(); i++)
		{
			char c = encodedStr.charAt(i);
			if(Character.isLetter(c))
			{
				letters[alphabetIndex(c)].setFreq( letters[alphabetIndex(c)].getFreq() + 1 ); 
				// this line takes the char from the message and finds the
				// Letter object and increases it's freq by 1.
			}
		}
		return letters;
	}
	
	/*
	 * sortLetters
	 * parameters: 
	 * 		none
	 * does:
	 * 		uses an external quickSort class letters is sorted based on the amount of 
	 * 		the freq for each instances of the object Letter
	 * return:
	 * 		the sorted array, letters sorted so that the Letters with the highest freq
	 * 		are in the beginning of the array
	 */
	public Letter[] sortLetters()
	{
		GenericQuicksortComparable.<Letter>qsort(letters, 0, letters.length-1);
		return letters;
	}
	
	
	/*
	 * DecodedAlphabet
	 * returns:
	 * 		the array letters with each Letter updated with 
	 * 	 	each letter having its decoded char value set
	 */
	public void decodedAlphabet()
	{
		int k = 0;
		for(int i = LETTERS-1; i >= 0; i--)
		{
			letters[i].setDecodedLetter(key[k]);
			k++;
		}
	}
	
	/*
	 * populates the array letters with the object LETTERS
	 */
	public Letter[] createLetters()
	{
		for(int i = 0; i < LETTERS; i++)
		{
			letters[i] = new Letter( alphabetIndex(i) );
		}
		return letters;
	}
	
	
	/*
	 * alphabetIndex
	 * 
	 * Parameters:
	 * 		char, c 
	 * does:
	 * 		subtracts the shift, 97, to make the int value of c correspond to 0
	 * 		the which is the desired index in an array of letters
	 * returns
	 * 		the shifted int value of c
	 */
	public int alphabetIndex(char c)
	{
		return c - shift;
	}
	
	/*
	 * alhabetIndex
	 * 
	 * Parameters:
	 * 		int, i shift, 97, to make the char value of i correspond to the letter
	 * 		that it should be in an array of the alphabet based on its index
	 * 		ie; an input of 1 = a, 2 = b, 3 = c...
	 * does:
	 * 		the char value of the index entered
	 */
	public char alphabetIndex( int i)
	{
		return (char) ( i + shift);
	}
	
	/*
	 * indexOf
	 * parameters:
	 * 		takes in an array and a char
	 * does:
	 * 		finds the index of the char in the array
	 * returns:
	 * 		the index of the char in the array
	 */
	
	public int indexOf(char c, Letter[] arr)
	{
		int i = 0;
		while (c != arr[i].getEncodedLetter())
		{
			i++;
		}
		return i;
	}
	
	
	public String toString()
	{
		return message.getDecoded();
	}
	
	public String getEncoded()
	{
		return encodedStr;
	}
	
}
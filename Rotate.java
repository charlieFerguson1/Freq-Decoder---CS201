import java.util.LinkedList;

public class Rotate {
	
	char[] key = new char[52];
	int start = 0;
	int end = 26;
	int letters = 26;
	private int shift = 97;
	
	Message message;
	private String encodedStr;
	
	
	public void assignKey()
	{
		String keyStr = "qwertyuiopasdfghjklzxcvbnm";
		for( int i = 0; i < keyStr.length();i++)
		{
			key[i] = keyStr.charAt(i);
		}
	}

	public Rotate(Message inMessage)
	{
		message = inMessage;
		encodedStr = message.getEncoded();
	}
	
	public void decode()
	{
		assignKey();
		String temp = "";
		int length = message.getLength();
		for(int i = 0; i < length;i++)
		{
			char encodedChar = encodedStr.charAt(i);
			if(Character.isLetter(encodedChar))
			{
				
				int index = indexOf(encodedChar , key) - start;
				encodedChar = alphabetIndex(index);
				rotate();
			}
			temp = temp + encodedChar;
		} 
		message.setDecoded(temp);
		System.out.println("\ndecoded String: " + temp);
	}
	
	public void rotate()
	{
		key[end] = key[start];
		key[start] = '-';
		if(key[25]=='-')
		{
			for(int i = 0; i < key.length;i++)
			{
				System.out.print(key[i] + ", ");
			}
			reset();
		}
		else
		{
			
			start++;
			end++;
		}
	}
	
	public void reset()
	{
		for(int i = 0; i < letters; i++) //should shift the letters back to the 
										//beginning of the array in the original order
		{
			key[i] = key[i + letters]; 
		}
		key[25] = '_';
		start = 0;
		end = 26;
	}
	
	public char alphabetIndex(int i)
	{
		return (char) ( i + shift);
	}
	
	public int indexOf(char c, char[] arr)
	{
		int i = 0;
		while (c != arr[i])
		{
			i++;
			if(i>= arr.length)
			{
				return -1;
			}
		}
		return i;
	}
	
}

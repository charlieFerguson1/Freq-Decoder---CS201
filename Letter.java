
public class Letter implements Comparable<Letter>{

	private char enLet, deLet;
	private int freq;
	
	public Letter(char inEncodedLetter)
	{
		enLet = inEncodedLetter;
		
	}
	
	/****
	 * getters and setters are below
	 */
	
	
	public char getEncodedLetter()
	{
		return enLet;
	}
	
	public void setEncodedLetter(char inEncodedLetter)
	{
		enLet = inEncodedLetter;
	}
	
	
	public char getDecodedLetter()
	{
		return deLet;
	}
	
	public void setDecodedLetter(char inDecodedLetter)
	{
		deLet = inDecodedLetter;
	}
	
	public int getFreq()
	{
		return freq;
	}
	
	public void setFreq(int inFreq)
	{
		freq = inFreq;
	}
	
	public String toString()
	{
		return enLet +  ", " + freq + ", "  + deLet +" ";
	}
	/*
	 * compareTO allows the user to compare one instance of this object letter
	 * to another instance of the object letter.
	 * 
	 * if the letter used as a parameter is has a larger frequency then the object
	 * 
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */

	public int compareTo(Letter other) 
	{
		int i = 0;
		if(other.getFreq() > this.getFreq())   //if the parameter object has a higher freq than this
		{
			i = -1;
		}
		else if (other.getFreq() < this.getFreq())
		{
			i = 1;
		}
		
		return i;
	}
	
	
}

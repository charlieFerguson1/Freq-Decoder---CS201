
public class Message {
	
	private String encoded , decoded;
	
	//private int length = encoded.length();
	
	public Message(String encodedIn )
	{
		encoded = encodedIn;
	}
	
	
	
	/***************************************************
	 * getters and setters for class
	 * 
	 */
	public String getDecoded()
	{
		return decoded;
	}
	
	public String getEncoded()
	{
		return encoded;
	}
	
	public int getLength()
	{
		
		return encoded.length();
	}

	public void setEncoded(String encodedIn)
	{
		encoded = encodedIn;
	}
	
	public void setDecoded(String decodedIn)
	{
		decoded = decodedIn;
	}
	
	
	public String toString()
	{
		return encoded;
	}
}

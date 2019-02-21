import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class DecodeDriver {
	/*
	 *  file 0 is the base test
	 *  file 1 is the deceleration of 
	 *  file 2 is alices adventures in wonderland
	 *   file 3 is the adventures of sherlock holmes
	 *   file 4 is huck fin
	 *   file 5 is 
	 */
	
	public static void main(String args[]) throws IOException
	{
		for(int i = 0; i < args.length; i++)
		{
			System.out.println("decoding text file " + i);
			Message message = readFile(args[i]);

			Decode d1 = new Decode(message);
			
			d1.decode();
			System.out.println("decoded: \n" + d1);
			System.out.println(" . . .  ");
		}
	}

	public static Message readFile (String arg) throws FileNotFoundException
	{
		Scanner fr = new Scanner (new File(arg));
		String text = "";
		while(fr.hasNextLine())
		{
			text = text + fr.nextLine() + "\n";
		}
		Message m1 = new Message(text);
		fr.close();
		return m1;
	}
}

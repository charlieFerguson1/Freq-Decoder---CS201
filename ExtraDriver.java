	import java.io.IOException;
	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileWriter;
	import java.util.Scanner;
public class ExtraDriver {
		
		public static void main(String args[]) throws IOException
		{
			
				System.out.println("decoding text file ") ;
				Message message = readFile();

				Rotate d1 = new Rotate(message);
				
				d1.decode();
				//System.out.println("encoded: \n " + d1.getEncoded());
				System.out.println(" . . .  ");
		}

		public static Message readFile () throws FileNotFoundException
		{
			
			Scanner fr = new Scanner (new File("rotate.txt"));

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




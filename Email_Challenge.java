import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;



public class Email_Challenge {

	public static void main(String[] args) throws IOException {
		//Declares necessary variables
		String base_URL = "https://www.ecs.soton.ac.uk/people/";
		String line;
		String name;
		String email;
		int startName;
		int endName;
		BufferedReader Emailinputreader = new BufferedReader(new InputStreamReader(System.in));					//Creates reader object for user
		email = Emailinputreader.readLine();																	//Reads user input
		URL PageURL = new URL(base_URL+email);
		BufferedReader Pagereader = new BufferedReader(new InputStreamReader(PageURL.openStream(),"UTF-8"));	//Creates reader object for web page
		do {																									//Iterates over each line of the web page...
			line = Pagereader.readLine();
		}while (!line.contains("<title>"));																		//Until the title tag is found
		startName = line.indexOf(">") + 1;																		//Finds the end of the title tag and sets this as the start of the substring
		endName = line.indexOf("|");																			//Finds the end of the name
		name = line.substring(startName, endName);
		System.out.println(name);
	}

}

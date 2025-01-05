import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {
	
	public static BufferedReader text;
	
	public static CustomHashTable readResponsesFromFile(String filePath) throws IOException {
		CustomHashTable survey = new CustomHashTable();
		text = new BufferedReader(new FileReader(filePath));
		Scanner scan = new Scanner(text);
		
		while (scan.hasNextLine()) {
			int key = scan.nextInt();
			Response response = new Response(key, scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.next(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.next(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.next(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt());
			survey.insert(key, response);
		}
		
		scan.close();
		text.close();
		return survey;
	}
	
}

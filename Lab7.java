//Steven Wang

public class Lab7 {
	
	static String table = "abcdefghijklmnopqrstuvwxyz";
	
	public static void main(String[] args) {
		System.out.println(hashA("lily"));
	}
	
	public static int hashA(String key) {
		int hash = 0;
		
		for (int i = 0; i < key.length(); i++) {
			hash += table.indexOf(key.charAt(i));
		}
		
		return hash;
	}
	
	public static int hashB(String key) {
		return table.indexOf(key.charAt(0)) + table.indexOf(key.charAt(key.length()-1));
	}
	
}

package Chapter1;

public class StringCompression {
	//Assume the input string has only uppercase and lowercase letters
	public static String stringCompression(String str) {
		StringBuilder com = new StringBuilder();
		int count = 0;
		char current = str.charAt(0);
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == current) {
				count++;
			} else {
				com.append(current+String.valueOf(count));
				current = str.charAt(i);
				count = 1;
			}
		}
		com.append(current+String.valueOf(count));
		return com.length() < str.length() ? com.toString(): str;		
	}
	public static void main(String args[]) {
		String str = "aa";
		//System.out.println(str);
		System.out.println(stringCompression(str));
	}
}
/*
 * Space Complexity O(N), N is the length of the string
 * Time Complexity O(N), N is the length of the string
 */
package Chapter1;

public class StringRotation {
	public static boolean isSubstring(String big, String small) {
		if (big.indexOf(small) >= 0) {
			return true;
		} else {
			return false;
		}
	}
	public static boolean stringRotation (String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		String s1s1 = new String(s1+s1);
		if (isSubstring(s1s1,s2)) {
			return true;
		} else {
			return false;
		}
	}
	public static void main(String[] args) {
		String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean is_rotation = stringRotation(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + is_rotation);
		}
	}
}
/*
 * Space Complexity O(1) 
 * Time Complexity O(N), actually, the Time Complexity depends on isSubstring,
 * assume that isSubstring runs in O(A+B) time where A,B are lengths of the 
 * two strings, then the runtime of stringRotation is O(N)
 */
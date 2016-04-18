package Chapter1;
/*
 * Given two Strings, write a method to decide if one is a permutation of the other.
 */
public class CheckPermutation {
	public static boolean checkPermutation (String s1, String s2) {
		if (s1.length()!=s2.length())
			return false;
		int check[] = new int [256]; // Assume character set is EASCII
		for (int i = 0; i < s1.length(); i++) {
			int index = s1.charAt(i);
			check[index]++;
		}
		for (int i = 0; i < s2.length(); i++) {
			int index = s2.charAt(i);
			check[index]--;
			if (check[index] < 0)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean anagram = checkPermutation(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + anagram);
		}
	}
}
/*
 * Space Complexity O(1)
 * Time Complexity O(n) where n is the maximum length of the two strings
 * 
*/

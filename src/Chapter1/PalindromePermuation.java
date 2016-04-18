package Chapter1;

public class PalindromePermuation {
	/* Assumes only letters a through z and A through Z*/
	public static int[] collect(String str) {
		str = str.toLowerCase();
		int c[] = new int[26];
		for (int i = 0; i < str.length(); i++) {
			int index = str.charAt(i) - 'a' ;
			if ((index >=0 )&&(index <26))
				c[index] ++;
		}
		return c;
	}
	
	public static boolean checkMaxOdd(int[] c) {
		boolean odd = false;
		if ((c.length < 0)||(c.length > 26))
			return false;
		for (int i = 0; i < 26; i++) {
			if (c[i]%2 == 1){
				if (odd)
					return false;
				odd = true;
			}
		}
		return true;
	}
	
	public static boolean isPalindromePermuation (String str) {
		int c[] = collect(str);
		return checkMaxOdd(c);
	}
	
	public static void main(String[] args) {
		String pali = "Ratzs live on no evil starz";
		System.out.println(isPalindromePermuation(pali));
		String pali2 = "Zeus was deified, saw Suez";
		System.out.println(isPalindromePermuation(pali2));
	}
}
/*
 * Space Complexity O(1), just a integer table needs to be saved
 * Time Complexity O(N), N is the length of the string
 */
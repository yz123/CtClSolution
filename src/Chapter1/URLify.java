package Chapter1;
/*
 * Write a method to replace all spaces in a string with '%20'. You may assume that the string
 * has sufficient space at the end to hold the additional characters, and that you are given 
 * the "true" length of the string. (Note: if implementing in Java, please use a character array
 * so that you can perform this operation in place.)
 */

public class URLify {
	public static void urlify (int len, char[] s) {
		int count = 0;
		for (int i = 0; i < len; i++ ) {
			if (s[i] == ' ') {
				count ++;
			}
		}
		int index =  len + count*2 - 1;
		for (int i = len - 1; i >= 0; i-- ) {
			if (s[i] == ' ') {
				s[index]='0';
				s[index-1]='2';
				s[index-2]='%';
				index = index -3;
			}
			else {
				s[index] = s[i];
				index--;
			}
		}
	}
	public static int findLastCharacter(char[] str) {
		for (int i = str.length - 1; i >= 0; i--) {
			if (str[i] != ' ')
				return i;
		}
		return -1;
	}
	public static void main(String[] args) {
		String str = "Mr John Smith    ";
		char[] arr = str.toCharArray();
		int trueLength = findLastCharacter(arr)+1;
		urlify(trueLength, arr);
		System.out.println(arr);
	}
}
/*
 * Space Complexity O(1)
 * Time Complexity O(n), n is the true length of the character set
 */

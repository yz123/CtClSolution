package Chapter1;

public class OneWay {
	/* Assumes input is ASCII*/
	public static boolean isReplace(char[] c1, char[] c2){
		boolean flag = false;
		for(int i = 0; i < c2.length; i++) {
			if(c1[i]!=c2[i]) {
				if (flag)
					return false;
				flag = true;
			}
		}
		return true;
	}
	
	public static boolean isInRm(char[] c1, char[] c2){
		int index1 = 0;
		int index2 = 0;
		while (index1 < c1.length && index2 < c2.length) {
			if (c1[index1] != c2[index2]) {
				if (index1 != index2) {
					return false;
				}
				index1++;
			} else {
			index1++;
			index2++;
			}
		}
		return true;
	}

	public static boolean isOneWay(String s1, String s2) {
		char c1[] = s1.toCharArray();
		char c2[] = s2.toCharArray();
		int len1 = c1.length;
		int len2 = c2.length;
		if (len1 == len2) {
			return isReplace(c1,c2); 
		} else if (len1 == len2 + 1) {
			return isInRm(c1,c2);
		} else if (len2 == len1 + 1) {
			return isInRm(c2,c1);
		} 
		return false;
	}
	public static void main(String[] args) {
		String[][] tests = {{"a", "b", "true"}, 
				{"", "d", "true"},
				{"d", "de", "true"},
				{"pale", "pse", "false"},
				{"acdsfdsfadsf", "acdsgdsfadsf", "true"},
				{"acdsfdsfadsf", "acdsfdfadsf", "true"},
				{"acdsfdsfadsf", "acdsfdsfads", "true"},
				{"acdsfdsfadsf", "cdsfdsfadsf", "true"},
				{"adfdsfadsf", "acdfdsfdsf", "false"},
				{"adfdsfadsf", "bdfdsfadsg", "false"},
				{"adfdsfadsf", "affdsfads", "false"},
				{"pale", "pkle", "true"},
				{"pkle", "pable", "false"}};
		
		for (int i = 0; i < tests.length; i++) {
			String[] test = tests[i];
			String a = test[0];
			String b = test[1];
			boolean expected = test[2].equals("true");
			System.out.println(isOneWay(a,b) == expected);
			}
 		}
}
/*
 * Space Complexity O(N), N is the length of the string
 * Time Complexity O(N), N is the length of the string
 */
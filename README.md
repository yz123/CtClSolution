# CtClSolution

## 项目简介

这是我对程序员面试宝典第6版，俗称绿宝书中编程题目的解答。书中技术类面试问题一共有17章，目前完成2章，正在码第3章的代码。这个README我会
时常更新，以此来记录我对每道题目的看法。

> 书山有路勤为径 学海无涯苦作舟

我知道的名句不多，就以此来激励自己，每天写点编程题目，努力提升自己 :smile:

## 第一章：[数组和字符串](https://github.com/JinhaiZ/CtClSolution/tree/master/src/Chapter1)

### 1.9 String Rotation
####题目简介：
假设我们有一个判断一个字符串是否是另一个字符串的字串的方法**isSubString**，现在给我们两个字符串s1和s2，请判断s2是否是s1的*旋转*？条件
是只使用**一次isSubString**方法。例如：”waterbottle“是”erbottlewat“的*旋转*。
####题目解答：
书中提供的解题观点非常独特，判断一个字符串是否是另一个字符串的旋转，只需要判断一个字符串是否是另一个字符串的字串，当然，另一个字符串
需要先行构造一下：即，判断AB是否是BA的旋转比较困难，转而比较AB是否是BABA的字串即可，当然，需要首先判定两个字符串的大小。
```java
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
```

## 第二章：[链表](https://github.com/JinhaiZ/CtClSolution/tree/master/src/Chapter2) 


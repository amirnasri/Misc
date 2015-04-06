import java.util.HashSet;

/*
 * Implement an algorithm to determine if a string has all unique characters. What if
 * you can not use additional data structures?
 */
		
public class CCI_Q1_1 {
	
	private static boolean is_char_unique(String s) {
		HashSet<Character> hash_set = new HashSet<>();
		
		for (int i = 0; i < s.length(); i++) {
			if (!hash_set.add(s.charAt(i)))
				return false;	
		}
		return true;
	}

	private static boolean is_char_unique1(String s) {
		long v = 0;
		
		for (int i = 0; i < s.length(); i++) {
			byte shift = (byte) (s.charAt(i)-'0');
			System.out.println(shift);
			if ((v & (1 << shift)) != 0) {
				return false;
			}
			else {
				v |= (1 << shift);
			}
		}
		return true;
	}
	
	private static boolean is_char_unique2(String s) {
		boolean[] array = new boolean[1<<16];
		for (int i = 0; i < s.length(); i++) {
			if (array[s.charAt(i)])
				return false;
			else
				array[s.charAt(i)] = true;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s = new String("abcfepnwvkz1c");
		System.out.println(is_char_unique2(s));
		int[] a = new int[10];
		System.out.println(a);
		

	}
}
“In a collection of strings, output the string that occurs most often.”
“find out all the pairs in an array that adds up to a certain number”
Given a set of number ranges, i.e. [1,5], [3,6], [7,9], write a program to merge overlapping number ranges. In the above example, the result should be [1,6], [7,9].”
“Check if all the leaves are at the same level in a binary tree”
“sort a list of words alpha-numerically.”
write a method that returns the most common character in a string.

Nuts and bolts. A disorganized carpenter has a mixed pile of N nuts and N bolts. The goal is to find the corresponding pairs of nuts and bolts. Each nut fits exactly one bolt and each bolt fits exactly one nut. By fitting a nut and a bolt together, the carpenter can see which one is bigger (but the carpenter cannot compare two nuts or two bolts directly). Design an algorithm for the problem that uses NlogN compares (probabilistically).

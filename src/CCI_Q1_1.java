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

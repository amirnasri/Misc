import java.util.Arrays;
import java.util.Comparator;

/*
 * Compare to string arrays using only character comparison. 
 * Note: Natural ordering for char and String means "A" < "B" < "a". So all upper case words will be before the lower case ones.
 * To fix this we can modify the char or String comparator to compare the lower case items and return the result if they are not equal. 
 * If the items are equal in lower case, return the natural order.
 */

public class Sort_string_array {
	
	static class Char_comparator implements Comparator<String> {
		int pos;
		Char_comparator(int pos) {
			this.pos = pos;
		}
		public int compare(String s1, String s2) {
			
			if (s1.length() < pos + 1 && s2.length() < pos + 1)
				return 0;
			if (s1.length() < pos + 1)
				return -1;
			if (s2.length() < pos + 1)
				return 1;
			char c1 = s1.charAt(pos);
			char c2 = s2.charAt(pos);
			int cmp = Character.compare(Character.toLowerCase(c1), Character.toLowerCase(c2));
			
			if (cmp != 0)
				return cmp;
			return Character.compare(c1, c2);
			
		}
	}
	
	static void sort_(String[] str_array, int pos) {
		Arrays.sort(str_array, new Char_comparator(pos));
	}
	
	static void sort(String[] str_array) {
		int max_len = 0;
		for (String s: str_array) {
			max_len = max_len < s.length() ? s.length() : max_len;  
		}
		
		for (int i = max_len - 1; i >= 0; i--) {
			sort_(str_array, i);
		}
	}
	
	public static void main(String[] args) {
		//String[] str_array = new String[] {"ac", "ab", "bfc", "ba"};
		String[] str_array = new String[] {"development", "aBc", "Development", "aa", "AA", "Aa"};
		
		for (String s: str_array) 
			System.out.print(s + "  ");
		System.out.println();
		
		//sort(str_array);
		//Arrays.sort(str_array);
		
		
		Arrays.sort(str_array, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				int cmp = s1.compareToIgnoreCase(s2);
				
				if (cmp != 0)
					return cmp;
				else
					return s1.compareTo(s2);
			}

		});
		
		
		for (String s: str_array) 
			System.out.print(s + "  ");
		System.out.println();
		
		
		
	}
}

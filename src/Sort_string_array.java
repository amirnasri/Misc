import java.util.Arrays;
import java.util.Comparator;


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
				
			return (Character.compare(s1.charAt(pos), s2.charAt(pos)));
			
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
		String[] str_array = new String[] {"ac", "ab", "bfc", "ba"};
		
		for (String s: str_array) 
			System.out.print(s + "  ");
		System.out.println();
		
		//sort(str_array);
		Arrays.sort(str_array);
		
		for (String s: str_array) 
			System.out.print(s + "  ");
		System.out.println();
	}
}

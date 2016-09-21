import java.util.ArrayList;

public class Cound_palindrome {
	
	public static int count_palidrome(String s) {
		
		int cnt = 0;
		ArrayList<Integer> prev_pal = new ArrayList<Integer>(); 
		for (int i = 0; i < s.length(); i++) {
			ArrayList<Integer> current_pal = new ArrayList<Integer>(); 
			for (int index: prev_pal) {
				if (index > 0 && s.charAt(index-1) == s.charAt(i)) {
					cnt++;
					current_pal.add(index-1);
				}
			}
			if (i > 0 && s.charAt(i - 1) == s.charAt(i)) {
				cnt++;
				current_pal.add(i-1);
			}
			current_pal.add(i);
			cnt++;
			prev_pal = current_pal;
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		System.out.println(count_palidrome("baaad"));
	}
}

import java.util.Arrays;
import java.util.Random;


public class Longest_non_duplicate_sequence {
	static int[] last_pos;
	
	static int find_longest_sequence(String s) {
		last_pos = new int[26];
		for (int i = 0; i < 26; i++)
			last_pos[i] = -1;
		
		int i = 0;
		int j = 0;
		int distinct_seq_len_max = 0;
		int distinct_seq_max_start = -1;
		int distinct_seq_max_end = -1;
		int distinct_seq_len = 0;
		while (j < s.length()) {
			int new_char = s.charAt(j) - 'a';
			i = last_pos[new_char];
			distinct_seq_len = Math.min(j - i, distinct_seq_len + 1);
			
			if (distinct_seq_len_max < distinct_seq_len) {
				distinct_seq_len_max = distinct_seq_len;
				distinct_seq_max_end = j;
				distinct_seq_max_start = j - distinct_seq_len;
			}

			last_pos[new_char] = j;
			j++;

		}
		System.out.println(distinct_seq_max_start + "  " + distinct_seq_max_end);
		return distinct_seq_len_max;
	}
	
	private static boolean is_all_unique(String s) {
		if (s.length() <= 1)
			return true;
		char[] ca = s.toCharArray();
		Arrays.sort(ca);
		
		
		for (int i = 1; i < ca.length; i++) {
			if (ca[i] == ca[i - 1])
				return false;
		}
		return true;
	}
	static int find_longest_sequence_brute_force(String s) {
		int max_len = 0;
		for (int len = 1; len <= s.length(); len++) {
			for (int i = 0; i < s.length() - len + 1; i++)
				if (is_all_unique(s.substring(i, i + len)))
					if (len > max_len)
						max_len = len;
		}
		return max_len;
	}

	public static void main(String[] args) {
		//String s = "fksdfbafdmfmdslrkqeopiabfq";
		//String s = "tyjjgbvotrjhfkjdhdsaljfhas";
		//String s = "abfarefwq";
		String s = "fkjdshhljclh";
		Random rg = new Random();
		final int str_len = 20;
		char[] ca = new char[str_len];
		for (int i =0 ; i < str_len; i++)
			ca[i] = (char) ('a' + rg.nextInt(26));
		s = new String(ca);
		System.out.println(s);
		System.out.println(find_longest_sequence(s));
		//System.out.println(find_longest_sequence_brute_force(s));
		
	}
}

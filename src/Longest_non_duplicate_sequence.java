
public class Longest_non_duplicate_sequence {
	static int[] last_pos;
	
	static int find_longest_sequence(String s) {
		last_pos = new int[26];
		for (int i = 0; i < 26; i++)
			last_pos[i] = -1;
		
		int i = 0;
		int j = 0;
		int distinct_seq_len_max = 0;
		int distinct_seq_len = 0;
		while (j < s.length()) {
			int new_char = s.charAt(j) - 'a';
			i = last_pos[new_char];
			distinct_seq_len = Math.min(j - i, distinct_seq_len + 1);
			
			last_pos[new_char] = j;
			j++;

			distinct_seq_len_max = Math.max(distinct_seq_len_max, distinct_seq_len);
		}
		return distinct_seq_len_max;
	}

	public static void main(String[] args) {
		//String s = "fksdfbafdmfmdslrkqeopiabfq";
		//String s = "tyjjgbvotrjhfkjdhdsaljfhas";
		String s = "abfarefwq";
		System.out.println(find_longest_sequence(s));
	}
}

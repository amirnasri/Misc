class GroupedWordChecker {
	
	public static int howMany(String[] words) {
		
		int grouped_num = 0;
		for (String w: words) {
			if (w.equals(""))
				continue;
			
			boolean[] char_seen = new boolean[256];
			char_seen[w.charAt(0)] = true;
			boolean grouped = true;
			for (int i = 1; i < w.length(); i++) {
			
				if (w.charAt(i-1) != w.charAt(i)) {
					if (char_seen[(int) w.charAt(i)]) {
						grouped = false;
						break;
					}
					char_seen[(int) w.charAt(i)] = true;
				}
			}
			
			if (grouped)
				grouped_num++;
		}
		
		return grouped_num;
	}
	
	public static void main(String[] args) {
		String[] words = new String[] 	{"qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqi", "jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjp", "llllllllllllllllllllllllllllllllllllllllllllllllll", "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzb", "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkb", "lllllllllllllllllllllllllllllllllllllllllllllllllf", "ooooooooooooooooooooooooooooooooooooooooooooooooov", "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb", "lllllllllllllllllllllllllllllllllllllllllllllllllj", "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhn", "oooooooooooooooooooooooooooooooooooooooooooooooooo", "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee", "rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrs", "ttttttttttttttttttttttttttttttttttttttttttttttttts", "yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy", "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwm", "qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqk", "vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvj", "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwt", "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxg", "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwx", "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmme", "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz", "gggggggggggggggggggggggggggggggggggggggggggggggggo", "pppppppppppppppppppppppppppppppppppppppppppppppppu", "ssssssssssssssssssssssssssssssssssssssssssssssssss", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaap", "oooooooooooooooooooooooooooooooooooooooooooooooook", "cccccccccccccccccccccccccccccccccccccccccccccccccr", "pppppppppppppppppppppppppppppppppppppppppppppppppl", "jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwws", "rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrb"};
		System.out.println(howMany(words));
	}
}
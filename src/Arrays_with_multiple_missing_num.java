class Arrays_with_multiple_missing_num {

	/*
	 * An array of n integers consisting of integers from 1:n is given.
	 * One integer is repeated twice and one integer is missing. Find the repeated
	 * and missing integer.
	 */
	
	static int get_bit_position(int a, int position) {
		if (position >= 32)
			return 0;
		else
			return (a >> position) & 1;
	}
	
	static void find_duplicate_missing(int[] array) {
		int n = array.length;
		int s = 0;
		for (int i = 0; i < n; i++)
			s ^= (i + 1);
		for (int i: array)
			s ^= i;
		
		int first_1_pos = 0;
		// s cannot be zero!
		while ((s & 1) != 1) {
			s = s >> 1;
			first_1_pos++;
		}
		int i0 = 0;
		int i1 = 0;
		for (int i = 0; i < n; i++) {
			if (get_bit_position(i + 1, first_1_pos) == 1) 
				i0 ^= i + 1;
			else 
				i1 ^= i + 1;
			
			if (get_bit_position(array[i], first_1_pos) == 1) 
				i0 ^= array[i];
			else 
				i1 ^= array[i];
		}
	
		System.out.println(i0 + "  " + i1);
	}
	
	public static void main(String[] args) {
		final int n = 3;
		int[] array = new int[n];
		for (int i = 0; i < n; i++)
			array[i] = i + 1;
		
		array[1] = 1;
		array = new int[] {2, 1, 1};

		for (int i = 0; i < n; i++)
			System.out.print(array[i]+ "  ");
		System.out.println();
		
		find_duplicate_missing(array);
	}
	
}
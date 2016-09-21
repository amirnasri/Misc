import java.util.Random;


public class Find_rotation_point {
	
	static void print_array(int[] array) {
		for (int a: array) {
			System.out.printf("%-6s", a);
		}
		System.out.println();
	}
	
	// If no rotation (k = 0) returns 0
	static int find_rotation_point(int[] array) {
		
		// l and h are inclusive
		int l, h, m;
		l = 0;
		h = array.length - 1;
		while (l < h) {
			m = (l + h)/2;
			// Choose l and h such that the interval includes the start point (the minimum array value)
			// Compare with array[h] so that no rotation case is treated correctly 
			if (array[m] < array[h])
				h = m;
			else
				l = m + 1;
		}
		return l;
	}
	
	public static void main(String[] args) {
		
		final int L = 1000;
		Random r = new Random();
		
		final int k = r.nextInt(L);
		
		int[] array = new int[L];
		
		for (int i = 0; i < L; i++)
			array[i] = i;
		
		int[] rotated_array = new int[L];
		
		for (int i = 0; i < L - k; i++)
			rotated_array[k + i] = array[i];
		for (int i = 0; i < k; i++)
			rotated_array[i] = array[L - k + i];
		print_array(rotated_array);
		
		System.out.println(k);
		System.out.println(find_rotation_point(rotated_array));
	}

}

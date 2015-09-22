import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class Sort_increasing_decreasing_arrays {
	static ArrayList<Integer[]> increasing = new ArrayList<>();
	static ArrayList<Integer[]> decreasing = new ArrayList<>();

	
	static int[] n_way_merge(int[] array, ArrayList<Integer[]> subarrays, boolean ascending) {
		int[] indices = new int[subarrays.size()];
		int total_len = 0;
		for (int i = 0; i < subarrays.size(); i++) {
			Integer[] subarray = subarrays.get(i);
			indices[i] = subarray[0];
			total_len += subarray[1] - subarray[0];
		}
		
		int[] result = new int[total_len];
		int result_index = 0;
		
		while (true) {
			int curr_min = 0;
			int min_index = -1;
			int curr_array = -1;
			for (int i = 0; i < subarrays.size(); i++) {
				int curr_index = indices[i];
				Integer[] curr_subarray = subarrays.get(i);
				if (curr_index < curr_subarray[1]) {
					if (min_index == -1 || (array[curr_index] < curr_min)) {
						min_index = curr_index;
						curr_array = i;
						curr_min = array[curr_index];
					}
				}
			}
			if (min_index == -1)
				break;
			result[result_index++] = array[indices[curr_array]++];
		}
		return result;
	}
	
	static void find_monotonic_subarrays(int[] array) {
		// increasing subarray includes bottom but not top
		// decreasing subarray includes top but not bottom
		int last_extreme = 0;
		int j = 1;
		int slope = array[1] - array[0];
		ArrayList<Integer[]> curr_subarrays = null; 
		while (j < array.length - 1) {
			int new_slope = array[j + 1] - array[j];
			if (Math.signum(slope) != Math.signum(new_slope)) {
				if (new_slope < 0) {
					curr_subarrays = increasing;
				}
				else if (new_slope > 0) {
					curr_subarrays = decreasing;
				}
				else {
					if (slope > 0) {
						curr_subarrays = increasing;
					}
					else {
						curr_subarrays = decreasing;
					}
				}
				curr_subarrays.add(new Integer[]{last_extreme, j + 1});
				last_extreme = j + 1;
				slope = new_slope;
			}
			//slope = array[j + 1] - array[j];
			j++;
		}
		
		/*
		if (bottom < top)
			decreasing.add(new Integer[]{top, array.length});
		else if (top < bottom)
			increasing.add(new Integer[]{bottom, array.length});
		else {
			if (array[0] <= array[array.length - 1]) 
				increasing.add(new Integer[]{bottom, array.length});
			else
				decreasing.add(new Integer[]{top, array.length});
		}
		*/
		
		//int last_extreme = Math.max(bottom, top);
		if (array[last_extreme] < array[array.length - 1])
			increasing.add(new Integer[]{last_extreme, array.length});
		else
			decreasing.add(new Integer[]{last_extreme, array.length});


	}
	
	static void sort_array(int[] array) {
		
		if (array.length <= 1)
			return;
		if (array.length == 2) {
			if (array[0] > array[1]) {
				int tmp = array[0];
				array[0] = array[1];
				array[1] = tmp;
			}
			return;
		}
		find_monotonic_subarrays(array);
		for (Integer[] i: increasing)
			System.out.printf("[%d, %d] ", i[0], i[1]);
		System.out.println();
		for (Integer[] i: decreasing)
			System.out.printf("[%d, %d] ", i[0], i[1]);
		System.out.println();
		// Reverse decreasing subarrays
		for (Integer[] s: decreasing) {
			for (int i = 0; i < (s[1] - s[0])/2; i++) {
				int temp = array[s[0] + i];
				array[s[0] + i] = array[s[1] - i - 1];
				array[s[1] - i - 1] = temp;
			}
		}
		increasing.addAll(decreasing);
		int[] result = n_way_merge(array, increasing, true);
		System.arraycopy(result, 0, array, 0, array.length);
		return;
	}
	
	public static void main(String[] args) {
		final int len = 100;
		int[] array = new int[len];
		Random rg = new Random();
		for (int i = 0; i < len; i++)
			array[i] = rg.nextInt(len);
		
		//array = new int[]{8, 7, 4, 2, 9, 0, 8, 8, 9, 1 };
		int[] array_copy = array.clone();
		
		for (int i: array)
			System.out.printf("%d ", i);
		System.out.println();

		sort_array(array);

		
		for (int i: array)
			System.out.printf("%d ", i);
		System.out.println();
		
		Arrays.sort(array_copy);
		for (int i: array_copy)
			System.out.printf("%d ", i);
		System.out.println();

		boolean equal = true;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != array_copy[i])
				equal = false;
		}
		System.out.println(equal);
		/*
		for (Integer[] i: increasing)
			System.out.printf("[%d, %d] ", i[0], i[1]);
		System.out.println();
		for (Integer[] i: decreasing)
			System.out.printf("[%d, %d] ", i[0], i[1]);
		System.out.println();
		*/
		
		
	}
}
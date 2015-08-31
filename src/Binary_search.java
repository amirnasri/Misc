

public class Binary_search {
	/*
	static int binary_search(int key, int[] array) {
		int low = 0; 
		int high = array.length - 1;
		int mid = 0;
		
		while (low <= high) {
			mid = (low + high)/2;
			int mid_val = array[mid];
			if (key == mid_val)
				return mid;
			
			if (key < mid_val) {
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
		}
		return mid;
	}
	*/
	
	// New (better) implementation
	static <T extends Comparable> int binary_search(T key, T[] arr, int low, int high) {
		int m;
		T middle;
		while (low < high) {
			m = (low + high)/2;
			middle = arr[m];
			if (key == middle)
				return m;
			else if (key.compareTo(middle) < 0)
				high = m;
			else
				low = m + 1;
		}
		return low;
	}
	
	public static void main(String[] args) {
		final int array_length = 5;
		Integer[] arr = new Integer[array_length];
		Random rg = new Random();
		for (int i = 0; i < array_length; i++) {
			arr[i] = rg.nextInt(2 * array_length);
		}
		
		Arrays.sort(arr);
		
		int index = binary_search(8, arr, 0, arr.length);
		
		for (int i: arr) {
			System.out.printf("%-6d", i);
		}
		System.out.println();
		
		System.out.println(index);
		System.out.println(String.format("%" + (int) (index *6 + 1) +"s", "-"));
		
	}

}


public class Binary_search {
	
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

	public static void main(String[] args) {
		int[] array = new int[] {1, 4, 7, 12};
		System.out.println(binary_search(14, array));
	}
}

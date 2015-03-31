
/*
 * Design an algorithm and write code to remove the duplicate characters in a string
	without using any additional buffer. NOTE: One or two additional variables are fine.
	An extra copy of the array is not.
	FOLLOW UP
	Write the test cases for this method.
	
	Better solution: use quick sort to sort O(n log(n)) in place and then remove duplicates in O(n).
 */
public class CCI_Q1_3 {
	
	// CCI solution
	static int remove_duplicate1(int[] array) {
		if (array == null)
			return -1;
		if (array.length == 0)
			return 0;
		
		int tail = 1;
		int j;
		
		for (int i = 1; i < array.length; i++) {
			for (j = 0; j < tail; j++) {
				if (array[i] == array[j]) {
					break;
				}
			}

			if (j == tail) {
				array[tail] = array[i];
				tail++;
			}
		}
		return tail;
	}
	
	/*
	 * Use a double loop to look for duplicates. When a duplicate is found, move it to the end of the array
	 * and reduce the length by 1
	 * complexity = O(n^2)
	 */
	static int remove_duplicate(int[] array) {
		
		if (array == null)
			return -1;
		
		int len = array.length;
		int i = 0, j;
		
		while (i < len - 1) {
			j = i + 1;
			while (j < len) {
				if (array[i] == array[j]) {
					int t = array[len-1];
					array[len-1] = array[j];
					array[j] = t;
					len--;
				}
				else {
					j++;
				}
			}
			i++;
		}
		return len;
	}
	
	public static void main(String[] args) {
		//int[] array = new int[] {1, 2, 7, 1, 4, 1, 6};
		//int[] array = new int[] {1, 2, 3, 4, 5, 6, 7};
		int[] array = new int[] {1, 1, 1, 2, 2, 2, 2};
		//int[] array = null;
		int new_len = remove_duplicate1(array);
		System.out.println(new_len);
		for (int i = 0; i < new_len; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

}

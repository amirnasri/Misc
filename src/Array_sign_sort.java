/*
 * Sort an array of numbers only based on their sign (-, 0, +). The order in each category is not important.
 */
public class Array_sign_sort {

	private static void swap(int[] array, int index1, int index2) {
		int t = array[index1];
		array[index1] = array[index2];
		array[index2] = t;
	}
	
	static void sort(int[] array) {
		int i = 0, j = 0, k = 0;
		
		while (k < array.length) {
			if (array[k] > 0) {
				k++;
			}
			else if (array[k] == 0) {
				swap(array, j, k);
				k++;
				j++;
			}
			else {
				swap(array, j, k);
				swap(array, i, j);
				k++;
				j++;
				i++;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[15];
		
		for (int i = 0; i < array.length - 5; i++) {
			array[i] = (int) (Math.random() * 100) - 50;
			System.out.print(array[i] + " ");
		}
		System.out.println();
		System.out.println();
		
		sort(array);
		for (int i: array) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		
	}
}

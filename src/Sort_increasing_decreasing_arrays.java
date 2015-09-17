import java.util.ArrayList;


class Sort_increasing_decreasing_arrays {
	static ArrayList<Integer[]> increasing = new ArrayList<>();
	static ArrayList<Integer[]> decreasing = new ArrayList<>();
	
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
				
		int j = 0;
		// increasing subarray includes bottom but not top
		// decreasing subarray includes top but not bottom
		int top = 0;
		int bottom = 0;
		while (j < array.length - 2) {
			if (array[j + 1] > Math.max(array[j], array[j + 2])) {
				top = j + 1;
				increasing.add(new Integer[]{bottom, top});
			}
			else if (array[j + 1] < Math.min(array[j], array[j + 2])) {
				bottom = j + 1;
				decreasing.add(new Integer[]{top, bottom});
			}
			j++;
		}
		
		if (array[array.length - 1] > array[array.length - 2])
			increasing.add(new Integer[]{bottom, array.length});
		else
			decreasing.add(new Integer[]{top, array.length});
	}
	public static void main(String[] args) {
		int[] array = new int[]{1, 2};
		sort_array(array);
		for (Integer[] i: increasing)
			System.out.printf("[%d, %d] ", i[0], i[1]);
		System.out.println();
		for (Integer[] i: decreasing)
			System.out.printf("[%d, %d] ", i[0], i[1]);
	}
}
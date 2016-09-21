import java.util.Arrays;


public class Test {

	static class Node {
		int i;
		Node(int i) {
			this.i = i;
		}
		public String toString() {
			return String.valueOf(i) + "  ";
		}
	}
	
	static <T> void print_array(T[] array) {
		for (T item: array)
			System.out.print(item);
		System.out.println();
	}
	
	public static void main(String[] args) {
		Node[] array = new Node[] {new Node(1), new Node(3), new Node(2)};
		print_array(array);
		//Node[] array_copy = array.clone();
		Node[] array_copy = Arrays.copyOf(array, array.length);
		//System.arraycopy(src, srcPos, dest, destPos, length);
		print_array(array_copy);
		array[1].i = 10;
		print_array(array_copy);
		
		Object o = new Node(20).clone();
		
	}
}

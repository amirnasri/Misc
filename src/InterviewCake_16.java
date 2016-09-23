
public class InterviewCake_16 {

	// https://www.interviewcake.com/question/python/cake-thief
	
	static class Cake_tuple {
		int weight;
		int value;
		
		public Cake_tuple(int weigth, int value) {
			this.weight = weigth;
			this.value = value;
		}
		
		public Cake_tuple() {
			this(0, 0);
		}
	}
	
	static int max_duffel_bag_value(Cake_tuple[] cake_tuples, int capacity) {
		
		for (Cake_tuple c: cake_tuples)
			if (c.weight == 0 && c.value != 0)
				return -1;
		
		int[] max_values = new int[capacity + 1];
		max_values[0] = 0;
		for (int cap = 1; cap <= capacity; cap++) {
			int max_value = 0;
			for (Cake_tuple c: cake_tuples) {
				if (cap - c.weight >= 0) {
					max_value = Math.max(max_value, max_values[cap - c.weight] + c.value);
				}
			}
			max_values[cap] = max_value;
			System.out.printf("capacity[%d] = %d\n", cap, max_value);
		}
		return max_values[capacity];
	}
	
	public static void main(String[] args) {

		final int cake_types = 4;
		Cake_tuple[] cake_tuples = new Cake_tuple[cake_types];
		cake_tuples[0] = new Cake_tuple(7, 160);
		cake_tuples[1] = new Cake_tuple(3, 90);
		cake_tuples[2] = new Cake_tuple(2, 15);
		cake_tuples[3] = new Cake_tuple(0, 0);

		System.out.println(max_duffel_bag_value(cake_tuples, 20));
	}

}

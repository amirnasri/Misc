import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.ArrayList;

class Overlapping_intervals {
	
	private static final int m = 6;
	private static Interval[] intervs;
	
	static class Interval {
		private int l, h;
		Interval(int l, int h) {
			this.l = l;
			this.h = h;
		}
		Interval(Interval i) {
			this(i.l, i.h);
		}
		Interval() {
			this(0, 0);
		}
		void print() {
			System.out.println("[" + l + ", " + h + "]");
		}
	}

	
	static void find_overlaps(Interval[] intervs) {
		Arrays.sort(intervs, new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				if  (i1.l < i2.l)
					return -1;
				else if (i1.l > i2.l)
					return 1;
				else 
					return 0;
			}
		});
		Interval curr = new Interval(intervs[0]);
		Interval next;
		for (int i = 1; i < m; i++) {
			next = new Interval(intervs[i]);
			if (curr.h < next.l) {
				curr.print();
				curr = next;
			}
			else {
				curr.h = next.h;
			}
		}
		
		curr.print();
	}
	
	// A better approad inspired by LaserShooting problem
	static void find_overlaps1(Interval[] intervals) {
		
		ArrayList<Integer[]> points = new ArrayList<>();
		for (Interval i: intervals) {
			points.add(new Integer[]{i.l, 1});
			points.add(new Integer[]{i.h, -1});
		}

		Collections.sort(points, new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] i1, Integer[] i2) {
				return Integer.compare(i1[0], i2[0]);
			}
		});
		
	
		int open_intervs = 0;
		Interval curr = new Interval(0, 0);
		for (int i = 0; i < points.size(); i++) {
			int new_point = points.get(i)[0];
			if (open_intervs == 0) {
				curr.l = new_point;
			}
			open_intervs += points.get(i)[1];
			System.out.printf("(%d, %d)   ", new_point, open_intervs);
			if (open_intervs == 0) {
				curr.h = new_point;
				//curr.print();
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		intervs = new Interval[m];
		intervs[0] = new Interval(0, 2);
		intervs[1] = new Interval(1, 4);
		intervs[2] = new Interval(10, 11);
		intervs[3] = new Interval(7, 9);
		intervs[4] = new Interval(10, 14);
		intervs[5] = new Interval(3, 6);

		find_overlaps(intervs);
		System.out.println();
		find_overlaps1(intervs);
		
		
	}

}

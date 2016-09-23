/*
 * Given a list of intervals, merge overlapping intervals and print the resulting intervals.
 * Todo: https://www.hackerrank.com/challenges/x-and-his-shots
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

class Overlapping_intervals {
	
	private static final int m = 9;
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
		public String toString() {
			return "[" + l + ", " + h + "]   ";
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

		for (Interval i: intervs) {
			System.out.print(i);
		}
		System.out.println();

		Interval curr = new Interval(intervs[0]);
		Interval next;
		for (int i = 1; i < m; i++) {
			next = new Interval(intervs[i]);
			if (curr.h < next.l) {
				System.out.print(curr);
				curr = next;
			}
			else {
				curr.h = Math.max(curr.h, next.h);
			}
		}
		
		System.out.println(curr);
	}
	
	// A better approach inspired by LaserShooting problem
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
		Interval curr = null;
		for (int i = 0; i < points.size(); i++) {
			int new_point = points.get(i)[0];
			if (open_intervs == 0) {
				if (curr == null) {
					curr = new Interval(new_point, 0);
				}
				else {
					if (new_point != curr.h) {
						System.out.print(curr);
						curr.l = new_point;
					}
				}
			}
			open_intervs += points.get(i)[1];
			if (open_intervs == 0) {
				curr.h = new_point;
			}
		}
		System.out.println(curr);
	}
	
	public static void main(String[] args) {
		
		intervs = new Interval[m];
		intervs[0] = new Interval(0, 2);
		intervs[1] = new Interval(1, 4);
		intervs[2] = new Interval(10, 11);
		intervs[3] = new Interval(7, 9);
		intervs[4] = new Interval(10, 14);
		intervs[5] = new Interval(3, 6);
		intervs[6] = new Interval(14, 14);
		intervs[7] = new Interval(14, 14);
		intervs[8] = new Interval(14, 15);
		
		List<Interval> interv_list = Arrays.asList(intervs);
		Collections.shuffle(interv_list);
		intervs = (Interval[]) interv_list.toArray();

		for (Interval i: intervs) {
			System.out.print(i);
		}
		System.out.println();

		find_overlaps(intervs);
		find_overlaps1(intervs);
		
		
	}

}

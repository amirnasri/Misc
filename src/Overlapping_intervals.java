import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class Overlapping_intervals {
	
	static final int m = 6;
	static Interval[] intervs;
	
	static class Interval {
		int l, h;
		Interval(int l, int h) {
			this.l = l;
			this.h = h;
		}
		void print() {
			System.out.println("[" + l + ", " + h + "]");
		}
	}
	static boolean merge(Interval i1, Interval i2, Interval i) {
		i.l = i1.l;
		if (i1.h < i2.l)
			return false;
		if (i1.h < i2.h)
			i.h = i2.h;
		else
			i.h = i1.h;
		return true;
	}
	
	public static void main(String[] args) {
		
		intervs = new Interval[m];
		intervs[0] = new Interval(0, 2);
		intervs[1] = new Interval(1, 4);
		intervs[2] = new Interval(10, 11);
		intervs[3] = new Interval(7, 9);
		intervs[4] = new Interval(10, 14);
		intervs[5] = new Interval(3, 6);

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
		Interval curr = intervs[0];
		Interval next;
		for (int i = 1; i < m; i++) {
			next = intervs[i];
			if (curr.h < next.l) {
				curr.print();
				curr = next;
			}
			else {
				curr.h = next.h;
			}
		}
		
		curr.print();
		
		
		
		/*
		while (i < m) {
			int l = intervs[i][0];
			int h = intervs[i][1];
			
			i++;
			while (true) {
				int new_l = intervs[i][0];
				int new_h = intervs[i][1];
				if (i >= m) {
					System.out.print("[ " + l + ", " + h + "]");
					break;
				}
				if (new_h < h)
					continue;
				else if (new_h > h && new_l < h)
					h = new_h;
				System.out.print("[ " + l + ", " + h + "]");
				break;
			}
		}
		*/
	}

}

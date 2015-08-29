
public class Overlapping_intervals {
	
	static final int m = 5;
	static Interval[] intervs;
	
	class Interval {
		int l, h;
		Interval(int l, int h) {
			this.l = l;
			this.h = h;
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
		Interval curr = intervs[0];
		Interval next, merged = new Interval(0, 0);
		for (int i = 1; i < m; i++) {
			next = intervs[i];
			if (merge(curr, next, merged))
				curr = merged;
			else {
				curr.print();
				curr = next;
			}
		}
		
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

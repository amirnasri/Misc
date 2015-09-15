import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;



/*
 * Sep 14, 2015
 * TopCoder SRM 431 Round 1 - Division I, Level One
 * link: http://community.topcoder.com/stat?c=problem_statement&pm=10258&rd=13522
 */

class LaserShooting {

	static double target_length(double[][] intervals) {
		
		double[][] points = new double[2 * intervals.length][2];
		for (int i = 0; i < intervals.length; i++) {
			points[2 * i][0] = intervals[i][0];
			points[2 * i][1] = 1.0;
			
			points[2 * i + 1][0] = intervals[i][1];
			points[2 * i + 1][1] = -1.0;
		}

		Arrays.sort(points, new Comparator<double[]>() {
			@Override
			public int compare(double[] i1, double[] i2) {
				return Double.compare(i1[0], i2[0]);
			}
		});
		
	
		int open_intervs = 0;
		double target_length = 0;
		double prev_point = 0;
		for (int i = 0; i < points.length; i++) {
			double new_point = points[i][0];
			
			target_length += open_intervs * (new_point - prev_point); 
			
			open_intervs += points[i][1];
			prev_point = new_point;
		}
		return target_length;
	}
	
	static double[][] convert_to_angles(int[] x, int[] y1, int[] y2) {
		double[][] angles = new double[x.length][2];
		for (int i = 0; i < x.length; i++) {
			double a1 = Math.atan(((double)y1[i])/x[i]);
			double a2 = Math.atan(((double)y2[i])/x[i]);
			angles[i][0] = Math.min(a1, a2);
			angles[i][1] = Math.max(a1, a2);
		}
		return angles;
	}
	
	static double numberOfHits(int[] x, int[] y1, int[] y2) {
		double[][] angles = convert_to_angles(x, y1, y2);
		return target_length(angles)/Math.PI;
	}
	
	public static void main(String[] args) {
		int[] x = {134,298,151,942};
		int[] y1 = {-753,-76,19,568};
		int[] y2 = {440,689,-39,672};
		System.out.println(numberOfHits(x, y1, y2));
		
		int[][] int_array = new int[][] {{10}, {1, 3}, {3, 4, 5}};
	}

}

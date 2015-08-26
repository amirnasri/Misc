/*
 * A matrix of random numbers is given. Find the path from top-left corner to bottom-right corner that
 *  has the largest mininum of numbers on the path.
 */

import java.util.LinkedList;
import java.util.Random;

public class Find_path_min_maze {
	
	class Node {
		int i, j;
		Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	class Ret_val {
		LinkedList<Node> l;
		int min;
		Ret_val(LinkedList<Node> l, int min) {
			this.l = l;
			this.min = min;
		}
	}
	
	static int[][] matrix;
	// Matrix dimensions
	static final int m = 10;
	static final int n = 20;
	
	static Ret_val find_path(int i, int j) {
		
		if (i == m-1 && j == n-1) {
			LinkedList<Node> l = new LinkedList<>();
			l.add(new Node(m-1, n-1));
			return new Ret_val(l, matrix[m-1][n-1]);
		}
		
		Ret_val rv, rv1, rv2;
		rv = new Ret_val();
		
		if (i + 1 <= m - 1) {
			rv1 = find_path(i + 1, j);
		}
		if (j + 1 <= n - 1) {
			rv2 = find_path(i, j + 1);
		}
		
		if (rv1.min > rv2.min) {
			rv.min = Math.min(rv1.min, matrix[i][j]);
			rv.l = rv1.l;
			
		}
		else {
			rv.min = Math.min(rv2.min, matrix[i][j]);
			rv.l = rv2.l;
		}
		rv.l.add(new Node(i, j));
		
		return rv;
		
	}
	
	public static void main(String[] args) {

		Random rand_gen = new Random();
		matrix = new int[m][n];
		for (int i=0; i < m; i++) {
			for (int j=0; j < n; j++) {
				matrix[i][j] = rand_gen.nextInt(100);
				System.out.print(matrix[i][j] + "  ");
			}
			System.out.println();
		}
	}
}
/*
 * A matrix of random numbers is given. Find the path from top-left corner to bottom-right corner for which 
 *  minimum of numbers on the path is maximized.
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Find_path_min_maze {
	
    private final static String setPlainText = "\033[0;0m";
    private final static String setBoldText = "\033[0;1m";

    static int[][] matrix;
    // Matrix dimensions
    static int m, n;
	
    
    static class Node {
		int i, j;
		Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
		@Override
		public boolean equals(Object o) {
			if (o == null)
				return false;
			if (this == o)
				return true;
			if (!(o instanceof Node))
				return false;
			Node n = (Node) o;
			
			return n.i == i && n.j == j;
		}
		
		@Override
		public int hashCode() {
			return i + j * 31;
		}
	}
	
	static class Ret_val {
		LinkedList<Node> l;
		int min;
		Ret_val(LinkedList<Node> l, int min) {
			this.l = l;
			this.min = min;
		}

		Ret_val() {
			this(null, 0);
		}
		
		void print() {
			System.out.println("Min= " + min);
			for (Node n: l) {
				System.out.print(setBoldText + "(" + n.i + ", " + n.j + ")  " + setPlainText);
			}
			System.out.println();
		}
	}
	
	static Ret_val find_path(int i, int j) {
		
		if (i == m-1 && j == n-1) {
			LinkedList<Node> l = new LinkedList<>();
			l.add(new Node(m-1, n-1));
			return new Ret_val(l, matrix[m-1][n-1]);
		}
		
		Ret_val rv1=null, rv2=null;
		
		if (i + 1 <= m - 1) {
			rv1 = find_path(i + 1, j);
		}
		if (j + 1 <= n - 1) {
			rv2 = find_path(i, j + 1);
		}
		
		if (rv1 == null) {
			rv2.min = Math.min(rv2.min, matrix[i][j]);
			rv2.l.addFirst(new Node(i, j));
			return rv2;
		}
		
		if (rv2 == null) {
			rv1.min = Math.min(rv1.min, matrix[i][j]);
			rv1.l.addFirst(new Node(i, j));
			return rv1;
		}

		Ret_val rv = new Ret_val();
		if (rv1.min >= rv2.min) {
			rv.min = Math.min(rv1.min, matrix[i][j]);
			rv.l = rv1.l;
			
		}
		else {
			rv.min = Math.min(rv2.min, matrix[i][j]);
			rv.l = rv2.l;
		}
		rv.l.addFirst(new Node(i, j));
		
		return rv;
		
	}
	
	static void print_path(LinkedList<Node> l) {
		HashSet<Node> hs = new HashSet<>(l);
		
		for (int i=0; i < m; i++) {
			for (int j=0; j < n; j++) {
				if (hs.contains(new Node(i, j)))
					System.out.print(setBoldText + matrix[i][j] + "\t" + setPlainText);
				else
					System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter m: ");
		m = scanner.nextInt();
		System.out.print("Enter n: ");
		n = scanner.nextInt();
		scanner.close();
		Random rand_gen = new Random();
		matrix = new int[m][n];
		for (int i=0; i < m; i++) {
			for (int j=0; j < n; j++) {
				matrix[i][j] = rand_gen.nextInt(100);
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
		
		Ret_val rv = find_path(0, 0);
		rv.print();
		print_path(rv.l);
	}
}
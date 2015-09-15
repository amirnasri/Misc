
/*
 * September 8th, 2015
 * 
 * Suppose there's a rabbit on the edge of a stream. In the stream, at unit sized spaces, there are potentially rocks, 
 * i.e. for each space in the stream, there is either a rock there, or there isn't. The rabbit can hop onto a rock,
 *  but can't swim. If the rabbit can initially jump one space, then for each subsequent jump, jump n + 1, n, or n - 1 spaces, 
 *  where n is the number of spaces previously jumped, design an algorithm to determine if the rabbit can successfully cross an arbitrary stream. 
 *  
 *   Improvements:
 *   	- Print the path using backtracking
 *   	- Find all possible paths instead of one
 *   	- Use an iterative algorithm such as BFS to find the path on the tree structure of jumps.
 *   		Finds the shortest path.
 */

public class Rabbit_and_stones {
	// position 0 is left side of stream and position n is the right side.
	static int n;
	// Arrar of stone distances.
	static int[] stones;
	// stone_positions[i] is true if there is a stone at position i.
	static boolean[] stone_positions;
	
	static boolean can_pass(int pos, int prev_jump) {
		if (pos >= n) {
			System.out.println(pos);
			return true;
		}
		if (!stone_positions[pos])
			return false;
		
		int new_jump;
		
		new_jump = prev_jump + 1;
		if (new_jump > 0 && can_pass(pos + new_jump, new_jump)) {
			System.out.println(pos);
			return true;
		}
		
		new_jump = prev_jump;
		if (new_jump > 0 && can_pass(pos + new_jump, new_jump)) {
			System.out.println(pos);
			return true;
		}

		new_jump = prev_jump - 1;
		if (new_jump > 0 && can_pass(pos + new_jump, new_jump)) {
			System.out.println(pos);
			return true;
		}
				
		return false;
	}
	
	public static void main(String[] args) {
		n = 8;
		stones = new int[] {1, 2, 3, 4, 5, 7};
		stone_positions = new boolean[n];
		for (int i: stones) {
			stone_positions[i] = true;
		}
		stone_positions[0] = true;
		
		System.out.println(can_pass(0, 0));
	}
}

import java.util.LinkedList;

class Tree_walk {
	
	static int[] parent;
	static LinkedList<Integer>[] children;
	static int n;
	static int[] visited_nodes;

	static void find_children() {
		
		children = new LinkedList[n];
	
		for (int i=0; i < parent.length; i++) {
			int p = parent[i];
			if (children[p] == null)
				children[p] = new LinkedList<Integer>();
			children[p].add(i+1);
		}

	}
	
	static int max_nodes_visited(int node, int steps) {
		
		if (steps == 0)
			return (visited_nodes[node] == 1? 1:0);
		
		int nodes_visited = 0;

		if (node != 0) {
			int p = parent[node-1];
			visited_nodes[p]++;
			nodes_visited = max_nodes_visited(p, steps-1);
			visited_nodes[p]--;
		}
		
		if (children[node] != null) {
			for (int child: children[node]) {
				visited_nodes[child]++;
				nodes_visited = Math.max(nodes_visited, max_nodes_visited(child, steps-1));
				visited_nodes[child]--;
			}
		}
		
		System.out.println(nodes_visited);
		
		return nodes_visited + (visited_nodes[node] == 1? 1:0);
	}
	
	public static void main(String[] args) {
		parent = new int[] {0,0,0,1,1,3,5,1,4,5,2,2,10,5,10,10,11,13,8,3,18,15,20,20,23,8,11,26,4};
		
		n = parent.length + 1;
		find_children();
		visited_nodes = new int[n];
		visited_nodes[0] = 1;
		int max_nodes_visited = max_nodes_visited(0, 26);
		System.out.println(max_nodes_visited);
	}
}
import java.util.HashSet;

public class Find_common_node {
	
	
	
	public static class Linked_list1<T>{
		
		private Node head;
		
		class Node {
			T data;
			Node next;
			
			Node(T data) {
				this.data = data;
				next = null;
			}
		}
		
		Linked_list1() {
			head = new Node(null);
		}
		
		public void add(Node n, Node prev, Node next) {
			n.next = next;
			prev.next = n;
		}
		
		public void add_first(Node n) {
			add(n, head, head.next);
		}
		
		public void delete(Node prev) {
			if (prev == null || prev.next == null)
				return;
			
			prev.next = prev.next.next;
		}
		
		public void delete_frist() {
			delete(head);
		}
		
		public void print() {
			Node n = head.next;
			while (n != null) {
				System.out.print(n.data + " ");
				n = n.next;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Linked_list1<Object> ll1 = new Linked_list1<>();
		Linked_list1<Object> ll2 = new Linked_list1<>();
		Linked_list1<Object>.Node n1 = ll1.new Node("1"); 
		Linked_list1<Object>.Node n2 = ll1.new Node("2"); 
		Linked_list1<Object>.Node n3 = ll1.new Node("3"); 
		Linked_list1<Object>.Node n4 = ll1.new Node("4"); 
		Linked_list1<Object>.Node n5 = ll1.new Node("5"); 
		Linked_list1<Object>.Node n6 = ll1.new Node("6"); 
		Linked_list1<Object>.Node n7 = ll1.new Node("7"); 
		Linked_list1<Object>.Node n8 = ll1.new Node("8"); 
		Linked_list1<Object>.Node n9 = ll1.new Node("9"); 
		Linked_list1<Object>.Node n10 = ll1.new Node("10"); 
		ll1.add_first(n10);
		ll1.add_first(n4);
		ll1.add_first(n3);
		ll1.add_first(n2);
		ll1.add_first(n1);
		ll1.print();
		
		ll2.add_first(n4);
		ll2.add_first(n5);
		ll2.add_first(n6);
		ll2.add_first(n7);
		ll2.add_first(n8);
		ll2.add_first(n9);
		ll2.print();
		
		HashSet<Linked_list1.Node> hash_set = new HashSet<>();
		
		Linked_list1<Object>.Node cur = ll1.head.next;
		
		while (cur != null) {
			hash_set.add(cur);
			cur = cur.next;
		}
		
		cur = ll2.head.next;
		while (cur != null) {
			if (hash_set.contains(cur))
				System.out.println(cur.data);
			cur = cur.next;
		}
	}
}

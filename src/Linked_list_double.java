
public class Linked_list_double<T> {

	Node head;
	
	class Node {
		Node next;
		Node prev;
		T data;
		
		Node(T data) {
			prev = null;
			next = null;
			this.data = data;
		}
		
		Node() {
			this(null);
		}
	}
	
	Linked_list_double(T[] data_array) {
		head = new Node();
		head.next = head;
		head.prev = head;
		
		for (T data: data_array) {
			add_last(new Node(data));
		}
	}
	
	Linked_list_double() {
		this(null);
	}
	
	void add(Node n, Node prev, Node next) {
		n.next = next;
		n.prev = prev;
		prev.next = n;
		next.prev = n;
	}
	
	void add_first(Node n) {
		add(n, head, head.next);
	}
	
	void add_last(Node n) {
		add(n, head.prev, head);
	}
	
	void delete(Node n) {
		Node prev = n.prev;
		Node next = n.next;
		prev.next = next;
		next.prev = prev;
	}
	
	void print() {
		Node n = head.next;
		while (n != head) {
			System.out.print(n.data + "  ");
			n = n.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Integer[] int_array = new Integer[] {1, 2, 3, 4};
		Linked_list_double ll = new Linked_list_double<Integer>(int_array);
		ll.print();
		
	}

}

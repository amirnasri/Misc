
public class Linked_list<T> implements Iterable<T>{
	
	Node head;
	
	class Node {
		T data;
		Node next;
		Node(T data) {
			this.data = data;
			next = null;
		}
	}
	
	Linked_list() {
		head = new Node(null);
	}
	
	public void add(Node n, Node prev, Node next) {
		n.next = next;
		prev.next = n;
	}
	
	public void add_first(Node n) {
		add(n, head, head.next);
	}
	
	public void add_first(T data) {
		add(new Node(data), head, head.next);
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
	
	class Iterator {
		Node cur;
		Iterator() {
			cur = head;
		}
		
		boolean has_next() {
			return (cur.next != null);
		}
		
		Node get_next() {
			if (!has_next())
				return null;
			cur = cur.next;
			return cur; 
		}
	}
	
	public Iterator get_iterator() {
		return new Iterator();
	}
	
	public static void main(String[] args) {
		
	}

	@Override
	public java.util.Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}

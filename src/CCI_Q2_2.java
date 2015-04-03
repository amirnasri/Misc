
/*
 * Implement an algorithm to find the nth to last element of a singly linked list.
 */

class CCI_Q2_2 {

	static <T> Linked_list<T>.Node nth_to_last(Linked_list<T> ll, int n) {
		Linked_list<T>.Node cur = ll.head.next;
		
		if (cur == null)
			return null;
		
		int i = 0;
		while (cur.next != null && i < n) {
			i++;
			cur = cur.next;
		}
		if (i != n)
			return null;
		
		Linked_list<T>.Node runner = ll.head.next;
		
		while (cur.next != null) {
			runner = runner.next;
			cur = cur.next;
		}
		
		return runner;
	}
	
	public static void main(String[] args) {
		Linked_list<String> ll = new Linked_list<>();
		ll.add_first("1");
		ll.add_first("2");
		ll.add_first("3");
		ll.add_first("4");
		
		ll.print();
		
		System.out.println(nth_to_last(ll, 4));
		
	}
}

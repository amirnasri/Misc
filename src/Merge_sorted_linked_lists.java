import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

class Peekable_iterator<T> implements Iterator<T> {
	ListIterator<T> li_;
	Peekable_iterator(ListIterator<T> li) {
		li_ = li;
	}
	@Override
	public boolean hasNext() {
		return li_.hasNext();
	}
	@Override
	public T next() {
		return li_.next();
	}
	
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
	public T peek() {
		if (!li_.hasNext())
			return null;
		T item = li_.next();
		li_.previous();
		return item;
	}
}

public class Merge_sorted_linked_lists {
	
	static void merge(LinkedList<Integer> l1, LinkedList<Integer> l2, LinkedList<Integer> l3) {
		Peekable_iterator<Integer> pit1 = new Peekable_iterator<>(l1.listIterator());
		Peekable_iterator<Integer> pit2 = new Peekable_iterator<>(l2.listIterator());

		Integer i1 = null, i2 = null;
		while (pit1.hasNext() && pit2.hasNext()) {
			i1 = pit1.peek();
			i2 = pit2.peek();
			
			if (i1 < i2) {
				l3.add(i1);
				pit1.next();
			}
			else {
				l3.add(i2);
				pit2.next();
			}
		}
		
		
		while (pit1.hasNext()) {
			//it3.add(it1.next());
			l3.add(pit1.next());
		}

		while (pit2.hasNext()) {
			//it3.add(it2.next());
			l3.add(pit2.next());
		}
	}
	
	public static void main(String[] args) {
		
		LinkedList<Integer> l1 = new LinkedList<Integer>(Arrays.asList(new Integer[]{20, 24}));
		LinkedList<Integer> l2 = new LinkedList<>(Arrays.asList(new Integer[]{3, 6, 8, 9, 10}));
		LinkedList<Integer> l3 = new LinkedList<>();
		
		merge(l1, l2, l3);
		
		for (Integer i: l3) {
			System.out.print(i + "  ");
		}
		System.out.println();
	}
	
}

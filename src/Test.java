import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Map.Entry;

public class Test {
	
	static String eyesight(int A, int B) throws Exception {
		
		int same_digit = 0;
		int digit_num = 0;
		while (A != 0) {
			if (A%10 == B%10)
				same_digit++;
			A = A/10;
			B = B/10;
			digit_num++;
		}
		if (B != 0)
			throw new Exception();
		return (same_digit == digit_num || same_digit == digit_num - 1? "happy" : "glasses");
	}

	
	private static Comparator<String> ALPHABETICAL_ORDER = new Comparator<String>() {
	    public int compare(String str1, String str2) {
	        int res = String.CASE_INSENSITIVE_ORDER.compare(str1, str2);
	        if (res == 0) {
	            res = str1.compareTo(str2);
	        }
	        return res;
	    }
	};

	
	public static void main(String[] args) throws Exception {
		LinkedList<String> l = new LinkedList<>(Arrays.asList(new String[] {"a", "b", "c", "d", "e"}));
		/*
		for (String s: l) {
			System.out.printf("%-5s", s);
		}
		System.out.println();
		
		ListIterator<String> li = l.listIterator();
		li.next();
		li.next();
		li.next();
		li.previous();
		System.out.println(li.previous());
		li.remove();
		li.next();
		li.remove();
		li.add("d");
		li.add("d");
		li.add("d");
		li.add("d");
		for (String s: l) {
			System.out.printf("%-5s", s);
		}
		System.out.println();
		*/
		
		//ListIterator<String> li1 = l.listIterator(); 
		//ListIterator<String> li2 = l.listIterator();
		//li1.add("fdf");
		//li1.add("1");
		//l.addFirst("2");
		
		//li2.next();
		//while (li1.hasNext() && li2.hasNext())
		//	System.out.println(li1.next() + " " + li2.next());
		/*
		System.out.println(eyesight(508, 540));
		
		String[] string_array = new String[] {"development", "Development", "aa", "aBc", "AA", "Aa"};
		Arrays.sort(string_array);
		
		for (int i = 0; i < string_array.length; i++) 
			System.out.format("%s   ", string_array[i]);
		System.out.println();
		*/
		List<String> list = new ArrayList();
		list.add("development");
		list.add("Development");
		list.add("aBc");
		list.add("aa");
		list.add("AA");
		list.add("Aa");
		
		//Collections.sort(list);
		
		Collections.sort(list, ALPHABETICAL_ORDER);

		for (String s: list) 
			System.out.format("%s   ", s);
		System.out.println();

		/*
		HashMap<String, String> hm = new HashMap<>();
		hm.put("a", "1");
		hm.put("b", "1");
		hm.put("c", "2");
		hm.put("d", "3");
		
		for (Map.Entry<String, String> s: hm.entrySet()) 
			System.out.printf("%s  ", s.getKey());
		*/
		
		class D extends AbstractSet<String> {

			@Override
			public Iterator<String> iterator() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int size() {
				// TODO Auto-generated method stub
				return 0;
			}
			
		}
		
		Set<String> s = new D();
		
		class T implements Comparable<T>{
			int key;
			int value;
			
			T(int key, int value) {
				this.key = key;
				this.value = value;
			}
			public int compareTo(T t) {
				return Integer.compare(key, t.key);
			}
		}
		
		final int len = 20;
		int[] array = new int[len];
		Random r = new Random();
		for (int i= 0; i < len; i++)
			array[i] = r.nextInt(200);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		
		for (int j: array) {
			System.out.printf("%d   ", j);
		}
		System.out.println();

		final int k = 5;
		for (int i = 0; i < len; i++) {
			pq.add(array[i]);
			if (pq.size() > k) {
				pq.poll();
			}
			
			for (int j: pq) {
				System.out.printf("%d   ", j);
			}
			System.out.println();
			//System.out.println("----------------------------");
		}
	}
}

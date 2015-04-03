import java.util.HashMap;
import java.util.LinkedList;


public class LRU {

	private HashMap<String, Cache_value> hash_map;
	private Linked_list cache_history;
	
	class Node {
		private Node next;
		private Node prev;
		
		Node() {
			prev = next = null;
		}
	}
	
	class Linked_list {
		Node head;
		
		Linked_list() {
			head = new Node();
			head.next = head;
			head.prev = head;
		}
		
		void add(Node n, Node prev, Node next) {
			prev.next = n;
			n.next = next;
			n.prev = prev;
			next.prev = n;
		}
		
		void add_first(Node n) {
			add(n, head, head.next);
		}
		
		void delete(Node n) {
			Node prev = n.prev;
			Node next = n.next;
			prev.next = next;
			next.prev = prev;
		}
	}
	
	class Cache_value {
		String value;
		Node n;
	}
	
	Memory_cache() {
		hash_map = new HashMap<String, Cache_value>();
		cache_history = new Linked_list();
		
	}
	
	Cache_value find(String key) {
		Cache_value cache_val = hash_map.get(key);
		
		if (cache_val == null)
			return null;
		
		Node n = cache_val.n;
		cache_history.delete(n);
		cache_history.add_first(n);
		return cache_val;
	}
	
	void add(String key, String value) {
		
		Cache_value cache_val = find(key); 
		if (cache_val == null) {
			cache_val = new Cache_value();
			cache_val.value = value;
			cache_val.n = new Node();
			cache_history.add_first(cache_val.n);
			hash_map.put(key, cache_val);
		}
		else {
			cache_val.value = value;
		}
	}
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/*
 * Implementation of a hash table using LinkedList and HashCode() 
 */

public class Hash_map<K, V> {

	class Key_val_pair {
		K key;
		V value;
		Key_val_pair(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	
	private LinkedList<Key_val_pair>[] hash_array;
	private int capacity;
	
	@SuppressWarnings("unchecked")
	public Hash_map(int capacity) {
		this.capacity = capacity;
		hash_array = (LinkedList<Key_val_pair>[]) new LinkedList<?>[capacity];
	}
	
	private Key_val_pair get_(K key) {
		int bucket = hash_code(key);
		LinkedList<Key_val_pair> bucket_list = hash_array[bucket];
		if (bucket_list == null) {
			return null;
		}
		else {
			for (Key_val_pair kv: bucket_list) {
				if (kv.key.equals(key)) {
					return kv;
				}
			}
		}
		return null;
	}
	
	public V get(K key) {
		Key_val_pair kv = get_(key);
		if (kv == null)
			return null;
		else
			return kv.value;
	}
	
	public boolean add(K key, V value) {
		Key_val_pair kv = get_(key);
		if (kv == null) {
			int bucket = hash_code(key);
			LinkedList<Key_val_pair> bucket_list = hash_array[bucket];
			if (bucket_list == null) {
				bucket_list = new LinkedList<Key_val_pair>();
				hash_array[bucket] = bucket_list;
			}
			bucket_list.add(new Key_val_pair(key, value));
			return true;
		}
		else {
			kv.value = value;
			return false;
		}
	}
	
	private int hash_code(K key) {
		return ((key.hashCode() & 0x7fffffff) % capacity);
	}
	
	public static void main(String[] args) {
		Hash_map<String, Integer> hash_map = new Hash_map<>(16);
		
		hash_map.add("b", 2);
		System.out.println(hash_map.get("b"));
		hash_map.add("b", 3);
		System.out.println(hash_map.get("b"));
	}
}

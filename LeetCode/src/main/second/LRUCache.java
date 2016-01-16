package second;

import java.util.HashMap;

public class LRUCache {
	public class LRUCacheCustom<K, V> {
		private HashMap<K, Entry<K, V>> map = new HashMap<K, Entry<K, V>>();
		private int capacity;
		private Entry<K, V> head;
		
		private class Entry<K, V> {
			K key;
			V val;
			Entry<K, V> prev;
			Entry<K, V> next;
			
			private Entry(){}
			
			public Entry(K k, V v){
				key = k;
				val = v;
			}
		}
		
		public LRUCacheCustom(int capacity){
			this.capacity = capacity;
			head = new Entry<K, V>();
			//Use a dummy entry at first to construct a loop list
			head.next = head;
			head.prev = head;
		}
		
		public void set(K key, V val){
			Entry<K, V> entry = map.get(key);
			if(entry == null) {
				entry = new Entry<K, V>(key, val);
				map.put(key, entry);
				addFirst(entry);
			}else {
				entry.val = val;
				detach(entry);
				addFirst(entry);
			}
			
			if(map.size() > capacity) {
				removeLast();
			}
		}
		
		private void detach(Entry<K, V> entry){
			entry.prev.next = entry.next;
			entry.next.prev = entry.prev;
		}
		
		private void addFirst(Entry<K, V> entry){
			entry.next = head.next;
			head.next.prev = entry;
			head.next = entry;
			entry.prev = head;
		}
		
		private void removeLast(){
			Entry<K, V> last = head.prev;
			detach(last);
			map.remove(last.key);
		}
		
		
		public V get(K key){
			Entry<K, V> entry = map.get(key);
			if(entry == null) {
				return null;
			}
			
			detach(entry);
			addFirst(entry);
			return entry.val;
		}
	}
    
    private LRUCacheCustom<Integer, Integer> cache;
    
    public LRUCache(int capacity){
    	cache = new LRUCacheCustom<Integer, Integer>(capacity);
    }
    
    public int get(int key) {
        Integer val = cache.get(key);
        if(val == null){
        	return -1;
        }else{
        	return val;
        }
    }
    
    public void set(int key, int value) {
        cache.set(key, value);
    }
    
    public static void main(String[] args){
    	LRUCache cache = new LRUCache(10);
    	cache.set(1, 10);
    	cache.set(2, 20);
    	cache.set(3, 30);
    	cache.set(4, 40);
    	cache.set(5, 50);
    	cache.set(6, 60);
    	cache.set(7, 70);
    	cache.set(8, 80);
    	cache.set(9, 90);
    	cache.set(10, 100);
    	cache.set(11, 110);
    	cache.set(12, 120);
    	System.out.println(cache.get(1));
    	System.out.println(cache.get(2));
    	System.out.println(cache.get(3));
    	cache.set(13, 130);
    	System.out.println(cache.get(4));
    	System.out.println(cache.get(5));
    }
}
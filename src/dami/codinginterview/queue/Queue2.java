package dami.codinginterview.queue;

import java.util.*;

public class Queue2 {
	public void lruCache() {
		MyLRUCache cache = new MyLRUCache(3);
		cache.query(3);
		cache.print();

		cache.query(5);
		cache.print();
		cache.query(1);
		cache.print();
		cache.query(2);
		cache.print();
		cache.query(3);
		cache.print();
		cache.query(4);
		cache.print();
		cache.query(3);
		cache.print();
		cache.query(2);
		cache.print();
		cache.query(5);
		cache.print();

	}
}

class MyLRUCache {
	private final int cacheSize;
	private final Queue<Integer> cache;

	public MyLRUCache(int cacheSize) {
		this.cacheSize = cacheSize;
		this.cache = new LinkedList<>();
	}

	public void query(int number) {
		cache.remove(number);

		if (cache.size() == cacheSize) {
			cache.poll();
		}
		cache.offer(number);
	}

	public void print() {
		System.out.println(cache);
	}
}

class LRUCache<K, V> extends LinkedHashMap<K, V> {
	private final int cacheSize;

	private LRUCache(int cacheSize) {
		super(cacheSize, 0.75f, true);
		this.cacheSize = cacheSize;
	}

	public static <K, V> LRUCache<K, V> newInstance(int cacheSize) {
		return new LRUCache<>(cacheSize);
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return cacheSize < this.size();
	}

	public void query(int number) {
		//
	}

	public void print() {
		System.out.println(this);
	}
}

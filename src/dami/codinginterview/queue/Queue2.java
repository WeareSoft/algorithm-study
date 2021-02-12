package dami.codinginterview.queue;

import dami.Solution;

import java.util.*;

public class Queue2 {
	public void lruCache() {
		//MyLRUCache cache = new MyLRUCache(3);
		//LRUCache<Integer, Integer> cache = LRUCache.newInstance(3);
		Solution2 cache = new Solution2(3);
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

// 가장 기본적인 방법
class MyLRUCache {
	private final int cacheSize;
	private final Queue<Integer> cache;

	public MyLRUCache(int cacheSize) {
		this.cacheSize = cacheSize;
		this.cache = new LinkedList<>();
	}

	// 시간 : O(n). LinkedList의 remove는 해당 원소를 찾아서 삭제하기 때문에 한 번 순회 필요
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

// LinkedHashMap의 removeEldestEntry 메소드 활용
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

	public void query(K number) {
		put(number, (V) number);
	}

	public void print() {
		System.out.println(keySet());
	}
}

// 솔루션1. 더블링크드리스트와 Map 활용
class Solution1 {
	private final int cacheSize;
	private final Map<Integer, DoubleNode> map;
	private DoubleNode head, tail;

	public Solution1(int cacheSize) {
		this.cacheSize = cacheSize;
		this.map = new HashMap<>();
	}

	class DoubleNode {
		int value;
		DoubleNode prev;
		DoubleNode next;

		public DoubleNode(int value) {
			this.value = value;
		}
	}

	public void query(int number) {
		if (map.containsKey(number)) {
			DoubleNode node = map.get(number);
			remove(node);
			addToHead(node);
		} else {
			DoubleNode newNode = new DoubleNode(number);
			if (map.size() == cacheSize) {
				map.remove(tail.value);
				remove(tail);
			}
			addToHead(newNode);
			map.put(number, newNode);
		}
	}

	public void addToHead(DoubleNode node) {
		node.next = head;
		node.prev = null;

		if (head != null) {
			head.prev = node;
		}

		head = node;

		if (tail == null) {
			tail = head;
		}
	}

	public void remove(DoubleNode node) {
		if (node.prev != null) {
			node.prev.next = node.next;
		} else {
			head = node.next;
		}

		if (node.next != null) {
			node.next.prev = node.prev;
		} else {
			tail = node.prev;
		}
	}

	public void print() {
		DoubleNode current = this.head;
		while (current != null) {
			System.out.print(current.value + " ");
			current = current.next;
		}
		System.out.println();
	}

}

// 솔루션2. LinkedHashSet 사용
class Solution2 {
	private final int cacheSize;
	private final Set<Integer> cache;

	public Solution2(int cacheSize) {
		this.cacheSize = cacheSize;
		this.cache = new LinkedHashSet<>();
	}

	public void query(int number) {
		cache.remove(number);   // number 있으면 삭제 없으면 아무것도 안함

		if (cacheSize == cache.size()) {
			int first = cache.iterator().next();
			cache.remove(first);
		}

		cache.add(number);
	}

	public void print() {
		System.out.println(cache);
	}
}

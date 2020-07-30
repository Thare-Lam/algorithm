package com.thare.algorithm.mix;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {

    Map<Integer, Node> map;

    Node head, tail;

    int capacity;

    private static class Node {
        int key;
        int val;
        Node pre, next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node target = map.get(key);
        removeFromList(target);
        insertHead(target);
        return target.val;
    }

    public void put(int key, int value) {
        Node target;
        if (map.containsKey(key)) {
            target = map.get(key);
            target.val = value;
            removeFromList(target);
        } else {
            if (map.size() == capacity) {
                removeFromList(tail.pre);
                removeFromMap(tail.pre);
            }
            target = new Node(key, value);
            map.put(key, target);
        }
        insertHead(target);
    }

    private void insertHead(Node target) {
        target.next = head.next;
        target.pre = head;
        head.next.pre = target;
        head.next = target;
    }

    private void removeFromList(Node target) {
        target.pre.next = target.next;
        target.next.pre = target.pre;
    }

    private void removeFromMap(Node target) {
        map.remove(target.key);
    }

}

class LRUCache2 extends LinkedHashMap<Integer, Integer> {

    private final int capacity;

    public LRUCache2(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

}

package com.thare.algorithm.archive.lintcode._lru_cache;

import java.util.LinkedList;

public class LRUCache {

    private int capacity;

    private int i;

    private LinkedList<Item> list;

    // @param capacity, an integer
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.list = new LinkedList<>();
    }

    // @return an integer
    public int get(int key) {
        for (Item item : list) {
            if (item.key == key) {
                list.remove(item);
                list.addFirst(item);
                return item.value;
            }
        }
        return -1;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        for (Item item : list) {
            if (item.key == key) {
                item.value = value;
                list.remove(item);
                list.addFirst(item);
                return;
            }
        }
        Item item = new Item(key, value);
        if (i == capacity) {
            list.removeLast();
            --i;
        }
        list.addFirst(item);
        ++i;
    }

    private class Item {
        int key;
        int value;

        Item(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}

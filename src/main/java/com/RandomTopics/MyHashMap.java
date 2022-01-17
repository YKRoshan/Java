package com.RandomTopics;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class KeyValueEntry<K, V> {
    private K key;
    private V value;

    public KeyValueEntry() {
    }

    public KeyValueEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KeyValueEntry)) return false;
        KeyValueEntry<?, ?> that = (KeyValueEntry<?, ?>) o;
        return Objects.equals(getKey(), that.getKey()) &&
            Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKey(), getValue());
    }
}

class Bucket {
    private List<KeyValueEntry> list;

    public Bucket() {
        this.list = new ArrayList<>();
    }

    public void add(KeyValueEntry value) {
        list.add(value);
    }

    public void remove(KeyValueEntry value) {
        list.remove(value);
    }

    public List<KeyValueEntry> getList() {
        return list;
    }
}

public class MyHashMap<K, V> {
    private static final int CAPACITY = 100;
    private Bucket[] buckets;
    int size = 0;

    public MyHashMap() {
        buckets = new Bucket[CAPACITY];
    }

    public void put(K key, V value) {
        int hashCode = hashFunction(key);
        if (containsKey(key)) {
            Bucket bucket = buckets[hashCode];
            KeyValueEntry entry = new KeyValueEntry(key, value);
            bucket.add(entry);
        } else {
            Bucket bucket = new Bucket();
            bucket.add(new KeyValueEntry(key, value));
            buckets[hashCode] = bucket;
        }
        size++;
    }

    public V get(K key) {
        int hasCode = hashFunction(key);
        if (buckets[hasCode] == null) return null;
        List<KeyValueEntry> list = buckets[hasCode].getList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey() == key)
                return (V) list.get(i);
        }
        return null;
    }

    public int hashFunction(K key) {
        return key.hashCode() % CAPACITY;
    }

    public boolean containsKey(K Key) {
        int hashFunction = hashFunction(Key);
        if (buckets[hashFunction] == null)
            return false;
        return true;
    }

    public int getSize() {
        return size;
    }

}

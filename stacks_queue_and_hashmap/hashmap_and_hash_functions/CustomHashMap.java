package stacks_queue_and_hashmap.hashmap_and_hash_functions;

import java.util.LinkedList;

public class CustomHashMap<K, V>{
    private static final int size = 16;
    private LinkedList<Entry<K, V>>[] buckets;

    static class Entry<K, V>{
        K key;
        V value;
        Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    public CustomHashMap(){
        buckets = new LinkedList[size];
        for(int i=0; i<size; i++){
            buckets[i] = new LinkedList<>();
        }
    }
    private int getBucketIndex(K key){
        return Math.abs(key.hashCode() % size);
    }
    public void put(K key, V value){
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>>bucket = buckets[index];
        for(Entry<K, V>entry : bucket){
            if(entry.key.equals(key)){
                entry.value = value;
                return ;
            }
        }
        bucket.add(new Entry<>(key, value));
    }
    public V get(K key){
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>>bucket = buckets[index];
        for(Entry<K, V>entry : bucket){
            if(entry.key.equals(key)){
                return entry.value;
            }
        }
        return null;
    }
    public void remove(K key){
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>>bucket = buckets[index];
        for(Entry<K, V>entry : bucket){
            if(entry.key.equals(key)){
                bucket.remove(entry);
                return;
            }
        }
    }
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("apple", 10);
        map.put("banana", 20);
        map.put("orange", 30);

        System.out.println(map.get("banana"));
        map.remove("banana");
        System.out.println(map.get("banana"));
    }
}

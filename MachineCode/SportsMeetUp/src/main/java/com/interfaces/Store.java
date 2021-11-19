package main.java.com.interfaces;

import java.util.ArrayList;
import java.util.HashMap;

public class Store<K,V> implements IStore<K,V> {
    private HashMap<K, V> store;

    public Store() {
            store = new HashMap<>();
        }

    @Override
    public V add(K key, V document) {
        store.put(key, document);
        return document;
    }

    @Override
    public V get(K key) {
            return store.get(key);
        }

    @Override
    public ArrayList<V> list() {
            //return (V[]) store.values().toArray();
            ArrayList<V> allValues
                = new ArrayList<V>(store.values());
            return allValues;
        }

    @Override
    public V delete(K key) {
            return store.remove(key);
        }
}


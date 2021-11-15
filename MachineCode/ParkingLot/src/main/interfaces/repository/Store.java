package main.interfaces.repository;

import java.util.Collection;
import java.util.HashMap;

public abstract class Store<K,V> implements IStore<K,V> {
    private HashMap<K,V> store;

    public Store() {
        store = new HashMap<>();
    }

    @Override
    public void add(K key, V value) {
        store.put(key,value);
    }

    @Override
    public V get(K key) {
        if (store.containsKey(key)) return store.get(key);
        return null;
    }

    @Override
    public void deleteKey(K key) {
        if (store.containsKey(key)) {
            store.remove(key);
        }
    }

    @Override
    public Collection<V> list() {
        return store.values();
    }
}

package main.interfaces.repository;

import java.util.Collection;

public interface IStore<K,V> {
    void add(K key, V value);
    V get(K key);
    void deleteKey(K key);
    Collection<V> list();
}

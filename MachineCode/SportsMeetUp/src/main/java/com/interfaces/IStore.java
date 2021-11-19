package main.java.com.interfaces;

import java.util.ArrayList;

public interface IStore<K,V> {
    public V add(K key, V document);
    public V get(K key);
    public ArrayList<V> list();
    public V delete(K key);
}

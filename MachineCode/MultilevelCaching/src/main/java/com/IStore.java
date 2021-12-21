package main.java.com;

interface IStore {
    Response read(Integer key);
    Response write(Integer key, Integer value);
    void evict();
}

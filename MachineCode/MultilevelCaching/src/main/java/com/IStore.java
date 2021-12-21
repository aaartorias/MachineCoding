package main.java.com;

interface IStore {
    Response read(String key);
    Response write(String key, String value);
    void evict();
}

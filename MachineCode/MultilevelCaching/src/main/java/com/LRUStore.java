package main.java.com;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUStore implements IStore {
    private LinkedList<Node> lruList;
    private HashMap<String,Node> lruMap;

    public LRUStore() {
        this.lruList = new LinkedList<>();
        this.lruMap = new HashMap<>();
    }

    @Override
    public Response read(String key) {
        Response response = new Response();
//        int readTime = 0;
//        int writeTime
        if (lruMap.containsKey(key)) {
            moveToFront(lruMap.get(key));
        }
        return response;
    }

    private void moveToFront(Node node) {

    }

    @Override
    public Response write(String key, String value) {
        return null;
    }

    @Override
    public void evict() {

    }
}


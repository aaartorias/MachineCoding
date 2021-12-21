package main.java.com;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUStore implements IStore {
    private LinkedList<Node> lruList;
    private HashMap<Integer,Node> lruMap;

    public LRUStore() {
        this.lruList = new LinkedList<>();
        this.lruMap = new HashMap<>();
    }

    @Override
    public Response read(Integer key) {
//        Response response = new Response();
//        int readTime = 0;
//        int writeTime
        if (lruMap.containsKey(key)) {
            moveToFront(lruMap.get(key));
        }
        return null;
    }

    private void moveToFront(Node node) {

    }

    @Override
    public Response write(Integer key, Integer value) {
        return null;
    }

    @Override
    public void evict() {

    }
}

class Node {
    private Integer key;
    private Integer value;

    public Node(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}

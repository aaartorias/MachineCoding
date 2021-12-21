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
        if (lruMap.containsKey(key)) {
            moveToFront(lruMap.get(key));
            response.setKey(key);
            response.setValue(lruMap.get(key).getValue());
//            response.setFound(true); // call setKeyFound() - sets keyFound to true
            response.setKeyFound();
        }
        return response;
    }

    private void moveToFront(Node node) {
        lruList.remove(node);
        lruList.addFirst(node);
    }

    @Override
    public Response write(String key, String value) {
        Response response = new Response();
        Node node = new Node(key, value);
//        if (lruMap.containsKey(key)) {
//            response.setWriteTime(response.getWriteTime() + );
//        }
        lruList.addFirst(node);
        lruMap.put(key,node);
        response.setKey(key);
        response.setValue(value);
        response.setCacheModified();
        return response;
    }

    @Override
    public void evict() {
        Node node = lruList.getLast();
        lruList.removeLast();
        lruMap.remove(node.getKey());
    }
}


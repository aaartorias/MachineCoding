package main.java.com;

import java.util.ArrayList;

public class Cache {

    private Integer capacity;
    private Integer id;
    private Integer readSpeed;
    private Integer writeSpeed;
    private Integer filled;
    private IStore store;

    public Cache(Integer capacity, Integer id, Integer readSpeed, Integer writeSpeed, Integer filled, IStore store) {
        this.capacity = capacity;
        this.id = id;
        this.readSpeed = readSpeed;
        this.writeSpeed = writeSpeed;
        this.filled = 0;
        this.store = store;
    }

    public Integer getId() {
        return id;
    }

    public Response read(String key) {
        Response response = store.read(key);
        response.setReadTime(response.getReadTime() + readSpeed);
        return response;
    }
    // TODO: Discuss responsibility. I think LRUStore is responsible for checking if the key already exists. setting response time should be work of LRUStore
    public Response write(String key, String value) {
        Response readResponse = store.read(key);
        readResponse.setReadTime(readResponse.getReadTime() + readSpeed);

        if (readResponse.keyFound()) {
            if (readResponse.getValue() == value) {
                return readResponse;
            }
        }

        if (filled == capacity) {
            store.evict();
            filled = filled - 1;
        }

        Response response = store.write(key, value);
        response.setReadTime(readResponse.getReadTime() + response.getReadTime());
//        response.setReadTime(response.getReadTime() + readSpeed);
        if (response.isCacheModified) {
            response.setWriteTime(response.getWriteTime() + writeSpeed);
        }
        return response;
    }


    public Double getUsage() {
        return (double)(filled/capacity);
    }
}

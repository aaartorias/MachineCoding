package main.java.com;

public class Response {
    private Integer key;
    private Integer value;
    private Integer readTime;
    private Integer writeTime;
    private boolean found;
    public boolean isCacheModified;

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

    public Integer getReadTime() {
        return readTime;
    }

    public void setReadTime(Integer readTime) {
        this.readTime = readTime;
    }

    public Integer getWriteTime() {
        return writeTime;
    }

    public void setWriteTime(Integer writeTime) {
        this.writeTime = writeTime;
    }

    public boolean keyFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }


}

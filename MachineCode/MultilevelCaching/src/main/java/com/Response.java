package main.java.com;

public class Response {
    private String key;
    private String value;
    private Integer readTime;
    private Integer writeTime;
    private boolean keyFound;
    public boolean isCacheModified;

    public Response() {
        this.readTime = 0;
        this.writeTime = 0;
        this.isCacheModified = false;
        this.keyFound = false;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
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
        return keyFound;
    }

    public void setKeyFound(boolean keyFound) {
        this.keyFound = keyFound;
    }


    public void setKeyFound() {
        this.keyFound = true;
    }

    public void setCacheModified() {
        isCacheModified = true;
    }
}

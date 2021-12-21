package main.java.com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CachingService {
    List<Cache> cacheList;
    Queue<Integer> readTimeQueue;
    Queue<Integer> writeTimeQueue;
    private Integer statsCount;

    public CachingService() {
        cacheList = new ArrayList<>();
        readTimeQueue = new LinkedList<>();
        writeTimeQueue = new LinkedList<>();
        statsCount = 10;
        IStore store1 = new LRUStore();
        IStore store2 = new LRUStore();
        IStore store3 = new LRUStore();
        Cache c1 = new Cache(2,1,2, 3, 0, store1);
        Cache c2 = new Cache(4,2,3, 4, 0, store2);
        Cache c3 = new Cache(8,3,5, 7, 0, store3);
        cacheList.add(c1);
        cacheList.add(c2);
        cacheList.add(c3);
    }
//
//    public void addCache(ICachingStrategy strategy, Integer priorityLevel, Integer capacity, Integer readSpeed
//            , Integer writeSpeed) {
//
//    }

    public void printStats() {
        printCurrentCacheUsage();
        printAvgReadTime();
        printAvgWriteTime();
    }

    private void printAvgWriteTime() {
        System.out.printf("Average write time : ");
        printAvgTime(writeTimeQueue);
    }

    private void printAvgTime(Queue<Integer> timeQueue) {
        Integer totalTime = 0;
        for (Integer time: timeQueue) {
            totalTime = totalTime + time;
        }
        double avgTime = (double)(totalTime/timeQueue.size());
        System.out.println(avgTime);
    }

    private void printAvgReadTime() {
        System.out.printf("Average read time : ");
        printAvgTime(readTimeQueue);
    }

    private void printCurrentCacheUsage() {
        System.out.println("Current cache usage");
        for (Cache cache: cacheList) {
            System.out.println(cache.getId() + " : " + cache.getUsage());
        }
    }

    public String readKey(String key) {
        int i = 0;
        int readTime = 0, writeTime = 0;
        Response response = null;
        for (; i < cacheList.size(); i++) {
            response = cacheList.get(i).read(key);
            readTime += response.getReadTime();
            if (response.keyFound()) {
                break;
            }
        }
        String value = null;
        if (response.keyFound()) {
            value = response.getValue();
            for ( int j = i - 1; j >= 0; j--) {
                response = cacheList.get(i).write(key, value);
                writeTime += response.getWriteTime();
            }
        }
        updateStats(readTime, writeTime);
        if (value == null) {
            System.out.println("cache miss for key : " + key );
        }
        return value;
    }

    private void updateStats(Integer readTime, Integer writeTime) {
        updateReadStats(readTime);
        updateWriteStats(writeTime);
    }

    private void updateReadStats(Integer readTime) {
        if (readTimeQueue.size() == statsCount) {
            readTimeQueue.remove();
        }
        readTimeQueue.add(readTime);
    }

    private void updateWriteStats(Integer writeTime) {
        if (writeTimeQueue.size() == statsCount) {
            writeTimeQueue.remove();
        }
        writeTimeQueue.add(writeTime);
    }

    public void write(String key, String value) {
        Response response = null;
        int readTime = 0;
        int writeTime = 0;
        for (int i = 0; i < cacheList.size(); i++) {
            response = cacheList.get(i).write(key, value);
            readTime += response.getReadTime();
            writeTime += response.getWriteTime();
        }
        updateStats(readTime, writeTime);
    }

 }

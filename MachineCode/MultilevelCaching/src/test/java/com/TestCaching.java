package test.java.com;

import main.java.com.CachingService;

public class TestCaching {
    public static void main(String[] args) {
//        tCacheMissWithEmptyCache();
//        tCacheWrite
    }

    private static void tCacheMissWithEmptyCache() {
        CachingService cachingService = new CachingService();
        cachingService.readKey("abc");
        cachingService.printStats();
    }
}

package test.java.com;

import main.java.com.CachingService;

public class TestCaching {
    public static void main(String[] args) {
//        tCacheMissWithEmptyCache();
        tCachePopulateCacheCompletely();
    }

    private static void tCachePopulateCacheCompletely() {
        CachingService cachingService = new CachingService();
        cachingService.write("abc", "apple");
        cachingService.printStats();
    }

    private static void tCacheMissWithEmptyCache() {
        CachingService cachingService = new CachingService();
        cachingService.readKey("abc");
        cachingService.printStats();
    }
}

package cn.istarx.java;

import java.util.LinkedHashMap;
import java.util.Map;

public class NO146_LRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        System.out.println(cache.get(2));
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 1);
    }

    static class LRUCache {
        private int mCapacity;
        private Map<Integer, Integer> mCache;

        public LRUCache(int capacity) {
            this.mCapacity = capacity;
            mCache = new LinkedHashMap();
        }

        public int get(int key) {
            if (mCache.containsKey(key)) {
                int newValue = mCache.get(key);
                mCache.remove(key);
                mCache.put(key, newValue);
                return newValue;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (mCache.containsKey(key)) {
                mCache.remove(key, value);
            } else if (mCache.size() >= mCapacity) {
                for (int k : lru.keySet()) {
                    mCache.remove(k);
                    break;
                }
            }
            mCache.put(key, value);
        }
    }
}


/*import java.util.LinkedHashMap;

class LRUMap<K, V> extends LinkedHashMap<K, V> {
    private int cacheSize ;

    public LRUMap(int capacity) {
        super(capacity, 0.75f, true) ; //access-based eviction set to 'true' (as opposed to 'insertion'-based eviciton)
        cacheSize = capacity ;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > cacheSize ;
    }
}


public class LRUCache  {

    LRUMap<Integer, Integer> map ; //use extension of LinkedHashMap here

    public LRUCache(int capacity) {
        map = new LRUMap<Integer, Integer>(capacity) ; //make sure to pass 'capacity' on to LinkedHashMap ctor
    }


    public int get(int key) {

        if(map.containsKey(key)) {
            return map.get(key) ;
        }
        return -1;
    }

    public void set(int key, int value) {
        map.put(key, value) ;
    }
}*/

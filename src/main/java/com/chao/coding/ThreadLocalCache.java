package com.chao.coding;


import java.util.Map;

public class ThreadLocalCache {

    private final ThreadLocal<Map<Object, Object>> store = new ThreadLocal<>();

    public void put(Object key, Object value) {
        store.get().put(key, value);
    }

    public Object get(Object key) {
        return store.get().get(key);
    }
}

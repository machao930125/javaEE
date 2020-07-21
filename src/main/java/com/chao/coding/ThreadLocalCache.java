package com.chao.coding;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadLocalCache {

    /**
     * 实例字段，每个线程一个store，每个线程生产一个{@code ThreadLocalCache} INSTANCE
     */
    private final ThreadLocal<Map<Object, Object>> store;

    public ThreadLocalCache() {
        this.store = new ThreadLocal<Map<Object, Object>>() {
            @Override
            protected Map<Object, Object> initialValue() {
                return new ConcurrentHashMap<Object, Object>();
            }
        };
    }

    public void put(Object key, Object value) {
        store.get().put(key, value);
    }

    public Object get(Object key) {
        return store.get().get(key);
    }
}

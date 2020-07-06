package com.chao.coding;

import java.util.LinkedList;
import java.util.Objects;

public class MyHashMap {

    private static Object[] map = new Object[2000];

    static class Entry {
        Object key;
        Object value;

        public Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void put(Object key, Object object) {
        int hash = hashcode(key);
        int index = hash % map.length;
        Entry entry = new Entry(key, object);
        if (map[index] == null) {
            LinkedList link = new LinkedList<Entry>();
            link.add(entry);
            map[index] = link;
        } else {
            LinkedList<Entry> linkedList = (LinkedList<Entry>) map[index];
            boolean rtn = true;
            for (Entry en : linkedList) {
                if (key.equals(en.key)) {
                    en.value = entry.value;
                    rtn = false;
                }
            }
            if (rtn){
                linkedList.add(entry);
            }
        }
    }

    public static Object get(Object key) {
        int hash = hashcode(key);
        int index = hash % map.length;
        if (map[index] != null) {
            LinkedList<Entry> linkedList = (LinkedList<Entry>) map[index];
            for (Entry entry : linkedList) {
                if (key.equals(entry.key)) {
                    return entry.value;
                }
            }
        }
        return null;
    }

    public static int hashcode(Object str) {
        return Objects.hash(str);
    }
}

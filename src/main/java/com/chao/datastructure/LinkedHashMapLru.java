package com.chao.datastructure;

import java.util.LinkedHashMap;

public class LinkedHashMapLru extends LinkedHashMap {

    @Override
    public Object get(Object key) {
        return super.getOrDefault(key,"");
    }
}

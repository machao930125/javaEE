package com.chao.datastructure.tree;

import java.util.LinkedList;

public class MulTree {
    public int value;
    public LinkedList<MulTree> tree = new LinkedList<>();

    public MulTree(int value) {
        this.value = value;
    }
}

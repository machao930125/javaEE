package com.chao.dataStructure.tree;

/**
 * Created by machao on 2018/4/20.
 */
public class TestTree {
    public static void main(String[] args) {
        BinTree b = new BinTree("B");
        BinTree f = new BinTree("F");
        BinTree h = new BinTree("H");
        BinTree m = new BinTree("M");
        BinTree y = new BinTree("Y");
        BinTree v = new BinTree("V");
        BinTree j = new BinTree("J",b,f);
        BinTree p = new BinTree("P",h,m);
        BinTree a = new BinTree("A",null,y);
        BinTree r = new BinTree("R",v,null);
        BinTree t = new BinTree("T",j,p);
        BinTree z = new BinTree("K",a,r);
        BinTree q = new BinTree("Q",t,z);



    }
}

package com.chao.equals;

public class TestEquals {
  public static void main(String[] args) {
    /**
     * 这里使用构造方法Cat()在堆内存里面new出了两只猫，
     * 这两只猫的color，weight，height都是一样的，
     * 但c1和c2却永远不会相等，这是因为c1和c2分别为堆内存里面两只猫的引用对象，
     * 里面装着可以找到这两只猫的地址，但由于两只猫在堆内存里面存储在两个不同的空间里面，
     * 所以c1和c2分别装着不同的地址，因此c1和c2永远不会相等。
     */
    Cat c1 = new Cat(1, 1, 1);
    Cat c2 = new Cat(1, 1, 1);
    System.out.println("c1==c2的结果是："+(c1==c2));//false
    System.out.println("c1.equals(c2)的结果是："+c1.equals(c2));//false

    String str1 = new String("abc");
    String str2 = new String("abc");
    System.out.println(str1.equals(str2));
    System.out.println(str1 == str2);
  }
}
package com.chao.jdk;

import java.util.Objects;

public class OutClass {

    private int age;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutClass outClass = (OutClass) o;
        return age == outClass.age &&
                Objects.equals(name, outClass.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    public static class InerClass{
        private static String name;
        private static void test(){
//            int a = age;
        }
    }


    public static void main(String[] args) {
//        InerClass inerClass = new InerClass();
        System.out.println();
    }

    public void test(){
        InerClass inerClass = new InerClass();
    }
}

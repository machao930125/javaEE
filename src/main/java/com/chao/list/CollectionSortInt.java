package com.chao.list;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by machao on 2018/4/13.
 */
public class CollectionSortInt {
    public static void main(String[] args) {
        //对int类型的集合进行排序
        soutInt();
        //对对象类型集合进行排序
        soutStudent();
    }

    public static void soutStudent(){
        ArrayList<Student> students = new ArrayList<Student>();

        students.add(new Student(4,"test1"));
        students.add(new Student(8,"test2"));
        students.add(new Student(7,"test3"));
        students.add(new Student(9,"test4"));
        students.add(new Student(5,"test5"));
        students.add(new Student(1,"test6"));
        students.add(new Student(2,"test7"));
        students.add(new Student(2,"test8"));

        System.out.println(students);
        Collections.sort(students, new Comparator<Student>() {
            public int compare(Student o1, Student o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        });
        System.out.println(students);

    }

    /**
     * 验证
     */
    public static void soutInt(){
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(4);
        list.add(8);
        list.add(5);
        list.add(3);
        list.add(1);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}

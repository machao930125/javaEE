package com.chao.spring;

import java.lang.reflect.Field;
import java.util.stream.Stream;

public class MyIocTest {
    public static void main(String[] args) {
        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();

        Field[] fields = clazz.getDeclaredFields();
        Stream.of(fields).forEach(field -> {
            MyAutowired annotation = field.getAnnotation(MyAutowired.class);
            if (annotation != null){
                field.setAccessible(true);
                Class<?> type = field.getType();
                try {
                    Object obj = type.newInstance();
                    field.set(userController,obj);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        System.out.println(userController.getUserService());
    }
}

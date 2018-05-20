package com.chao;

import com.chao.list.Student;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

class CheckParamUtil<T> {
    public static void main(String[] args) {
        Student s = new Student();
        try {
            Map<String, Object> map = checkParam(s, "age");
            boolean bo = (boolean)map.get("code");
            if (bo){
                System.out.println("参数没问题！");
            }else{
                System.out.println(map.get("message"));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    /**
     * 
     * @Title:checkParam
     * @Description:(该方法用来校验对象及其属性是否为空)
     * @param t
     * @param args
     * @author
     * @throws InvocationTargetException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @修改时间：2017年6月9日 下午2:18:54
     * @修改内容：创建
     */
    public static <T> Map<String,Object> checkParam(T t, String... args) throws IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("code",true);
        // 如果传入的对象为空，则直接抛出异常
        if (t == null) {
            resultMap.put("code",false);
            resultMap.put("message","This object cann't be empty!");
            return resultMap;
            //throw new IllegalArgumentException("This object cann't be empty!");
        }
        Class<? extends Object> clazz = t.getClass();
        // 定义属性列表
        List<String> argsList = new ArrayList<String>();
        if (args != null && args.length > 0) {
            // 如果传入的属性名不为空，则将传入的属性名放入属性列表
            argsList = Arrays.asList(args);
        } else {
            // 如果传入的属性名为空，则将所有属性名放入属性列表
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                argsList.add(field.getName());
            }
        }
        // 获取该类自定义的方法数组
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            // 方法名
            String methodName = method.getName();
            // 获取方法对应的属性名
            String fieldName = "";
            if (methodName.length() >= 4) {
                fieldName = methodName.substring(3, 4).toLowerCase()
                        + methodName.substring(4);
                // 如果方法是“get方法”，并且属性列表中包含该方法对应的属性名
                if (methodName.startsWith("get")
                        && argsList.contains(fieldName)) {
                    // 如果为null，抛出异常
                    if (method.invoke(t) == null) {
                        resultMap.put("code",false);
                        resultMap.put("message",fieldName + " cann't be null!");
                        return resultMap;
                        //throw new IllegalArgumentException(fieldName + " cann't be null!");
                    }
                    // 如果该方法返回类型为String,返回结果为空字符串，抛出异常。
                    Class<?> returnType = method.getReturnType();
                    String returnTypeName = returnType.getSimpleName();
                    if (returnTypeName.equals("String")
                            && "".equals(((String)(method.invoke(t))).trim())) {
                        resultMap.put("code",false);
                        resultMap.put("message",fieldName + " cann't be empty String!");
                        return resultMap;
                        //throw new IllegalArgumentException(fieldName + " cann't be empty String!");
                    }
                }
            }
        }
        return resultMap;
    }
}
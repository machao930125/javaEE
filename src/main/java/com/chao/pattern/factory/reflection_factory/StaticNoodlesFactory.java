package com.chao.pattern.factory.reflection_factory;

import com.chao.pattern.factory.simple_factory.INoodles;
import com.chao.pattern.factory.simple_factory.PaoNoodles;

public class StaticNoodlesFactory {
    /**
     * 传入Class实例化面条产品类
     *
     * @param clz
     * @param <T>
     * @return
     */
    public static <T extends INoodles> T createNoodles(Class<T> clz) {
        T result = null;
        try {
            result = (T) Class.forName(clz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        PaoNoodles noodles = createNoodles(PaoNoodles.class);
        String name = PaoNoodles.class.getName();
        System.out.println(name);
    }
}
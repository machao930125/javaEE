package com.chao.pattern.factory.mulWay_factory;

import com.chao.pattern.factory.simple_factory.GankouNoodles;
import com.chao.pattern.factory.simple_factory.INoodles;
import com.chao.pattern.factory.simple_factory.LzNoodles;
import com.chao.pattern.factory.simple_factory.PaoNoodles;

public class MulWayNoodlesFactory {

    /**
     * 模仿Executors 类
     * 生产泡面
     *
     * @return
     */
    public static INoodles createPm() {
        return new PaoNoodles();
    }

    /**
     * 模仿Executors 类
     * 生产兰州拉面
     *
     * @return
     */
    public static INoodles createLz() {
        return new LzNoodles();
    }

    /**
     * 模仿Executors 类
     * 生产干扣面
     *
     * @return
     */
    public static INoodles createGk() {
        return new GankouNoodles();
    }
}
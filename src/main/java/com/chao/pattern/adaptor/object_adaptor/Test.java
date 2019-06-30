package com.chao.pattern.adaptor.object_adaptor;

import com.chao.pattern.adaptor.class_adaptor.Mobile;
import com.chao.pattern.adaptor.class_adaptor.Voltage220;

/**
 * Created by machao on 2018/3/15.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("\n===============对象适配器==============");
        VoltageAdapter2 voltageAdapter2 = new VoltageAdapter2(new Voltage220());
        Mobile mobile2 = new Mobile();
        mobile2.charging(voltageAdapter2);
    }
}

package com.chao.Java8;

import com.sun.org.apache.xpath.internal.SourceTree;
import jdk.nashorn.internal.parser.TokenStream;

import java.lang.annotation.*;
import java.net.InterfaceAddress;

/**
 * Java8新特性————可重复使用注解
 *
 * Created by Administrator on 2018/4/14.
 */
public class RepeatAnnotation {

    public static void main(String[] args) {
        for (Token token : userToken.class.getAnnotationsByType(Token.class)) {
            for (String s : token.value()) {
                System.out.println(s);
            }
            System.out.println(token.value().length);
        }


    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Tokens {
        Token[] value();
    }

    /**
     * @Target declaration annotation function where with a enum ElementType,exemapl method、type、field
     * @Retention declaration annotation function when with a enum RetentionPolicy, use RunTime
     *
     */

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(Tokens.class)
    public @interface Token {
        String[] value();
    }


    @Token("1111")
    @Token({"2222","3333"})
    public interface userToken{}
}

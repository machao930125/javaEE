package com.chao.Java8;

import com.chao.domain.User;

import java.awt.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2018/5/1.
 */
public class StreamAPI {
    public static void getStream(){
        //1、通过集合获取
        ArrayList<User> users = new ArrayList<>();
        Stream<User> stream1 = users.stream();

        //2、通过数据获取
        String[] names = {"chaimm","peter","john"};
        Stream<String> stream2 = Arrays.stream(names);

        //3、通过值获取
        Stream<String> stream3 = Stream.of("chaimm", "peter", "john");

        //4、通过文件获取
        // Java7简化了IO操作，把打开IO操作放在try后的括号中即可省略关闭IO的代码。
        try(Stream lines = Files.lines(Paths.get("C:/Users/Administrator/Desktop/test.txt"), Charset.defaultCharset())){
            //可对lines做一些操作
        }catch(IOException e){
        }
    }
}

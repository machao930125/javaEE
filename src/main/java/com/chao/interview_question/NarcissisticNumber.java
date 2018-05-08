package com.chao.interview_question;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by machao on 2018/4/24.
 */
public class NarcissisticNumber {

    public static void main(String[] args) {
        int ge,shi,bai;
        for (int i = 100; i < 1000; i++) {
            ge = i % 10;
            shi = i /10%10;
            bai = i /100;
            double v = Math.pow(ge, 3) + Math.pow(shi, 3) + Math.pow(bai, 3);
            int b = (int) v;
            if (i == b){
                System.out.println(i);
            }
        }
    }

}

package com.chao.pattern.prototype;

import java.awt.*;
import java.util.ArrayList;

public class PrototypeDemo {
  
    public static void main(String[] args) throws CloneNotSupportedException {  
        ArrayList<String> famMem = new ArrayList<>(); // 家庭成员名单
        famMem.add("Papa");  
        famMem.add("Mama");  
          
        // 创建初始简历  
        Resume resume1 = new Resume("Jobs");
        resume1.setPersonal("Male", 26, famMem);
        resume1.setWork("2013/8/1 - 2015/6/30", "Huawei");  
          
        // 通过简历1复制出简历2，并对家庭成员和工作经验进行修改  
        Resume resume2 = resume1.clone();  
        resume2.setName("Tom");  
        resume2.famMem.add("Brother");  
        resume2.setWork("2015/7/1 - 2016/6/30", "Baidu");  
          
        resume1.display();  
        resume2.display();  
    }// main  
      
}/*Pritotype*/  
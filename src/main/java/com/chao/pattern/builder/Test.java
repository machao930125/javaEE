package com.chao.pattern.builder;

public class Test{
     public static void main(String[] args) {  
          PersonDirector pd = new PersonDirector();  
          Person womanPerson = pd.constructPerson(new ManBuilder());  
          Person manPerson = pd.constructPerson(new WomanBuilder());  
     }  
}  
package com.gp;

import org.junit.Test;

public class IfTest {

    public static void main(String[] args) {
       // testIf();
    }


@Test
    public void testIf(){
        boolean isFlag=true;

        if(isFlag){
            System.out.println("今天下雨，要带雨伞");
        }else{
            System.out.println("今天不下雨，不带雨伞");
        }

        for(int i=0;i<50;i++){
            System.out.println("hello"+i);
        }
    }
}

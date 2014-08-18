package com.tandon.scala;

/**
 * Created by berkha on 28/03/14.
 */
public class TestHelloWorld {
    public static void main(String[] args) {
        System.out.println("Testing the first program...");

        Pojo pojo = new Pojo(2 , 3);
        System.out.println("input pojo x ->" + pojo.x + " y -> " +pojo.y);
        pojo.x = 3;
        System.out.println("input pojo x ->" + pojo.x + " y -> " +pojo.y);

    }
}





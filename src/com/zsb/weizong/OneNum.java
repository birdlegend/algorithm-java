package com.zsb.weizong;

/**
 * Created by zsb on 2018/4/16.
 */

import java.util.Scanner;

public class OneNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arr[] = new int[3];
        arr[0]=scanner.nextInt();
        arr[1]=scanner.nextInt();
        arr[2]=scanner.nextInt();

        System.out.println(arr[1] - arr[2] + 1);
    }

}

/*
3 2 1
 */


//public class OneNum{
//    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextLong();
//        int b = scanner.nextInt();
//        int c = scanner.nextInt();
//        long result = (1<<a) + (1<<b) - (1<<c);
//        if(result < 0) System.out.println(0);
//        else  System.out.println(count(result));
//    }
//    public static int count(long num){
//        int count = 0;
//        while(num != 0){
//            num = num &(num -1);
//            count++;
//        }
//        return count;
//    }
//}
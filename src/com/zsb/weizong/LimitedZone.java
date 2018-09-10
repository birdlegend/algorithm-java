package com.zsb.weizong;

import java.util.Map;
import java.util.Scanner;

///**
// * Created by zsb on 2018/4/16.
// */
//public class LimitedZone {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//
//        for (int i = 2; i < n; i++) {
//            boolean isPrime = true;
//            for (int j = 2; j < i; j++) {
//                if (i % j == 0) {
//                    isPrime = false;
//                    break;
//                }
//            }
//            if (isPrime) {
//                priArr[i] = i;
//            }
//        }
//        return priArr;
//    }
//
//    public static boolean isPrime(int a) {
//        boolean isPrime = true;
//        if (a >= 2) {
//            for (int i = 2; i <= Math.sqrt(a); i++) {
//                if (a % i == 0) {
//                    isPrime = false;
//                    break;
//                }
//            }
//        } else
//            return false;
//
//        return isPrime;
//    }
//}


import java.util.*;

public class LimitedZone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Set<Integer> result = new TreeSet();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                result.add(i);

                for (int k = 2; k <= 10; k++) {
                    int temp = (int) Math.pow(i, k);
                    if (temp <= n) result.add(temp);
                }
            }

        }

        System.out.println(result.size());
    }

    public static boolean isPrime(int a) {
        boolean isPrime = true;
        if (a >= 2) {
            for (int i = 2; i <= Math.sqrt(a); i++) {
                if (a % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        } else
            return false;

        return isPrime;
    }
}
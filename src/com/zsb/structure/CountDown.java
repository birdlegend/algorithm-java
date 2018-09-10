package com.zsb.structure;
//
///**
// * Created by zsb on 2018/3/21.
// */
//
//import java.util.Scanner;
//
//public class CountDown {
//    public static void main(String[] args) {
////        Scanner scanner = new Scanner(System.in);
////        int result = 0;
////        int nums = scanner.nextInt();
////        String[] array = new String[nums];
////        int i = 0;
////        scanner.nextLine();
////        while (i < nums) {
////            array[i] = scanner.nextLine();
////            i++;
////        }
//        int nums = 4;
//        StringBuilder[] array = new StringBuilder[] {"lls", "s", "","sssll"};
//
//        for (int k = 0; k < nums; k++) {
//            for (int m = 0; m < nums; m++) {
//                if (k == m) continue;
//                else {
//                    String temp = array[k] + array[m];
//                    if (temp.equals("")) continue;
//                    if (isHuiWen(temp)) result++;
//                }
//            }
//        }
//        System.out.println(result);
//    }
//
//    private static boolean isHuiWen(String s) {
//        int n = s.length() / 2;
//
//        for (int i = 0; i < n; i++) {
//            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
//                return false;
//        }
//        return true;
//    }
//
////    private static boolean isHuiWen(String l, String r, int llen, int rlen) {
////
////    }
//}

import java.util.Scanner;

public class CountDown {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result = 0;
        int nums = scanner.nextInt();
        String[] array = new String[nums];
        int i = 0;
        scanner.nextLine();
        while (i < nums) {
            array[i] = scanner.nextLine();
            i++;
        }

        StringBuilder temp = new StringBuilder();
        for (int k = 0; k < nums; k++) {
            for (int m = 0; m < nums; m++) {
                if (k == m) continue;
                else {
                    temp.append(array[k]);
                    temp.append(array[m]);
                    if (temp.equals("")) continue;
                    else if (isHuiWen(temp.toString())) result++;
                }
            }
        }
        System.out.println(result);
    }

    private static boolean isHuiWen(String str) {
        boolean bool = true;
        for (int i = 0; i <= str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                bool = false;
                break;
            }
        }
        return bool;
    }
}
//package com.zsb.toutiao;
//
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
///**
// * Created by zsb on 2018/4/15.
// */
//class Rational {
//    int left;
//    int right;
//    float value;
//
//
//    public Rational(int left, int right) {
//        this.left = left;
//        this.right = right;
//    }
//
//    @Override
//    public String toString() {
//        return left + " " + right;
//    }
//}
//
//public class Test21 {
//
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int N = scanner.nextInt();
//        int K = 0;
//        List<Integer> list = new ArrayList<>();
//
//        scanner.nextLine();
//        for (int i = 0; i < N; i++) {
////            System.out.println(str);
//            String[] arrStr = scanner.nextLine().split(" ");
//
//            for (String a : arrStr)
//                list.add(Integer.parseInt(a));
//        }
//
//        K = list.get(0);
//
//        int left1 = 1, left2 = 1;
//        int right1 = list.size() - 1;
//        int right2 = list.size() - 1;
//        int rank = 1;
//        List<Rational> rationals = new ArrayList<>();
//        rationals.add(new Rational(left1, right1));
//
//
//        while (rank <= K && left1 < right) {
////            System.out.println("lr: " + left + " " + right);
//            float n1 = (float) list.get(left + 1) / list.get(right);
//            float n2 = (float) list.get(left) / list.get(right - 1);
////            System.out.println(n1 + " " + n2);
//            if (n1 < n2) {
//                left++;
//                rationals.add(new Rational(left, right));
//
//            } else {
//                right--;
//                rationals.add(new Rational(left, right));
//            }
//
//            rank++;
//        }
//
//        System.out.println(rationals.get(K - 1));
//    }
//
//
//}
//
//
///*
//1
//3 1 2 3 5
//
//1
//1 1 2 3 5
//
//
//2
//3 1 2 3 5
//3 1 2 3 6
// */
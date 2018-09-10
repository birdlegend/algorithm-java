package com.zsb.huawei;

import java.util.Scanner;

/**
 * Created by zsb on 2018/3/28.
 */
public class T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int max = Integer.MIN_VALUE;
        int a[] = new int[21];
        int res = -1;

        for(int i=0; i<21; i++) {
            a[i] = scanner.nextInt();
        }
        for(int i=0; i<18; i++) {
            int tmp = a[i] + a[i+1] + a[i+2] + a[i+3];
            if(tmp > max) {
                max = tmp;
                res = i;
            }
        }

        System.out.println(res);
    }
}

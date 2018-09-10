package com.zsb.string;

/**
 * 求十进制整数中0的个数
 * Created by zsb on 2018/4/9.
 */
public class IntCountZero {
    public static int cntZero(int a) {
        if (a == 0) return 1;

        int cnt = 0;
        while (a != 0) {
            if (a % 10 == 0) cnt++;
            a = a / 10;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(cntZero(1030));
        System.out.println(cntZero(1030003));

    }

}

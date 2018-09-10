package com.zsb.tencent;

import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int k = scanner.nextInt();
//        int Alength = scanner.nextInt();
//        int x = scanner.nextInt();
//        int Blength = scanner.nextInt();
//        int y = scanner.nextInt();
//        long result = func(k, Alength, x, Blength, y);
//        System.out.println(result % 1000000007);

        System.out.println(Double.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
    }

    public static long func(int k, int Alength, int x, int Blength, int y) {
        long result = 0L;
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                if (Alength * i + Blength * j == k) {
                    result += choose(i, x, j, y);
                }
            }
        }
        return result;
    }

    public static long choose(int i, int x, int j, int y) {
        long up = 1;
        long down = 1;
        while (i > 0) {
            up *= x - i + 1;
            down *= i;
            i--;
        }
        long resultx = up / down;
        up = 1;
        down = 1;
        while (j > 0) {
            up *= y - j + 1;
            down *= j;
            j--;
        }

        long resulty = up / down;
        return resultx * resulty;
    }
}
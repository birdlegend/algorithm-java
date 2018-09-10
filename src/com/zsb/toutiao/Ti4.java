package com.zsb.toutiao;

import java.util.Scanner;

/**
 * Created by zsb on 2018/3/24.
 */
public class Ti4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];

        int sumA = 0;
        int sumB = 0;

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            sumA += a[i];
        }

        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
            sumB += b[i];
        }


        System.out.println(getMax(a, b, sumA, sumB, n, m));
    }

    public static int getMax(int[] a, int []b, int sumA, int sumB, int n, int m) {
        double avgA = sumA / (n * 1.0);
        double avgB = sumB / (m * 1.0);

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (((sumA * 1.0) - a[i] + b[j]) / (n * 1.0) > avgB && ((sumB * 1.0) - b[j] + a[i]) / (m * 1.0) > avgB) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}




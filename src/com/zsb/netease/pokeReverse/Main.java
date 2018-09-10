package com.zsb.netease.pokeReverse;

import java.util.Scanner;

/**
 * created by zsb on 2018/9/8
 *
 * @see <a href="https://birdlegend.github.io/">birdlegend的博客</a>
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int m, n, res;
        int tmp1, tmp2;

        while (t-- > 0) {

            n = scanner.nextInt();
            m = scanner.nextInt();

            if (n == 1 && m == 1) {
                System.out.println(1);
            } else {
                tmp1 = n < 2 ? 1 : n - 2;
                tmp2 = m < 2 ? 1 : m - 2;
                res = (tmp1 - 2) * (tmp2 - 2);
                System.out.println(res);
            }
        }
    }
}

/*
5
1 1
1 2
3 1
4 1
2 2
 */
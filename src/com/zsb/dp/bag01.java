package com.zsb.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.nowcoder.com/discuss/3574
 * Created by zsb on 2018/4/4.
 */
public class bag01 {
    public static void main(String[] args) {
        int thingNbr, bagSize; // 分别为物品数量，背包容量，
//        List<Integer> w = new ArrayList<>();
//        List<Integer> v = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        thingNbr = scanner.nextInt();
        bagSize = scanner.nextInt();

        int w[] = new int[thingNbr];
        int v[] = new int[thingNbr];
        // dp[i][j]表示背包容量为j值时，放入i个物品的最大价值。 其中第0列表示背包容量为0时背包的最大价值为0
        int dp[][] = new int[thingNbr][bagSize + 1]; //默认初始化为0

        for (int i = 0; i < thingNbr; i++) {
            w[i] = scanner.nextInt();
        }

        for (int i = 0; i < thingNbr; i++) {
            v[i] = scanner.nextInt();
        }

//        放入一个物品时
        for (int j = 0; j < bagSize + 1; j++) {
            if (j >= w[0]) dp[0][j] = v[0];
        }

         /*
        * 背包中依次装入其他的物品
        * */
        for (int i = 1; i < thingNbr; i++) {
            for (int j = 1; j < bagSize + 1; j++) {
                if (j < w[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                }
            }
        }

        for (int i = 0; i < thingNbr; i++) {
            for (int j = 0; j < bagSize + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("max value: " + dp[thingNbr - 1][bagSize]);

        boolean flag[] = new boolean[thingNbr];
        // 输出放入背包的编号
        int curSize = bagSize; //背包目前容量
        for (int i = thingNbr - 1; i >= 1; i--) {
            if (dp[i][curSize] > dp[i - 1][curSize]) {
                flag[i] = true;
                curSize = bagSize - w[i]; // 放入i物品，背包剩余容量。
            } else
                flag[i] = false;
        }

        for(int i=0; i<thingNbr; i++) {
            if(flag[i])
                System.out.print(i + " ");
        }


//        dp2();
    }


    public static void dp2() {
//        作者：小小沸沸要加油
//        链接：https://www.nowcoder.com/discuss/3574
//        来源：牛客网

        int[] w = {2, 2, 6, 5, 4}; //物品重量
        int[] v = {6, 3, 5, 4, 6}; //物品价值
        int c = 10;//背包容量
        int[] x = new int[5]; //记录物品装入情况，0表示不转入，1表示装入
        x[0] = 1; //初始值表示第一个物品已装入背包
        int[][] m = new int[5][c + 1];//需要维护的二维表，为了方便计算加入一列，其中第0列表示背包容量为0时背包的最大价值为0
/*
        * 初始化第一行，即背包中装入第一件物品
        * */
        for (int j = 1; j <= c; j++) {
            if (j >= w[0]) {
                m[0][j] = v[0];
            }
        }

/*
        * 背包中依次装入其他的物品
        * */
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j <= c; j++) {
                if (j < w[i]) m[i][j] = m[i - 1][j]; //不装入背包
                else {
                    if (m[i - 1][j - w[i]] + v[i] > m[i - 1][j]) m[i][j] = m[i - 1][j - w[i]] + v[i]; //选择价值较大者
                    else m[i][j] = m[i - 1][j];
                }
            }
        }
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < c + 1; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("背包的最大价值为：" + m[w.length - 1][c]);
        for (int i = 4; i >= 1; i--) {
            if (m[i][c] > m[i - 1][c]) {
                x[i] = 1; //装入背包
                c -= w[i]; //物品i装入背包之前背包的容量
            } else x[i] = 0; //没有装入背包
        }
        System.out.print("装入背包的物品编号是：");
        for (int i = 0; i < 5; i++) {
            if (x[i] == 1) System.out.printf("%2d", (i + 1));
        }


    }
}
/*
5 10
2 2 6 5 4
6 3 5 4 6
 */
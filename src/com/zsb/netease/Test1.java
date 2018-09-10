package com.zsb.netease;

import java.util.ArrayList;
import java.util.Scanner;

/**
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNumber = Integer.parseInt(scanner.nextLine());
        ArrayList<char[][]> results = new ArrayList<>();

        while (caseNumber > 0) {
            String[] strings = scanner.nextLine().split("\\s+");
            int n = Integer.parseInt(strings[0]);
            int m = Integer.parseInt(strings[1]);

            char[][] picture = new char[n][n];
            for (int i = 0; i < n; i++) {
                picture[i] = scanner.nextLine().toCharArray();
            }
            scanner.nextLine();

            // 计算
            int mid = m / n;
            int edge = m % n;
            if (edge % 2 != 0) {         // 边为奇数
                edge = (edge + n) / 2;
                mid--;
            } else {
                edge = edge / 2;
            }

            char[][] result = new char[m][m];
            // 中
            for (int i = edge; i < n + edge; i++) {
                for (int k = 0; k < mid; k++) {
                    for (int j = k * n + edge; j < k * n + n + edge; j++) {
                        result[i][j] = picture[i - edge][j - k * n - edge];
                    }
                }
            }

            // 左上角
            for (int i = 0; i < edge; i++) {
                for (int j = 0; j < edge; j++) {
                    result[i][j] = picture[n - edge + i][n - edge + j];
                }
            }

            // 右上角
            for (int i = 0; i < edge; i++) {
                for (int j = m - edge; j < m; j++) {
                    result[i][j] = picture[n - edge + i][j - m + edge];
                }
            }

            // 上
            for (int i = 0; i < edge; i++) {
                for (int k = 0; k < mid; k++) {
                    for (int j = k * n + edge; j < k * n + n + edge; j++) {
                        result[i][j] = picture[n - edge + i][j - k * n - edge];
                    }
                }
            }

            // 左
            for (int k = 0; k < mid; k++) {
                for (int i = k * n + edge; i < k * n + n + edge; i++) {
                    for (int j = 0; j < edge; j++) {
                        result[i][j] = picture[i - k * n - edge][n - edge + j];
                    }
                }
            }

            // 右
            for (int k = 0; k < mid; k++) {
                for (int i = k * n + edge; i < k * n + n + edge; i++) {
                    for (int j = m - edge; j < m; j++) {
                        result[i][j] = picture[i - k * n - edge][j - m + edge];
                    }
                }
            }

            // 左下角
            for (int i = m - edge; i < m; i++) {
                for (int j = 0; j < edge; j++) {
                    result[i][j] = picture[i - m + edge][n - edge + j];
                }
            }

            // 下
            for (int i = m - edge; i < m; i++) {
                for (int k = 0; k < mid; k++) {
                    for (int j = k * n + edge; j < k * n + n + edge; j++) {
                        result[i][j] = picture[i - m + edge][j - k * n - edge];
                    }
                }
            }

            // 右下角
            for (int i = m - edge; i < m; i++) {
                for (int j = m - edge; j < m; j++) {
                    result[i][j] = picture[i - m + edge][j - m + edge];
                }
            }

            for (int k = 1; k < mid; k++) {
                for (int i = k * n + edge; i < k * n + n + edge; i++) {
                    result[i] = result[i - k * n];
                }
            }

            results.add(result);
            caseNumber--;
        }

        for (char[][] result : results) {
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    System.out.print(result[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
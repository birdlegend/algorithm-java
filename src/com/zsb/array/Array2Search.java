package com.zsb.array;

import java.util.Scanner;

/**
 * http://blog.csdn.net/mine_song/article/details/64121769
 * 二维数组查找，描述见resources/array/
 * Created by zsb on 2018/3/21.
 */
public class Array2Search {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        int count = 0;
        int target = 0;
        boolean x = true;
        if (m < 0 || n < 0) {
            System.out.println("input error");
            return;
        }
        while (x) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    count++;
                }
            }
            target = sc.nextInt();
            //System.out.println(count);
            x = false;
        }
        if (count != m * n) {
            System.out.println("input error");
        } else {
            System.out.println(findItem(matrix, target));
        }
        //System.out.println(findItem(matrix, target));
    }

    public static int findItem(int[][] matrix, int item) {
        int row = 0;
        int col = matrix[0].length - 1;
        int rowNum = matrix.length;
        while (row < rowNum && col >= 0) {
            if (matrix[row][col] == item) {
                return 1;
            } else if (matrix[row][col] < item) {
                row = row + 1;
            } else {
                col = col - 1;
            }
        }
        return 0;
    }

    public boolean Find(int target, int [][] array) {
        int m = array.length;
        int n = array[0].length;

        int row = 0; int col = n-1;
        while (row < m && col >= 0) {
            if(target < array[row][col]) col--;
            else if (target > array[row][col]) row++;
            else {
                return true;
            }
        }

        return false;
    }
}

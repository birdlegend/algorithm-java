package com.zsb.codingInterviews;

import java.util.ArrayList;
import java.util.List;

/**
 * created by zsb on 2018/9/13
 *
 * @see <a href="https://birdlegend.github.io/">birdlegend的博客</a>
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        printMartixClockWisely(matrix, result, 0, matrix.length - 1, 0, matrix[0].length - 1);
        return result;
    }

    public void printMartixClockWisely(int[][] matrix, List<Integer> resultList,
                                       int rowStart, int rowEnd, int colStart, int colEnd) {
        if (rowStart > rowEnd || colStart > colEnd) return;

        if (rowStart < rowEnd && colStart < colEnd) {
            for (int j = colStart; j <= colEnd; j++) { // l -> r
                resultList.add(matrix[rowStart][j]);
            }
            for (int i = rowStart + 1; i <= rowEnd; i++) { // u -> d
                resultList.add(matrix[i][colEnd]);
            }
            for (int j = colEnd - 1; j >= colStart; j--) { // r -> l
                resultList.add(matrix[rowEnd][j]);
            }
            for (int i = rowEnd - 1; i >= rowStart+1; i--) { // d -> u
                resultList.add(matrix[i][colStart]);
            }

            printMartixClockWisely(matrix, resultList,
                    rowStart + 1, rowEnd - 1, colStart + 1, colEnd - 1);
        } else if (rowStart == rowEnd && colStart < colEnd) {
            for (int j = colStart; j <= colEnd; j++) { // l -> r
                resultList.add(matrix[rowStart][j]);
            }
        } else if (rowStart < rowEnd && colStart == colEnd) {
            for (int i = rowStart; i <= rowEnd; i++) { // u -> d
                resultList.add(matrix[i][colStart]);
            }
        } else if (rowStart == rowEnd && colStart == colEnd) {
            resultList.add(matrix[rowStart][colStart]);
        }
    }

    public static void main(String[] args) {
//        int arr[][] = new int[][]{{1}};
        int arr[][] = new int[][]{{1, 2}, {3, 4}};
        PrintMatrix printMatrix = new PrintMatrix();
        List<Integer> resultList = printMatrix.printMatrix(arr);
        System.out.println(resultList);
    }
}

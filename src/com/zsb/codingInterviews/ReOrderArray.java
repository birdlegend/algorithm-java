package com.zsb.codingInterviews;

import com.zsb.codingInterviews.minNumberInRotateArray.Solution;

import java.util.Arrays;

/**
 * created by zsb on 2018/9/12
 *
 * @see <a href="https://birdlegend.github.io/">birdlegend的博客</a>
 */
public class ReOrderArray {
    public void reOrderArray(int[] array) {
        int l = 0, r = 0;
        while (true) {
            while (r < array.length && array[r] % 2 == 0) { //找到第一个奇数
                r++;
            }

            if (r >= array.length) {
                return;
            }

            move(array, l, r);
            l++;
            r++;
        }
    }

    public void move(int[] arrary, int l, int r) {
        int odd = arrary[r];
        for (int i = r; i > l; i--) {
            arrary[i] = arrary[i - 1];
        }
        arrary[l] = odd;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        ReOrderArray solution = new ReOrderArray();
        solution.reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }

}

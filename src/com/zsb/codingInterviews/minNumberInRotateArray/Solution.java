package com.zsb.codingInterviews.minNumberInRotateArray;

import sun.misc.Sort;

import java.util.regex.Matcher;

/**
 * created by zsb on 2018/9/12
 *
 * @see <a href="https://birdlegend.github.io/">birdlegend的博客</a>
 */
public class Solution {
    /**
     * 01111 => 10111, 01112 => 20111, 1, 12
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int[] array) {
        int l = 0, r = array.length - 1;
        while (l + 1 < r) {
            int mid = (l + r) / 2;

            if (array[mid] == array[l] && array[mid] == array[r]) {
                return min(array, l, r);
            }

            if (array[mid] >= array[l]) {
                l = mid;
            } else if (array[mid] <= array[r]) {
                r = mid;
            }
        }

        return array[l] < array[r] ? array[l] : array[r];
    }


    private int min(int[] array, int l, int r) {
        int min = array[l++];
        while (l <= r) {
            min = min <= array[l] ? min : array[l];
        }

        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = new int[]{3, 4, 5, 1, 2};
        System.out.println(solution.minNumberInRotateArray(a));
    }

}

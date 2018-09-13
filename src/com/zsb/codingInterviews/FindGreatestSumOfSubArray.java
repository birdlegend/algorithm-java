package com.zsb.codingInterviews;

/**
 * created by zsb on 2018/9/13
 *
 * @see <a href="https://birdlegend.github.io/">birdlegend的博客</a>
 */
public class FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = Integer.MIN_VALUE;
        int sum = 0; //当前子串和
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            sum = sum > array[i] ? sum : array[i];
            max = max > sum ? max : sum;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
        FindGreatestSumOfSubArray findGreatestSumOfSubArray = new FindGreatestSumOfSubArray();
        System.out.println(findGreatestSumOfSubArray.FindGreatestSumOfSubArray(arr));
    }
}

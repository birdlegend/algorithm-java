package com.zsb.codingInterviews;

/**
 * created by zsb on 2018/9/13
 * 采用将军拼士兵法做
 *
 * @see <a href="https://birdlegend.github.io/">birdlegend的博客</a>
 */
public class MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null) return 0;

        int num = 1;
        int target = array[0];
        for (int i = 1; i < array.length; i++) {
            num = (target == array[i]) ? num + 1 : num - 1;

            if (num < 0) {
                target = array[i];
                num = 1;
            }
        }

        int count = 0;
        for (int i : array) {
            count = i == target ? count + 1 : count;
        }

        return count * 2 > array.length ? target : 0;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        MoreThanHalfNum moreThanHalfNum = new MoreThanHalfNum();
        System.out.println(moreThanHalfNum.MoreThanHalfNum_Solution(arr));
    }
}

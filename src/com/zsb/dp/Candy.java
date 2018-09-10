package com.zsb.dp;


/**
 * https://www.nowcoder.com/practice/74a62e876ec341de8ab5c8662e866aef?tpId=46&tqId=29045&tPage=1&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 * Created by zsb on 2018/3/28.
 */
public class Candy {

    public static void main(String[] args) {
//        int[] ratings = new int[]{7, 5, 8, 6, 9};
//        int[] ratings = new int[]{1, 3, 4, 3, 2, 1};
        int[] ratings = new int[]{1, 3, 2, 1};
        System.out.println(Candy.candy1(ratings));
    }

    public static int candy1(int[] ratings) {
        int n = ratings.length;
        int[] candy = new int[n];
        for (int i = 0; i < n; i++)
            candy[i] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i - 1] < ratings[i])
                candy[i] = candy[i - 1] + 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1])
                candy[i] = candy[i + 1] + 1;
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
//            System.out.print(candy[i] + " ");
            sum += candy[i];

        }
        return sum;
    }

    public static int candy2(int[] ratings) {
        int candy[] = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++)
            candy[i] = 1;
        for (int i = 1; i < ratings.length; i++)
            deliver(ratings, candy, i);

        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
//            System.out.print(candy[i] + " ");
            sum += candy[i];

        }
//        System.out.println();
        return sum;

    }

    public static void deliver(int[] ratings, int[] candy, int index) {
//        System.out.println(index);
        if (index <= 0)
            return;
        if (ratings[index - 1] > ratings[index]) {
            if (candy[index - 1] <= candy[index])
                candy[index - 1] = candy[index] + 1;
            deliver(ratings, candy, index - 1);

        } else if (ratings[index - 1] < ratings[index]) {
            if (candy[index - 1] >= candy[index])
                candy[index] = candy[index - 1] + 1;
        }
    }
}

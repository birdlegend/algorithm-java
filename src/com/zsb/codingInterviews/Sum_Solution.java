package com.zsb.codingInterviews;

/**
 * created by zsb on 2018/9/12
 *
 * @see <a href="https://birdlegend.github.io/">birdlegend的博客</a>
 */
public class Sum_Solution {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean b = (n > 0) && (sum += Sum_Solution(n-1)) > 0;
        return sum;
    }
}

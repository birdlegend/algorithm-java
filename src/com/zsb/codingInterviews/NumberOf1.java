package com.zsb.codingInterviews;

/**
 * created by zsb on 2018/9/12
 *
 * @see <a href="https://birdlegend.github.io/">birdlegend的博客</a>
 */
public class NumberOf1 {
    public int NumberOf1(int n) {
        int cnt = 0;
        while(n!=0) {
            n = n & (n-1);
            cnt++;
        }
        return cnt;
    }
}

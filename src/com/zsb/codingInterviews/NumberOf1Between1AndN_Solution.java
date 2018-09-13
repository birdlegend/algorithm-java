package com.zsb.codingInterviews;

import com.sun.javafx.tk.quantum.PathIteratorHelper;

/**
 * created by zsb on 2018/9/13
 *
 * @see <a href="https://birdlegend.github.io/">birdlegend的博客</a>
 */
public class NumberOf1Between1AndN_Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int high = 0, cur = 0, low = 0; // 高位、当前位、低位
        int count = 0;
        int i = 1; // 当前位

        while (n / i != 0) {
            cur = (n / i) % 10;
            high = n / (i * 10);
            low = n % i;

            if (cur == 0) {
                count += (high * i);
            } else if (cur == 1) {
                count += (high * i + low + 1);
            } else {
                count += ((high + 1) * i);
            }
            i *= 10;
        }

        return count;
    }
}

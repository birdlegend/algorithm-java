package com.zsb.codingInterviews.isNumeric;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by zsb on 2018/9/10
 *
 * @see <a href="https://birdlegend.github.io/">birdlegend的博客</a>
 */
public class Solution {
    public boolean isNumeric(char[] str) {
        // e只能出现一次，只能在中间出现。排除.e1、e1、1e
        // .可以再0位和末尾出现，如.3和3.

        boolean hasE = false;
        boolean hasSign = false;
        boolean hasPoint = false;
        for (int i = 0; i < str.length; i++) {
            if (isE(str[i])) {
                if (i == str.length - 1) { // e不能在末尾
                    return false;
                }
                if (hasE) { // 不能有两个e
                    return false;
                }
                hasE = true;
            } else if (isSign(str[i])) {
                if (i == str.length - 1) { // 不能在末尾
                    return false;
                }

                if (!hasSign && i > 0 && !isE(str[i - 1])) { //第一次出现符号并且不是首位
                    return false;
                } else if (hasSign && !isE(str[i - 1])) { // 第二个符号位只能在e后面
                    return false;
                }
                hasSign = true;
            } else if (str[i] == '.') {
                // 如果没有整数部分，必须有小数部分, 小数部分无符号
                if (hasE || hasPoint) { // e后面不能接小数点
                    return false;
                }
                hasPoint = true;
            } else if (!isNumber(str[i])) {
                return false;
            }
        }

        return true;

    }


    boolean isE(char e) {
        return e == 'e' || e == 'E';
    }

    boolean isSign(char sign) {
        return sign == '+' || sign == '-';
    }

    boolean isNumber(char num) {
        return num >= '0' && num <= '9';
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        List<String> list = Arrays.asList(
                "+100", "5e2", "-123", "3.1416", "-1E-16",
                "12e", "1a3.14", "1.2.3", "+-5", "12e+4.3"
        );
        for (String s : list) {
            System.out.println(solution.isNumeric(s.toCharArray()));
        }
    }
}

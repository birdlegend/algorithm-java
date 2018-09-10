package com.zsb.codingInterviews.regexMatch;

/**
 * created by zsb on 2018/9/10
 *
 * @see <a href="https://birdlegend.github.io/">birdlegend的博客</a>
 */
public class Solution {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }


        return matchCore(str, 0, pattern, 0);
    }

    private boolean matchCore(char[] str, int indexS, char[] pattern, int indexP) {
        if (indexS >= str.length && indexP >= pattern.length) {
            return true;
        }

        if (indexS < str.length && indexP >= pattern.length) { // pattern匹配完了，但str还有字符未匹配
            return false;
        }


        if (indexP < pattern.length - 1 && pattern[indexP + 1] == '*') {
            if (indexS >= str.length) {
                return matchCore(str, indexS, pattern, indexP + 2);
            }

            if (str[indexS] == pattern[indexP] || pattern[indexP] == '.') { //字符相同或者pattern为.*
                return matchCore(str, indexS + 1, pattern, indexP + 2) ||
                        matchCore(str, indexS + 1, pattern, indexP) ||
                        matchCore(str, indexS, pattern, indexP + 2);
            } else { // 非.*
                return matchCore(str, indexS, pattern, indexP + 2);
            }

        } else { // 非*
            if (indexS >= str.length) {
                return false;
            }

            if (str[indexS] == pattern[indexP] || pattern[indexP] == '.') {
                return matchCore(str, indexS + 1, pattern, indexP + 1);
            }
        }

        return false;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
//        String str = "";
//        String pattern = ".";
//        String str = "";
//        String pattern = ".*";

//        String str = "a";
//        String pattern = "a.";
//        String str = "a";
//        String pattern = "ab*a";

//        String str = "aa";
//        String pattern = "a*";

        String str = "aaa";
        String pattern = "ab*a";
        System.out.println(solution.match(str.toCharArray(), pattern.toCharArray()));
    }
}

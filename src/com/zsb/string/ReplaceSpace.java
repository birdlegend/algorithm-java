package com.zsb.string;

/**
 * https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Created by zsb on 2018/3/24.
 */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll(" ", "%20");
    }

    /*
    问题1：替换字符串，是在原来的字符串上做替换，还是新开辟一个字符串做替换！
    问题2：在当前字符串替换，怎么替换才更有效率（不考虑java里现有的replace方法）。
          从前往后替换，后面的字符要不断往后移动，要多次移动，所以效率低下
          从后往前，先计算需要多少空间，然后从后往前移动，则每个字符只为移动一次，这样效率更高一点。
    */
    public static String replaceSpace1(StringBuffer str) {
//        return str.toString().replaceAll(" ", "%20");

        int len = str.length();
        int spaceNum = 0, offset = 0; //spaceNum表示一个字符前面有几个空格
        char cur;
        for (int i = 0; i < len; i++)
            spaceNum = (str.charAt(i) == ' ') ? spaceNum + 1 : spaceNum;

        offset = spaceNum * 2;

//        System.out.println("spaceNum: " + spaceNum);
        str.setLength(len + spaceNum * 2);

        for (int i = len - 1; i >= 0; i--) {
//            System.out.println(i + ": " + offset);

            cur = str.charAt(i);
            if (cur == ' ') {
                spaceNum--;
                offset = spaceNum * 2;

                str.setCharAt(i + offset, '%');
                str.setCharAt(i + offset + 1, '2');
                str.setCharAt(i + offset + 2, '0');

            } else
                str.setCharAt(i + offset, cur);
//            System.out.println(str.toString());
        }

        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("hello world test");
//        System.out.println(stringBuffer.length());
        System.out.println(ReplaceSpace.replaceSpace1(stringBuffer));
    }

}

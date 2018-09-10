package com.zsb.toutiao;

/**
 * 定义两个字符串变量：s和m，再定义两种操作，
 * <p>
 * 第一种操作：
 * <p>
 * m = s;
 * s = s + s;
 * 第二种操作：
 * <p>
 * s = s + m;
 * <p>
 * 假设s, m初始化如下：
 * <p>
 * s = "a";
 * m = s;
 * 求最小的操作步骤数，可以将s拼接到长度等于n
 * <p>
 * 输入描述：
 * 一个整数n，表明我们需要得到s字符长度，0<n<10000
 * 输出描述：
 * 一个整数，表明总共操作次数
 * Created by zsb on 2018/3/26.
 */
public class Ti2 {
    /**
     * 求以2为底的对数，
     *
     * @param even，正偶整数
     * @return
     */
    public static int log2(int even) {
        for (int i = 0; i <= even / 2; i++) {
            int pow = (int) Math.pow(2, i);
            if (even <= pow)
                return i;
        }

        return -1;
    }


    public static int getOperateNum2(int n) {
        if (n <= 0) {
            return 0;
        } else {
            if (n == 1) {
                return 0;
            }
            if (n == 2) {
                return 1;
            }
            if (n % 2 == 0) {
                return getOperateNum2(n / 2) + 1;
            } else {
                int i;
                for (i = 3; i < n / 2; i++) {
                    if (n % i == 0) {
                        break;
                    }
                }
                if (i >= n / 2) {
                    return n - 1;
                } else {
                    return getOperateNum2(n / i) + i - 1;
                }
            }
        }
    }

    public static void main(String[] args) {
//        for (int i = 1; i < 60; i += 2)
//            System.out.println("i" + i + "    " + getOperateNum1(i) + " : " + getOperateNum2(i));

    }


}

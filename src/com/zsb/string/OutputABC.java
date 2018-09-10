package com.zsb.string;

/**
 * 三个线程依次打印出abc
 * Created by zsb on 2018/4/1.
 */
public class OutputABC {
    static volatile  int  flag = 0;

    public static void main(String[] args) {

        final int n = 10;
        for (int i = 0; i < n; i++) {
            final int key = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
//                        System.out.println( flag + " " + key);
                        if (flag == key) {
                            char c = (char) ('a' + flag);
                            System.out.print(c);
                            flag = (flag + 1) % n;
                        }
                    }
                }
            }).start();
        }

    }

}

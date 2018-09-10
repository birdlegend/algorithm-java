package com.zsb.weizong;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by zsb on 2018/4/16.
 */
import java.util.Scanner;

public class Main {
    static Map<Long, Boolean> cache = new HashMap<>();

    public static boolean isPalindrome(long n) {
        if (cache.containsKey(n))
            return cache.get(n);

        long count = 0;
        long m1 = n, m2 = 0;
        for (count = 0; m1 != 0; count++)
            m1 >>= 1;
        m1 = n;
        count--;
        while (count > m2) {
            if (((m1 >> count) & 1) != ((m1 >> m2) & 1)) {
                cache.put(n, false);
                return false;
            }
            count--;
            m2++;
        }
        cache.put(n, true);
        return true;
    }

    public static void main(String[] args) {
        long count = 0;
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();

        for (long i = 0; i <= n; i++) {
            if (isPalindrome(i))
                count++;
        }
        System.out.println(count);
    }
}

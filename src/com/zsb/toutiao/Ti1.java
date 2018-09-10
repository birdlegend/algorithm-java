package com.zsb.toutiao;

import java.util.*;

/**
 5 2
 1 5 3 4 2
 5 0
 1 1 2 2 2
 * Created by zsb on 2018/3/24.
 */
public class Ti1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();


        List tmp = new ArrayList(n);
        Set mul = new HashSet();
        Set all = new HashSet();

        int cur;
        for (int i = 0; i < n; i++) {
            cur = sc.nextInt();
            tmp.add(cur);
        }

        Iterator<Integer> iterator = tmp.iterator();

        while (iterator.hasNext()) {
            cur = iterator.next();
//            System.out.println(cur);

            if (all.contains(cur)) {
//                System.out.println("cur: " + cur);
                if (!mul.contains(cur))
                    mul.add(cur);
            } else {
                all.add(cur);
//                System.out.println(cur);
            }

        }
        System.out.println(Ti1.count(all, mul, k));
    }

    public static int count(Set<Integer> all, Set<Integer> mul, int k) {
        Set<Integer> visited = new HashSet<>();

        Iterator<Integer> iterator = all.iterator();

        int cur, num = 0;
        while (iterator.hasNext()) {
            cur = iterator.next();
            if (!visited.contains(cur)) { //no visited
                if (k == 0)
                    return mul.size();

                if (all.contains(cur - k)) {
                    num++;
//                    System.out.println(cur + " : " + (cur - k));
                }
                if (all.contains(cur + k)) {
                    num++;
//                    System.out.println(cur + " : " + (k + cur));
                }
//                System.out.println("visit: " + cur);
                visited.add(cur);
            }
        }

        return num / 2;
    }

}

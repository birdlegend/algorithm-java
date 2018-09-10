package com.zsb.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zsb on 2018/3/28.
 */
public class T3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        line = line.replace(" ", "");
        String[] str_arrays = line.split(",");

        int[] array = new int[str_arrays.length];
        for (int i = 0; i < str_arrays.length; i++) {
            array[i] = Integer.parseInt(str_arrays[i]);
        }

//       -3, -1, 6,  -3, 2, -2, 7, -15,1,2,2
//        System.out.println(FindGreatestSumOfSubArray1(array));
        System.out.println(FindGreatestSumOfSubArray2(array));
    }

    /**
     * dp实现
     *
     * @param array
     * @return
     */
    public static int FindGreatestSumOfSubArray2(int[] array) {
        int sum = Integer.MIN_VALUE, b = 0;
        for (int i = 0; i < array.length; i++) {
            System.out.println(b + " " + sum);
            if (b > 0) b += array[i];
            else b = array[i];
            if (b > sum) sum = b;
        }

        return sum;
    }

    public static int FindGreatestSumOfSubArray1(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                list.add(sum);
            }
        }
        if (list.size() <= 0) return 0;
        Collections.sort(list);
        return list.get(list.size() - 1);
    }

}

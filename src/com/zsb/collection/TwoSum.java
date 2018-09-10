package com.zsb.collection;

import com.sun.tools.jdi.LinkedHashMap;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by zsb on 2018/3/27.
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
//        TwoSum.show(arr, 7);
//        TwoSum.show(arr, 6);
//        TwoSum.show(arr, 8);
        System.out.println(TwoSum.findNumbersWithSum(arr, 7).toString());
    }

    public static void show(int arr[], int target) {
        int len = arr.length;

        Map<Integer, Integer> map = new LinkedHashMap();
        for (int i = 0; i < len; i++) {
            int n1 = arr[i];
            int n2 = target - n1;
            if (map.containsKey(n2)) {
                System.out.println(i + " " + map.get(n2));
            } else {
                map.put(n1, i);
            }
        }
    }

    /**
     * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
     * 输出描述:
     * 对应每个测试案例，输出两个数，小的先输出。
     */
    public static ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>(2);

//        if (array == null || array.length < 2)
//            return res;
//        

        int l = 0, r = array.length - 1;
        while (l < r) {
            int lv = array[l];
            int rv = array[r];
            int s = lv + rv;
            if (s < sum) l++;
            else if (s > sum) r--;
            else {
                // 该数组已经递增排序，第一组的乘机最小，即使有负数也一样。
                res.add(lv);
                res.add(rv);
                break;
            }
        }


        return res;
    }
}

package com.zsb.SwordOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?tpId=13&tqId=11160&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Created by zsb on 2018/4/15.
 */
public class Fibonacci {
    public List<Integer> arr = new ArrayList();


    public static void main(String[] args) {

    }

    public int Fibonacci(int n) {
        if(n <= 0) {
            return n;
        }


        int a=0, b=1, res=0;
        for(int i=2; i<=n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }
}

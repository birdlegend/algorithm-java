package com.zsb.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T2 {

    public static void main(String[] args) {
        String des = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        String src = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int n = 52;

        Map<Character, Character> map = new HashMap<>(n);
        for(int i=0; i<n; i++) {
            map.put(src.charAt(i), des.charAt(i));
        }

        Scanner scanner = new Scanner(System.in);
        String target = scanner.nextLine();
        StringBuilder res = new StringBuilder(target.length());

        for(int i=0; i<target.length(); i++) {
            char c = target.charAt(i);
            if (map.containsKey(c)) {
                res.append(map.get(c));
            }
            else
                res.append(c);
        }
        System.out.println(res.toString());
    }


}

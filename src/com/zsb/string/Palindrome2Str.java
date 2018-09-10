package com.zsb.string;
import java.util.Scanner;

/**
 * 回文-拼接字符串, 描述见resources/string/
 * Created by zsb on 2018/3/21.
 */
public class Palindrome2Str {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result = 0;
        int nums = scanner.nextInt();
        String[] array = new  String[nums];
        int i = 0;
        scanner.nextLine();
        while (i < nums){
            array[i] = scanner.nextLine();
            i++;
        }

        for (int k = 0 ;k < nums; k++){
            for (int m = 0; m < nums; m++){
                if (k == m ) continue;
                else {
                    String temp = array[k]+array[m];
                    if (temp.equals("")) continue;
                    else if (isHuiWen(temp))  result++;
                }
            }
        }
        System.out.println(result);
    }
    private  static  boolean isHuiWen(String s){
        int n=s.length()/2;
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i) != s.charAt(s.length()-1-i))
                return false;
        }
        return true;
    }

}

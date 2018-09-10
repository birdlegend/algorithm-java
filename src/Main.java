//import java.util.Scanner;
//
//public class Main {
//    public int getMin(int n) {
//        if (n <= 0) {
//            return 0;
//        } else {
//            if (n == 1)
//                return 0;
//            if (n == 2)
//                return 1;
//            if (n % 2 != 0) {
//                int offset;
//                for (offset = 3; offset < n / 2; offset++) {
//                    if (n % offset == 0) {
//                        break;
//                    }
//                }
//                if (offset >= n / 2) {
//                    return n - 1;
//                } else {
//                    return getMin(n / offset) + offset - 1;
//                }
//            } else {
//                return getMin(n / 2) + 1;
//            }
//        }
//    }
//
//    public static void main(String[] args) {
////        Scanner sc = new Scanner(System.in);
////        int n = sc.nextInt();
////        Main main = new Main();
////        System.out.println(main.getMin(n));
//
//        for(int i=0; i<=9; i++)
//    }
//}
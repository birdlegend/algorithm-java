package string;


/**
 * sunnday算法实现字符串匹配
 * Created by zsb on 2018/2/27.
 */
public class SundayMatch {
    public static void main(String[] args) {
        String source = "codemmon";
        String match = "mon";//
//      String source = "mmon";
//        String match = "mmon";
//        System.out.println(  SundayMatch(source, match));
        System.out.println(  sundayMatch(source, match));

    }


    /**
     * @param source
     * @param match
     * @return
     */
    public static int sundayMatch(String source, String match) {

        // match大于source
        if(source == null || match == null || source.length() < match.length())
            return -1;

        int len1 = source.length();
        int len2 = match.length();

        // 定义一个字符数组，计算待匹配字符串中的字符到末尾的长度
        int[] move = new int[256];
        for(int i=0; i<256; i++)
            move[i] = -1;

        // 待匹配字符串中的字符到末尾的长度， 0位、1位....n-1位字符的move分别为len-1、 len-2、...、1
        for(int i=match.length()-1; i>=0; i--) {
            if (move[match.charAt(i)] == -1)
                move[match.charAt(i)] = len2 - i;
        }


        int start=0, i = 0, j=0;
        while(i < len1 && j < len2) {
            if(source.charAt(i) == match.charAt(j)) { //match的前j个字符匹配成功
                i++;
                j++;
                if(j >= len2) // mathc中所有字符匹配成功
                    return start;
            } else {
                if(start + len2 > len1 -1) // source下一个比较的子串长度小于match
                    return -1;

                int step = move[source.charAt(start + len2)]; // 如果source中start+len2位置的是待匹配字符，返回其在match中到末尾的长度。
                if(step == -1) {// source 在start+len2处的字符不是match的待匹配字符
                    start = start + len2 + 1; // 从source的start+len2+1处重新匹配。
                    i = start;
                    j = 0;
                } else  { // 找到source的start位
                    // 当step为1时，表示source中start+len2位置的字符与match的最后一个字符匹配，所有要从source的start + 1位置与match进行比较。
                    start = start + step;
                    i = start;
                    j = 0;
                }
            }
        }

        return -1;
    }

    //
//    private static int SundayMatch(String source, String match) {
//        if (source == null || match == null || source.length() < match.length()) {
//            return -1;
//        }
//        int[] move = new int[256];
//        Arrays.fill(move, -1);
//        //计算带匹配字符串中每个字符到末尾的长度
//        for (int i = match.length() - 1; i >= 0; i--) {
//            if (move[match.charAt(i)] == -1)
//                move[match.charAt(i)] = match.length() - i;
//        }
//
//        int start = 0;
//        int i = 0;
//        int j = 0;
//
//        while (j < match.length() && i < source.length()) {
//            if (source.charAt(i) == match.charAt(j)) {
//                i++;
//                j++;
//                System.out.println("a----- i: " + i + " , j: " +  j);
//                System.out.println("start: " + start);
//                if (j == match.length()) {
//                    return start;
//                }
//            } else {
//                System.out.println("step: " + source.charAt(start + match.length()));
//                if (start + match.length() > source.length() - 1) {
//                    return -1;
//                }
//                if (move[source.charAt(start + match.length())] == -1) {
//                    start = start + match.length() + 1;
//                    i = start;
//                    j = 0;
//                    System.out.println("b----- i: " + i + " , j: " +  j);
//                    System.out.println("start: " + start);
//
//
//                } else if (move[source.charAt(start + match.length())] != -1) {
//                    start = start + move[source.charAt(start + match.length())];
//                    i = start;
//                    j = 0;
//                    System.out.println("c----- i: " + i + " , j: " +  j);
//                    System.out.println("start: " + start);
//
//                }
//            }
//        }
//        return -1;
//    }
}

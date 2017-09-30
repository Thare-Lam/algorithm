//package company.xiaohongshu._20170928._01;
//
//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {
//            String str = in.next();
//            String result = process(str);
//            System.out.println(result);
//        }
//    }
//
//    private static String process(String str) {
//        if (noNumber(str)) {
//            return "-1";
//        }
//        str = removeRed(str);
//        String[] strList = str.split("[A-Z]+");
//        String max = strList[0];
//        for (String s : strList) {
//            if (compare(s, max) > 0) {
//                max = s;
//            }
//        }
//        return max;
//    }
//
//    private static int compare(String a, String b) {
//        int lenA = a.length();
//        int lenB = b.length();
//        int i = 0;
//        int j = 0;
//        char x, y;
//        while (i < lenA && j < lenB) {
//            while (i < lenA && a.charAt(i) == '0') {
//                ++i;
//            }
//            if (i == lenA) {
//                break;
//            }
//            x = a.charAt(i);
//            while (j < lenB && b.charAt(j) == '0') {
//                ++j;
//            }
//            if (j == lenB) {
//                break;
//            }
//            y = a.charAt(i);
//            if (x > y) {
//                return 1;
//            } else if (x < y) {
//                return -1;
//            }
//            ++i;
//            ++j;
//        }
//        if (i == lenA) {
//            return -1;
//        } else if (j == lenB) {
//            return 1;
//        }
//        return 1;
//        int lenGap = a.length() - b.length();
//        if (lenGap > 0) {
//            return 1;
//        } else if (lenGap < 0) {
//            return -1;
//        } else {
//            int i = 0;
//            int len = a.length();
//            while (i < len) {
//                if (a.charAt(i) > b.charAt(i)) {
//                    return 1;
//                } else if (a.charAt(i) < b.charAt(i)) {
//                    return -1;
//                }
//                ++i;
//            }
//            return 1;
//        }
//    }
//
//    private static String removeRed(String str) {
//        int index = str.indexOf("RED");
//        if (index != -1) {
//            return removeRed(str.substring(0, index) + str.substring(index + 3));
//        }
//        return str;
//    }
//
//    private static boolean noNumber(String str) {
//        for (int i = str.length() - 1; i >= 0; --i) {
//            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
//                return false;
//            }
//        }
//        return true;
//    }
//
//}

package cn.istarx.java;

public class NO9_PalindromeNumber {
    public static void main(String[] args) {
        long x = 121;
        System.out.println(isPalindrome(x));
    }

    private static boolean isPalindrome(long x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        long reverseNumber = 0;
        long tmp = x;
        while (tmp != 0) {
            reverseNumber = reverseNumber * 10 + tmp % 10;
            tmp /= 10;
            if (tmp == reverseNumber) {
                return true;
            }
        }
        return reverseNumber == x;

        /*
        可以优化成只反转后半段
        reverseNumber = 0;
        while (reverseNumber < x) {
            reverseNumber = reverseNumber * 10 + x % 10;
            x = x / 10;
        }
        return x == reverseNumber || x == reverseNumber / 10 ;*/
    }
}

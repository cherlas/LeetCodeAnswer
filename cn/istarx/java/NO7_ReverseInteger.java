package cn.istarx.java;

public class NO7_ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(Integer.MAX_VALUE));
    }

    private static int reverse(int x) {
        boolean isLessThanZero = x < 0;
        long tmp = isLessThanZero ? x * -1L : x;
        long reverseNumber = 0;
        while (tmp != 0) {
            reverseNumber = reverseNumber * 10 + tmp % 10;
            tmp /= 10;
        }
        return reverseNumber > Integer.MAX_VALUE ? 0 : (int) (isLessThanZero ? reverseNumber * -1 : reverseNumber);
    }
}

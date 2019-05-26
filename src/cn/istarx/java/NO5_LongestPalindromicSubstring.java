package cn.istarx.java;

public class NO5_LongestPalindromicSubstring {
    public static void main(String[] args) {
        String input = "cbbd";
        System.out.println(longestPalindrome(input));
    }

    static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        boolean[][] temp = new boolean[len][len];
        int maxLen = 1;
        int start = 0;
        for (int i = 0; i < len - 1; i++) {
            temp[i][i] = true;
            if (s.charAt(i) == s.charAt(i + 1)) {
                maxLen = 2;
                temp[i][i + 1] = true;
                start = i;
            }
        }
        temp[len - 1][len - 1] = true;
        for (int tmpLen = 3; tmpLen <= len; tmpLen++) {
            for (int i = 0; i < len - tmpLen + 1; i++) {
                int j = i + tmpLen - 1;
                if (temp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    maxLen = tmpLen;
                    start = i;
                    temp[i][j] = true;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}

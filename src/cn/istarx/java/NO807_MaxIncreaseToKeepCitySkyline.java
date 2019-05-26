package cn.istarx.java;

public class NO807_MaxIncreaseToKeepCitySkyline {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {3, 0, 8, 4},
                {2, 4, 5, 7},
                {9, 2, 6, 3},
                {0, 3, 1, 0}
        };
        System.out.println(maxIncreaseKeepingSkyline(grid));
    }

    private static int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0 ||
                grid.length == 1 && grid[0].length == 1) {
            return 0;
        }
        int N = grid.length;
        int[] leftRight = new int[N];
        int[] topBottom = new int[N];
        for (int i = 0; i < N; i++) {
            for(int j = 0; j< N; j++) {
                leftRight[i] = Math.max(leftRight[i], grid[i][j]);
                topBottom[i] = Math.max(topBottom[i], grid[j][i]);
            }
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res += Math.min(leftRight[i], topBottom[j]) - grid[i][j];
            }
        }
        return res;
    }
}

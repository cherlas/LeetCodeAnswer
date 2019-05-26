class Solution:
    def maxIncreaseKeepingSkyline(self, grid: List[List[int]]) -> int:
        if not grid or len(grid) == 0 or len(grid) ==1:
            return 0
        N = len(grid)
        row = [-1] * N
        col = [-1] * N
        for i in range(N):
            for j in range(N):
                row[i] = max(row[i], grid[i][j])
                col[i] = max(col[i], grid[j][i])
        res = 0
        for i in range(N):
            for j in range(N):
                res = res + min(row[i], col[j]) - grid[i][j]
        return res
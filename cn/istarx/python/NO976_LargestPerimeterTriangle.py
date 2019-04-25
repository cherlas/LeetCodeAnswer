class Solution:
    def largestPerimeter(self, A: list) -> int:
        self.quick_sort(A, 0, len(A) - 1)
        for i in range(len(A) - 3, -1, -1): # -1 
            if A[i] + A[i + 1] > A[i + 2]:
                return A[i] + A[i + 1] + A[i + 2]
        return 0

    def quick_sort(self, A: list, start: int, end: int) -> None:
        if start >= end:
            return
        pivot = self.partition(A, start, end)
        self.quick_sort(A, start, pivot - 1)
        self.quick_sort(A, pivot + 1, end)

    @staticmethod
    def partition(A: list, start: int, end: int) -> int:
        pivot = A[end]
        i = start
        for j in range(start, end, 1):
            if A[j] < pivot:
                A[i], A[j] = A[j], A[i]
                i = i + 1
        A[i], A[end] = A[end], A[i]
        return i


if __name__ == '__main__':
    print(str(Solution().largestPerimeter([2, 1, 2])))

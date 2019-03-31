package cn.istarx.java;

public class NO976_LargestPerimeterTriangle {
    public static void main(String[] args) {
        int[] A = new int[]{1, 1, 2};
        System.out.println(largestPerimeter(A));
    }

    private static int largestPerimeter(int[] A) {
        quickSort(A, 0, A.length - 1); // increase
        int numCount = A.length;
        for (int index = numCount - 3; index >= 0; index--) {
            if (A[index] + A[index + 1] > A[index + 2]) {
                return A[index] + A[index + 1] + A[index + 2];
            }
        }
        return 0;
    }

    private static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partition(nums, start, end);
        quickSort(nums, start, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    private static int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, end);
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}
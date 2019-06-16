package cn.istarx.java;

public class NO654_MaximumBinaryTree {

    public static void main(String[] args) {

    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private static TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        int maxValPosition = findMaxValueBetweenPosition(nums, start, end);
        if (maxValPosition == -1) {
            return null;
        }
        TreeNode head = new TreeNode(nums[maxValPosition]);
        head.left = constructMaximumBinaryTree(nums, start, maxValPosition - 1);
        head.right = constructMaximumBinaryTree(nums, maxValPosition + 1, end);
        return head;
    }

    private static int findMaxValueBetweenPosition(int[] nums, int start, int end) {
        if (start > end) {
            return -1;
        } else if (start == end) {
            return start;
        }
        int maxValPos = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[maxValPos]) {
                maxValPos = i;
            }
        }
        return maxValPos;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

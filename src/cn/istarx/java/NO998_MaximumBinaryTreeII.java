package cn.istarx.java;

public class NO998_MaximumBinaryTreeII {
    public static void main(String[] args) {

    }

    public static TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode tmp = new TreeNode(val);
        if (root == null) {
            return tmp;
        }
        if (val > root.val) {
            tmp.left = root;
            return tmp;
        }
        TreeNode head = root;
        while (head.right != null && val < head.right.val) {
            head = head.right;
        }

        if (head.right == null) {
            head.right = tmp;
        } else {
            TreeNode tmp1 = head.right;
            head.right = tmp;
            tmp.left = tmp1;
        }

        return root;
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

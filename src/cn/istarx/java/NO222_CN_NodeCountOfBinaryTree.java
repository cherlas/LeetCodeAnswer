package cn.istarx.java;

public class NO222_CN_NodeCountOfBinaryTree {
    public static void main(String[] arts) {
        TreeNode node = new TreeNode(1);
        System.out.println(countNodes(node));
    }

    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

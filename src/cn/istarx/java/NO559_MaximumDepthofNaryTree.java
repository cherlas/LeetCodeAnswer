package cn.istarx.java;

import java.util.List;

public class NO559_MaximumDepthofNaryTree {
    public static void main(String[] args) {
        System.out.println();
    }

    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children == null || root.children.size() == 0) {
            return 1;
        }

        int maxDepth = -1;
        for (Node node: root.children) {
            maxDepth = Math.max(maxDepth, maxDepth(node));
        }
        return maxDepth + 1;
    }

    private class Node {
        int val;
        List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}

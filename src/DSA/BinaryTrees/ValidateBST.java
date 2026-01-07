package dsa.binarytrees;

import java.util.*;

public class ValidateBST {

    //Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        boolean isBST = false;

        public boolean isValidBST(TreeNode root) {
            if (root.left == null && root.right == null) {
                return true;
            }

            int l = getMax(root.left, Integer.MIN_VALUE);
            int r = getMax(root.right, Integer.MIN_VALUE);

            System.out.println("l and r " + l + ", "+ r);
            System.out.println( l < root.val && r > root.val);
            return l < root.val && r > root.val;

        }

        public int getMax(TreeNode root, int max) {
            if (root == null) {
                return Integer.MIN_VALUE;
            }

            int l = getMax(root.left, max);
            int r = getMax(root.right, max);

            return Math.max(Math.max(l, root.val), r);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        Solution solution = new Solution();
        solution.isValidBST(root);

        //[5,1,4,null,null,3,6]
    }
}

package dsa.dp;

import java.util.*;


//Definition for a binary tree node.
class TreeNode {
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

public class DPonTrees {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        getAllPaths(root, targetSum, temp);

        return result;

    }

    public List<Integer> getAllPaths(TreeNode root, int targetSum, List<Integer> temp) {

        if (root == null) {
            temp.clear();
            return temp;
        }
        temp.add(root.val);
        System.out.println("printing parameter at each level root-> left, targetSum, temp : "+ root.left +","+ (targetSum - root.val) +","+ temp);
        List<Integer> leftPath = getAllPaths(root.left, targetSum - root.val, temp);
        System.out.println("printing parameter at each level root-> right, targetSum, temp : "+ root.left +","+ (targetSum - root.val) +","+ temp);
        List<Integer> rightPath = getAllPaths(root.right, targetSum - root.val, temp);

        if (root.left == null && root.right == null && targetSum - root.val == 0) {
            System.out.println("going here");
            result.add(temp);
        }


        return temp;
    }


    public static void main(String[] args) {
        DPonTrees dpobj = new DPonTrees();

        TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1))));
        int targetSum = 22;

        System.out.println("paths with target sum : "+ dpobj.pathSum(root,targetSum));

    }
}




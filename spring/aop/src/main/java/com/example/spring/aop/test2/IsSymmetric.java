package com.example.spring.aop.test2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public class IsSymmetric {


    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> sumValue = new LinkedList<Integer>();
        queue.offer(root);
        sumValue.offer(root.val);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            int value = sumValue.poll();
            if (treeNode.left == null && treeNode.right == null && targetSum == value) {
                return true;
            }
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
                sumValue.offer(value + treeNode.left.val);
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
                sumValue.offer(value + treeNode.right.val);
            }
        }
        return false;
    }

    private void hasPathSum(TreeNode root, int targetSum, int sum, AtomicBoolean atomicBoolean) {
        sum = sum + root.val;
        if (root.left == null && root.right == null && sum == targetSum) {
            atomicBoolean.set(true);
        }
        if (atomicBoolean.get()) {
            return;
        }
        if (sum >= targetSum) {
            return;
        }
        if (root.left != null) {

            hasPathSum(root.left, targetSum, sum, atomicBoolean);

        }
        if (root.right != null) {
            hasPathSum(root.right, targetSum, sum, atomicBoolean);
        }
    }

    public class TreeNode {
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


}

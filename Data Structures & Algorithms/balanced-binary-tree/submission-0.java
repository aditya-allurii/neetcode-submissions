/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int leftHeight = height(root.left);   // Height of the left subtree
        int rightHeight = height(root.right); // Height of the right subtree
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(leftHeight - rightHeight) <= 1;
    }
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
    }

    int left = height(root.left);
    int right = height(root.right);

    return Math.max(left, right) + 1;
}
}

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
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return ans;
    }
    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftsum = helper(root.left);
        int rightsum = helper(root.right);

        leftsum = Math.max(0,leftsum);
        rightsum = Math.max(0,rightsum);

        int pathsum = leftsum + rightsum + root.val;
        ans = Math.max(ans,pathsum);
        return Math.max(leftsum,rightsum) + root.val;
    }
}

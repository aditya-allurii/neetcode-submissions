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
    public boolean isValidBST(TreeNode root) {
        return isValid(root,null,null);
    }

    private boolean isValid(TreeNode root,Integer low,Integer high){
        //initally low and high = null so Integer , int != null

        if(root == null){
            return true;
        }

        // A node is valid iff low < root.val < high

        if(low != null && root.val <= low){
            return false;
        }

        if(high != null && root.val >= high){
            return false;
        }

        boolean left_tree = isValid(root.left,low,root.val);
        boolean right_tree = isValid(root.right,root.val,high);

        // A BST is valid iff left and right trees are valid
        return left_tree && right_tree;
    }
}

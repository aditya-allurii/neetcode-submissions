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
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0;i < inorder.length;i++){
            map.put(inorder[i],i);
        }

        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    private TreeNode build(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        int rootval = preorder[preStart];
        TreeNode root = new TreeNode(rootval);
        int index = map.get(rootval);
        int leftsize = index - inStart;
        root.left = build(preorder,preStart + 1,preStart + leftsize,inorder,inStart,index -1);
        root.right = build(preorder,preStart + leftsize + 1,preEnd,inorder,index + 1,inEnd);

        return root;
    }
}

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        // first in first out remove root and add its childs .....
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            int current_Level_Size = queue.size();
            List<Integer> current_Level = new ArrayList<>(current_Level_Size);
            for(int i = 0;i < current_Level_Size;i++){
                TreeNode current_Node = queue.poll();
                current_Level.add(current_Node.val);

                if(current_Node.left != null){
                    queue.offer(current_Node.left);
                }

                if(current_Node.right != null){
                    queue.offer(current_Node.right);
                }
            }
            result.add(current_Level);
        }
        return result;
    }
}

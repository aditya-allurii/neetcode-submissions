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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
         StringBuilder sb = new StringBuilder();
         helper(root,sb);
         return sb.toString();
    }
    private void helper(TreeNode root,StringBuilder sb){
        if(root == null){
            sb.append("null,");// ',' important
            return;
        }
        sb.append(root.val).append(",");
        helper(root.left,sb);
        helper(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));

        return helper2(queue);
    }
    private TreeNode helper2(Queue<String> queue){
        String val = queue.poll();
        if(val.equals("null")){
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(val));

        root.left = helper2(queue);
        root.right = helper2(queue);

        return root;
    }
}

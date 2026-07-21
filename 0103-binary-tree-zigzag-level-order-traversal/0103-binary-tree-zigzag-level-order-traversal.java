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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        boolean reverse = false;

        while(!queue.isEmpty()){
            int lvlNum = queue.size();
            List<Integer> currlvl = new ArrayList<>();

            for(int i=0; i<lvlNum; i++){
                if(!reverse){
                    TreeNode curr = queue.pollFirst();
                    currlvl.add(curr.val);
                    if(curr.left != null) queue.addLast(curr.left);
                    if(curr.right != null) queue.addLast(curr.right);
                }else{
                    TreeNode curr = queue.pollLast();
                    currlvl.add(curr.val);
                    if(curr.right != null) queue.addFirst(curr.right);
                    if(curr.left != null) queue.addFirst(curr.left);
                }
            }
            result.add(currlvl);
            reverse = !reverse;
        }
        return result;
    }
}
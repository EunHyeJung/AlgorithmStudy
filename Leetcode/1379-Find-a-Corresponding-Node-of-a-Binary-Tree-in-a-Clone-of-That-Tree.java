/*
* @source https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.05.17
*/
class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(cloned) ;
        
        while(!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            if (curNode.val == target.val)
                return curNode;
            
            if (curNode.left != null)
                queue.add(curNode.left);
            if (curNode.right != null)
                queue.add(curNode.right);
        }
            
        
        return target;
    }
}

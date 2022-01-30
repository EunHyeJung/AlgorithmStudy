/*
* @source https://leetcode.com/problems/maximum-depth-of-binary-tree/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.01.30
*/
class Solution {
    public int maxDepth(TreeNode root) {
        return getMaxDepth(root, 0);
    }
    
    public int getMaxDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int maxDepth = getMaxDepth(root.left, depth + 1);
        return Math.max(maxDepth, getMaxDepth(root.right, depth + 1));
    }
}

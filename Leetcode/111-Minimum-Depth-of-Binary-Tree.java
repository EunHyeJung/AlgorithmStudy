/*
* @source https://leetcode.com/problems/minimum-depth-of-binary-tree/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.02.01
*/
class Solution {
    private int depth = 0;
    public int minDepth(TreeNode root) {
        if (root == null)   return depth;
        else if (root.left == null && root.right == null) return depth + 1;
        searchTree(root, 1);
        return depth;
    }
    public void searchTree(TreeNode node, int curDepth) {
        if (node.left != null)
            searchTree(node.left, curDepth + 1);
        if (node.right != null)
            searchTree(node.right, curDepth + 1);
        if (node.left == null && node.right == null)
            depth = (depth == 0) ? curDepth : Math.min(depth, curDepth);        
    }
}

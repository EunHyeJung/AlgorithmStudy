/*
* @source https://leetcode.com/problems/same-tree/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.02.02
*/
class Solution {
    private boolean res = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        searchTree(root, targetSum, 0);
        return res;
    }
    
    public void searchTree(TreeNode node, int targetSum, int curSum) {
        if (node == null)
            return;
        if ((node.left == null && node.right == null) && node.val + curSum == targetSum) {
            res = true;
            return;
        }
        searchTree(node.left, targetSum, curSum + node.val);
        searchTree(node.right, targetSum, curSum + node.val);
    }
}

/*
* @source https://leetcode.com/problems/kth-smallest-element-in-a-bst/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.02.03
*/
class Solution {
    private int turn = 0;
    private int res = -1;
    public int kthSmallest(TreeNode root, int k) {
        searchTree(root, k);
        return res;
    }
    
    public void searchTree(TreeNode node, int k) {
        if (node == null || turn > k)
            return;
        searchTree(node.left, k);
        turn += 1;
        if (turn == k) {
            res = node.val;
            return;
        }            
        searchTree(node.right, k);
        
    }
}

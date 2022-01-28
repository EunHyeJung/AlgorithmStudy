/*
* @source https://leetcode.com/problems/binary-tree-inorder-traversal/submissions/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.01.28
*/
class Solution {
    private List<Integer> res;
    public List<Integer> inorderTraversal(TreeNode root) {
        res = new ArrayList<Integer>();
        traverseTree(root);
        return res;
    }
    
    public void traverseTree(TreeNode root) {
        if(root == null) 
            return;
        traverseTree(root.left);
        res.add(root.val);
        traverseTree(root.right);
    }
}

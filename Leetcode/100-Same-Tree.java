/*
* @source https://leetcode.com/problems/same-tree/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.01.29
*/
class Solution {
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null && q != null) return false;
        if (p != null && q == null) return false;
        if (p.val != q.val) return false;
        
        boolean res = isSameTree(p.left, q.left);
        if (!res)   return false;
        return isSameTree(p.right, q.right);
    }
}

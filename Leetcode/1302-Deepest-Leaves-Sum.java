/*
* @source https://leetcode.com/problems/container-with-most-water/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.05.15
*/
class Solution {
    private Map<Integer, Integer> deepthMap;
    private int maxDeepth;
    
    public int deepestLeavesSum(TreeNode root) {
        if (root != null) {
            maxDeepth = 0;
            deepthMap = new HashMap<>();
            exploreTree(root, 0);
        }
        return deepthMap.getOrDefault(maxDeepth, 0);
    }
    
    public void exploreTree(TreeNode node, int depth) {
        if (node.left == null && node.right == null) {
            maxDeepth = Math.max(maxDeepth, depth);
            deepthMap.put(depth, deepthMap.getOrDefault(depth, 0) + node.val);
            return;   
        }
        if (node.left != null) {
            exploreTree(node.left, depth + 1);
        } 
        if (node.right != null) {
            exploreTree(node.right, depth + 1);    
        }
    }
}

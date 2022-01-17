/*
* @source https://leetcode.com/problems/jump-game/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.01.17
*/

class Solution {
    private boolean[] visited;
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 1) return true;
        this.visited = new boolean[n];
        return jump(nums, 0);
    }

    public boolean jump(int[] nums, int curIdx) {
        if (curIdx >= nums.length - 1)  return true;
        int dist = nums[curIdx];
        while(dist > 0) {
            if (dist + curIdx >= nums.length - 1)   
                return true;
            if (!visited[dist + curIdx]) {
                visited[dist + curIdx] = true;
                if (jump(nums, dist + curIdx))
                    return true;
            }
            dist -= 1;
        }
        return false;
    }
}

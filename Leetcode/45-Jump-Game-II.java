/*
* @source https://leetcode.com/problems/jump-game-ii/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.01.18
*/
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        if (nums[0] >= n - 1) return 1;

        int[] visited = new int[n];
        for(int i = nums[0]; i > 0; i--) {
            visited[i] = 1;
        }
        for(int i = 1; i < n; i++) {
            if (i + nums[i] >= n - 1) {
                return visited[i] + 1;
            }
            int next = i + nums[i];
            while(next > 0 && visited[next] == 0) {
                visited[next] = visited[i] + 1;
                next -= 1;
            }
        }

        return visited[n - 1];
    }
}

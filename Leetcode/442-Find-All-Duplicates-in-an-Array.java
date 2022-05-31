/*
* @source https://leetcode.com/problems/find-all-duplicates-in-an-array/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.05.31
*/
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        boolean[] numChk = new boolean[n + 1]; 
        for (int i = 0; i < n; i++) {
            if (numChk[nums[i]]) {
                result.add(nums[i]);
                continue;
            }
            numChk[nums[i]] = true;
        }
        return result;
    }
}

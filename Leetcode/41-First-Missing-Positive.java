/*
* @source https://leetcode.com/problems/first-missing-positive/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.02.07
*/
class Solution {
    public int firstMissingPositive(int[] nums) {

        Map<Integer, Boolean> positiveNumMap = new HashMap<>();
        int minPositiveNum = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                positiveNumMap.put(nums[i], true);
                minPositiveNum = Math.min(minPositiveNum, nums[i]);
            }
        }
        int mapSize = positiveNumMap.keySet().size();
        for(int i = 1; i <= mapSize; i++) {
            if (!positiveNumMap.containsKey(i))
                return i;
        }

        return mapSize + 1;
    }
}

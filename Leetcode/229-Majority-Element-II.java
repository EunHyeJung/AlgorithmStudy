/*
* @source https://leetcode.com/problems/majority-element-ii/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.03.23
*/
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int pivot = n / 3;
        int j = 0, i = 1;
        for (i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                if (i - j > pivot && !res.contains(nums[i - 1])) {
                    res.add(nums[i - 1]);
                }
                j = i;
            }
        }
        if (i != j && i - j > pivot) {
            res.add(nums[j]);
        }
        return res;
    }
}

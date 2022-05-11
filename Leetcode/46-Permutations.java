/*
* @source https://leetcode.com/problems/permutations/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.05.11
*/
class Solution {
    private List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();

        getPermutation(new ArrayList<>(), nums, nums.length);

        return result;
    }

    private void getPermutation(List<Integer> list, int[] nums, int n) {
        if (list.size() == n) {
            result.add(new ArrayList<>(list));

            return;
        }
        for (int i = 0; i < n; i++) {
            if (list.contains(nums[i]))
                continue;
            list.add(nums[i]);
            getPermutation(list, nums, n);
            list.remove(Integer.valueOf(nums[i]));
        }
    }
}

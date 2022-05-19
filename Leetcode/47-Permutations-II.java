/*
* @source https://leetcode.com/problems/permutations-ii/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.05.19
*/
class Solution {
    private List<List<Integer>> result;
    boolean[] chk;
    private Set<String> permSet;

    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        int n = nums.length;
        chk = new boolean[n];
        permSet = new HashSet<>();
        Arrays.sort(nums);
        permutateArray(nums, n, new ArrayList<>());
        return result;
    }

    public void permutateArray(int[] nums, int n, List<Integer> curList) {
        if (curList.size() == n) {
            permSet.add(curList.toString());
            if (permSet.size() != result.size() + 1)
                return;
            result.add(new ArrayList<>(curList));
        }
        for (int i = 0; i < n; i++) {
            if (chk[i])
                continue;
            chk[i] = true;
            curList.add(nums[i]);

            permutateArray(nums, n, curList);

            chk[i] = false;
            curList.remove(curList.size() - 1);
        }
    }
}

class Solution {
    public void moveZeroes(int[] nums) {
		int index = 0, newIndex = 0;
		int n = nums.length;
		for (; index < n; index++) {
			if (nums[index] != 0) {
				nums[newIndex++] = nums[index];
			}
		}
		while (newIndex < n) {
			nums[newIndex++] = 0;
		}
    }
}
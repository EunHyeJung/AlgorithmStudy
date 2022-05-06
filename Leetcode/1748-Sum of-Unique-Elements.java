/*
* @source https://leetcode.com/problems/sum-of-unique-elements/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.05.06
*/
class Solution {
    public int sumOfUnique(int[] nums) {
        int sum = 0;
        int[] arr = new int[101];
        for (int num : nums) {
            if (arr[num] == 0)
                sum += num;
            else if(arr[num] == 1)
                sum -= num;
            arr[num] += 1;
        }
        return sum;
    }
}

/*
* @source https://leetcode.com/problems/remove-duplicates-from-sorted-array/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.12.08
*/
var removeDuplicates = function(nums) {
     let idx = 1, n = nums.length;
     let curNum = nums[0];

     for(let i = 1 ; i< n; i++) {
        if(nums[i] != curNum) {
          nums[idx] = nums[i];
          idx += 1;
          curNum = nums[i];
        }
     }
    return idx;
};

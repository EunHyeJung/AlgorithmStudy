/*
* @source https://leetcode.com/problems/remove-element/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.12.08
*/

var removeElement = function(nums, val) {
 let idx = 0, n = nums.length;
 
 while (idx < n) {
   if (nums[idx] == val) {
     nums.splice(idx, 1);
     idx -= 1;
   }
   idx += 1;
 } 

 return idx;
};

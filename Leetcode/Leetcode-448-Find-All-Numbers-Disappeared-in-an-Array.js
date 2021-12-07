/*
* @source https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.12.07
*/
var findDisappearedNumbers = function(nums) {
    res = [];
    nums.sort((a, b) => { return a - b}); 
    for (let i = 0, n = nums.length; i < n; i++) {
      let diff = 1;
      if (i == 0 && nums[i] > 1) {
        while(diff < nums[0]) {
          res.push(diff);
          diff += 1;
        }
      } else if (i == n-1 && nums[n-1] != n) {
        diff = n - nums[n-1];
        while(diff > 0) {
          res.push(nums[n-1] + diff);
          diff -= 1;
        }
      } else {
        diff = nums[i + 1] - nums[i];
        if (diff > 1) {
          while(diff > 1) {
            res.push(nums[i] + (diff -1));
            diff -= 1;
          }
        }
      }
    }
  
    return res.sort();
};

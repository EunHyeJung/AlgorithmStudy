/*
* @source https://leetcode.com/problems/rotate-array/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.12.16
*/
var rotate = function(nums, k) {
    let n = nums.length;
    k = k > n ? k % n : k;
    let cursor = n - k, i = 0;
    let tmp = nums.slice(cursor, n);

    while (i < cursor) {
      nums[n- 1- i] = nums[cursor - 1 - i];
      i += 1;
    }
    tmp.forEach((num, i) => {
      nums[i] = tmp[i];
    });

};

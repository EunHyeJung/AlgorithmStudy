/*
* @source https://leetcode.com/problems/duplicate-zeros/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.12.06
*/
var duplicateZeros = function(arr) {
      for (let i = 0, n = arr.length; i < n; ) {
       if (arr[i] == 0 && i < n - 1) {
         let j = n - 1;
         while (j > i + 1) {
           arr[j] = arr[j-1];
           j -= 1;
         }
         arr[i + 1] = 0;
         i += 2;
       } else {
         i += 1;
       }

     }
};

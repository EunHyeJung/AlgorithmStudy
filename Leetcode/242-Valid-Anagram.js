/*
* @source https://leetcode.com/problems/valid-anagram/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.01.02
*/
var isAnagram = function(s, t) {
    if (s.length != t.length) return false;
    sMap = {};

    for (let i = 0, n = s.length; i < n; i++) {
      let ch = s.charAt(i);
      sMap[ch] = sMap[ch] ? sMap[ch] + 1 : 1;
    }

    for (let i = 0, n = t.length; i < n; i++) {
      let ch = t.charAt(i);
      if (!sMap[ch] || sMap[ch] == 0) 
        return false;
      sMap[ch] -= 1;
    }


    return true;
};

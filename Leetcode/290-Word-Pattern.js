/*
* @source https://leetcode.com/problems/word-pattern/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.12.28
*/
var wordPattern = function(pattern, s) {
    let sArr = s.split(" ")
    let patternMap = new Map();
    let strMap = new Map();
    let chArr = Array.from(pattern), n = chArr.length;

    if (n != sArr.length)
        return false;
    
    for(let i = 0; i < n ; i++) {
      if (chArr[i] in patternMap && patternMap[chArr[i]] != sArr[i]) 
        return false;
      if (sArr[i] in strMap && strMap[sArr[i]] != chArr[i])
          return false;
      strMap[sArr[i]] = chArr[i];
      patternMap[chArr[i]] = sArr[i];
    }
    return true;
};

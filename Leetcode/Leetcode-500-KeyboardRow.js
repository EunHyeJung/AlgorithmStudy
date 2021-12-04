
/**
 * Leetcode. 500. Keyboard Row
 * 
 * @author EunHyeJung
 * @email ehye826@gmail.com
 * @date 2021.12.04
 * @link https://leetcode.com/problems/keyboard-row/
 */

var findWords = function(words) {
    let keywords = ['qwertyuiop', 'asdfghjkl', 'zxcvbnm'];
    let keywordMap = {};
    keywords.forEach(function(keyword, idx) {
        keyword.split('').forEach(function(ch) {
           keywordMap[ch] = idx; 
        });
    });
    let res = [];
    words.forEach(function(word) {
       let mapIdx = -1, chk = false;
       word.toLowerCase().split('').forEach(function(ch) {
          if (mapIdx >= 0 && mapIdx != keywordMap[ch]) {
            chk = true;
            return; 
          }
          if (chk)
            return;
          mapIdx = keywordMap[ch];
       });
       if (!chk)
        res.push(word);
    });
    return res;
};

/*
* @source https://leetcode.com/problems/merge-intervals/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.12.30
*/
var merge = function(intervals) {
    intervals.sort((a, b) => {
      if (a[0] == b[0]) return [0];
      return a[0] - b[0];
    })


    var res = new Array();
    intervals.forEach((interval) => {
      if (res.length == 0) {
        res.push(interval);
      } else {
        let comp = res.pop();
        if (interval[0] >= comp[0] && interval[0] <= comp[1]) {
          res.push([comp[0], Math.max(interval[1], comp[1])]);
        } else {
          res.push(comp);
          res.push(interval);
        }
      }
    });
    return res;
};

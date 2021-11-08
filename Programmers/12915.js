/*
    @date: 2021/11/08
    @source: https://programmers.co.kr/learn/courses/30/lessons/12915
    @email: ehye826@gmail.com
*/
function solution(strings, n) {
    let strMap = {};
    let answer = [];
    strings.forEach((str) => {
    	let ch = str.charAt(n);
    	if (strMap[ch]) {
      	strMap[ch].push(str);
      } else {
      	strMap[ch] = [str];
      }
    });
    var sortedCh = Object.keys(strMap).sort();
  	sortedCh.forEach((ch) => {
    	if (strMap[ch]) {
               strMap[ch].sort().forEach((str) => {
              answer.push(str);
          }); 
      }
    });
    return answer;    
}

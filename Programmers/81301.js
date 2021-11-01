/*
    @date: 2021/11/01
    @source: https://programmers.co.kr/learn/courses/30/lessons/81301
*/
function solution(s) {
    var answer = '';
    var tmp = [];
    for (let i = 0, n = s.length; i < n; i++) {
        let ch = s.charAt(i);
        if (ch >= '0' && ch <= '9') {
        	if (tmp.length > 0) {
          	answer += strToNum(tmp.join(''));
            tmp = [];
          }
        	answer += ch;
        } else {      	
        	tmp.push(ch);
          if (tmp.length >= 3) {
          	let num = strToNum(tmp.join(''));
            if (num >= 0) {
            	answer += num + '';
            	tmp = [];
            }
          }
        }
    }
    return parseInt(answer);
}

function strToNum(str) {
    var arr = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"];
    for (let i = 0; i < arr.length; i ++) {
        if (arr[i] == str)
            return i;
    }
    return -1;
}

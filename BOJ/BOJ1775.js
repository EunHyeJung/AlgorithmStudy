/*
* @source https://www.acmicpc.net/problem/1755
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.11.24
*/

let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split(" ");

const dataSet = {
    0: 'zero',
    1: 'one',
    2: 'two',
    3: 'three',
    4: 'four',
    5: 'five',
    6: 'six',
    7: 'seven',
    8: 'eight',
    9: 'nine'
}

let st = parseInt(input[0]), end = parseInt(input[1]);
let numStrArr = [], numStrMap = {};
for(let i = st; i <= end; i++) {
    let numStr = i / 10 < 1 ? dataSet[i] : (dataSet[parseInt(i/10)] + ' ' + dataSet[i%10]);
    numStrArr.push(numStr);
    numStrMap[numStr] = i;
}
numStrArr.sort();
let res = [];
numStrArr.forEach((numStr, idx) => {
    if (idx > 0 && idx % 10 == 0) res.push("\n");
    res.push(numStrMap[numStr]+ " ");
});
console.log(res.join(""))

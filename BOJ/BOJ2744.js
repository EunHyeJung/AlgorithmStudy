/*
* @source https://www.acmicpc.net/problem/2744
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.12.03
*/

let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString();

let res = [];
for(let i = 0; i < input.length; i++) {
    res.push(input[i].toUpperCase() == input[i] ? input[i].toLowerCase() : input[i].toUpperCase());
}
console.log(res.join(''))

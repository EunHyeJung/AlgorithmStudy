/*
* @source https://www.acmicpc.net/problem/2935
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.11.29
*/
let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split("\n");

let op = input[1];
let num1 = input[0].length > input[2].length ? input[2] : input[0];
let num2 = input[0].length > input[2].length ? input[0] : input[2];

if (op == '*') {
    console.log("1" + "0".repeat(num1.length + num2.length - 2))
} else {
    if (num1.length == num2.length) {
        console.log("2" + "0".repeat(num1.length - 1))    
    } else {
        console.log(num2.slice(0, num2.length - num1.length) + num1)
    }
    
}

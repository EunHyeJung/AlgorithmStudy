/*
* @source https://www.acmicpc.net/problem/3059
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.12.02
*/
const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});
const input = [];
rl.on("line", function(line) {
   input.push(line);
}).on("close", function() {
    const sum = 2015;
    let getAsciiSum = function(str) {
        let asciiSum = 0;
        for(let i = 0 ; i < str.length; i++) {
            asciiSum += str.charAt(i).charCodeAt(0);
        }
        return asciiSum;
    }
    let n = parseInt(input[0]);
    for (let i = 0; i <n; i++) {
        let str = input[i + 1];
        str = Array.from(new Set(str)).join('');
        console.log(sum - getAsciiSum(str));
    }
});


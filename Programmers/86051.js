/*
    @date: 2021/11/03
    @source: https://programmers.co.kr/learn/courses/30/lessons/86051
    @email: ehye826@gmail.com
*/
function solution(numbers) {
    return 45 - numbers.reduce((acc, cur) => { return acc + cur});
}

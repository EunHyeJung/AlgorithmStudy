/*
    @date: 2021/11/09
    @source: https://programmers.co.kr/learn/courses/30/lessons/68644
    @email: ehye826@gmail.com
*/
function solution(numbers) {
    var answer = [];
    var set = new Set();
    numbers.forEach((number1, idx1) => {
        numbers.forEach((number2, idx2) => {
            if (idx1 != idx2)
                set.add(number1 + number2);
        });
    });
    return [...set].sort((a, b) => { return a -b });
}

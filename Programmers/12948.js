/*
    @date: 2021/11/09
    @source: https://programmers.co.kr/learn/courses/30/lessons/12948
    @email: ehye826@gmail.com
*/
function solution(phone_number) {
    return "*".repeat(phone_number.length - 4) + phone_number.substr(phone_number.length - 4, phone_number.length);
}

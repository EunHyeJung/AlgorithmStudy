/*
    @date: 2021/11/03
    @source: https://programmers.co.kr/learn/courses/30/lessons/77484
    @email: ehye826@gmail.com
*/
function solution(lottos, win_nums) {
    let equalCnt = 0, candidateCnt = 0;
    lottos.forEach((num) =>{
        if (win_nums.indexOf(num) >= 0)
            equalCnt += 1;
        else if (num == 0)
            candidateCnt += 1;
            
    })
    
    return [equalCnt == 0 && candidateCnt == 0 ? 6 :7 - (equalCnt + candidateCnt), equalCnt < 2 ? 6 : 7-equalCnt];
}

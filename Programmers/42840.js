function solution(answers) {
    let a = [1, 2, 3, 4, 5];
    let b = [2, 1, 2, 3, 2, 4, 2, 5];
    let c = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];

    let correctCnt = [0, 0, 0];
    let maxCnt = 0;
    answers.forEach((answer, idx) => {
        let qIdx = a.length > idx ? idx : idx % a.length;
      if (a[qIdx] == answer) correctCnt[0] += 1;
       qIdx = b.length > idx ? idx : idx % b.length;
      if (b[qIdx] == answer) correctCnt[1] += 1;
      qIdx = c.length > idx ? idx : idx % c.length;
      if (c[qIdx] == answer) correctCnt[2] += 1;
    });
    maxCnt = Math.max(...correctCnt);

    let res = []
    correctCnt.forEach((cnt, idx) => {
      if(cnt == maxCnt)
        res.push(idx + 1);
    });
    return res;
}

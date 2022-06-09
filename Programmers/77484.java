/*
    @date: 2022.06.09
    @source: https://programmers.co.kr/learn/courses/30/lessons/77484
    @email: ehye826@gmail.com
*/
class Solution {
    private static final int[] score = {6, 6, 5, 4, 3, 2, 1};
    public int[] solution(int[] lottos, int[] win_nums) {
        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        int maxCnt = 0, minCnt = 0;
        for (int i = 0, j = 0, n = lottos.length ; i < n; i++) {
            if (lottos[i] == 0) {
                maxCnt += 1;
                continue;
            }
            while (j < n && win_nums[j] <= lottos[i] && lottos[i] != win_nums[j]) {
                j += 1;
            }
            if (j < n && lottos[i] == win_nums[j]) {
                minCnt += 1;
                maxCnt += 1;
            }
        }

        int[] answer = { score[maxCnt], score[minCnt] };

        return answer;
    }
}

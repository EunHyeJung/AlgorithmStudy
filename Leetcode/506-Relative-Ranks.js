/*
* @source https://leetcode.com/problems/relative-ranks/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.12.09
*/
var findRelativeRanks = function(score) {
    let sorctedScore =  score.slice();
    sorctedScore.sort((a, b) => b - a);

    let result = [], medal = ['Gold Medal', 'Silver Medal', 'Bronze Medal'];
    for(let i = 0, n = score.length; i < n; i++) {
        let ranking = sorctedScore.indexOf(score[i]);
        if (ranking == 0 || ranking == 1 || ranking == 2) {
            result.push(medal[ranking]);
        } else {
            result.push((ranking + 1).toString());
        }
    }    
    return result;
};

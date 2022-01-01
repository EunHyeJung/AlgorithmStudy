/*
* @source https://leetcode.com/problems/add-strings/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.01.01
*/
var addStrings = function(num1, num2) {
    let pointer1 = num1.length - 1, pointer2 = num2.length - 1;
    let res = new Array();
    let flag = 0, sum = 0;

    while(pointer1 >= 0 || pointer2 >= 0) {
        sum = 0; 
        if (flag > 0) {
            sum += flag;
            flag = 0;
        }
        if (pointer1 >= 0) {
            sum += parseInt(num1.charAt(pointer1));
            pointer1 -= 1;    
        }
        if (pointer2 >= 0) {
            sum += parseInt(num2.charAt(pointer2));
            pointer2 -= 1;            
        }
        if (sum >= 10) {
            flag = parseInt(sum / 10);
            res.push(sum % 10);
        } else 
            res.push(sum);
    }
    if (flag > 0) 
        res.push(flag);
    return res.reverse().join('');    
}

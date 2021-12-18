/*
* @source https://leetcode.com/problems/middle-of-the-linked-list/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.12.18
*/
var middleNode = function(head) {
    let curNode = head;
    let cnt = 0;
    while(curNode != null) {
        curNode = curNode.next;
        cnt += 1;
    }
    let i = 0, n = parseInt(cnt / 2);
    curNode = head;
    while (i < n) {
        curNode = curNode.next;
        i += 1;
    }
    return curNode;
};

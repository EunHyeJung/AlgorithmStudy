/*
* @source https://leetcode.com/problems/delete-node-in-a-linked-list/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.12.19
*/
var deleteNode = function(node) {
    node.val = node.next.val;
    node.next = node.next.next;
};

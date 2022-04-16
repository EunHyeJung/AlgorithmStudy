/*
* @source https://leetcode.com/problems/linked-list-cycle/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.04.16
*/
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode cursor = head;
        ListNode fastCursor = head.next;
        while (cursor != null && fastCursor != null) {
            if (cursor == fastCursor)
                return true;
            cursor = cursor.next;
            if (fastCursor.next == null)
                return false;
             fastCursor = fastCursor.next.next;
        }
        return false;   
    }
}


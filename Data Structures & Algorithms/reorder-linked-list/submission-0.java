/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if(head.next == null) {
            return;
        }

        ListNode fast = head, slow = head, prev = null;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secList = slow;
        prev.next = null;

        secList = reverseList(secList);
        ListNode dummyHead = new ListNode(-100), curr = dummyHead;

        while(head != null || secList != null) {
            if(head != null) {
                curr.next = head;
                curr = curr.next;
                head = head.next;
            }
            
            if(secList != null) {
                curr.next = secList;
                curr = curr.next;
                secList = secList.next;
            }
        }
    }

    private ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        ListNode newHead = reverseList(next);
        next.next = head;
        head.next = null;

        return newHead;
    }
}

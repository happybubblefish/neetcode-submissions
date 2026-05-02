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

        ListNode sl = slow;
        prev.next = null;

        sl = reverseList(sl);

        ListNode dummyHead = new ListNode(-100), curr = dummyHead;

        while(head != null || sl != null) {
            if(head != null) {
                curr.next = head;
                curr = curr.next;
                head = head.next;
            }

            if(sl != null) {
                curr.next = sl;
                curr = curr.next;
                sl = sl.next;
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

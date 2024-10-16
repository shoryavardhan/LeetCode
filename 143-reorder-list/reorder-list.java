/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        // Find middle of list using a slow and fast pointer approach
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the list using a tmp variable
        var second = slow.next;
        slow.next = null; // split the lists into 2 parts
        ListNode prev = null;
        while (second != null) {
            var temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        var first = head;
        second = prev;
        while (second != null) {
            var temp1 = first.next;
            first.next = second;
            var temp2 = second.next;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }

    }
}
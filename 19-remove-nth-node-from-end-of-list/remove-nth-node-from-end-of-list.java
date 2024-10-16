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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return solution2(head, n);

    }

    public ListNode solution2(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        // if head is to be deleted;
        if (fast == null) {
            return head.next;
        }

        // if head is not be deleted traverse to node before the node that needs to be
        // deleted
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // store the next node (this will be deleted)
        var temp = slow.next;

        // if its not the last node assign the pointer of node after that
        if (slow.next != null) {
            slow.next = slow.next.next;
        }
        // if its the last node thats being deleted just assign null
        else {
            slow.next = null;
        }
        return head;
    }

    public ListNode solution1(ListNode head, int n) {
        // calculate length
        ListNode itr = head;
        int length = 0;
        while (itr != null) {
            length++;
            itr = itr.next;
        }

        // if head is to be deleted;
        if (length == n) {
            return head.next;
        }

        // if head is not be deleted traverse to node before the node that needs to be
        // deleted
        int res = length - n;
        itr = head;
        while (itr != null) {
            res--;
            if (res == 0)
                break;
            itr = itr.next;
        }
        // store the next node (this will be deleted)
        var temp = itr.next;

        // if its not the last node assign the pointer of node after that
        if (itr.next != null) {
            itr.next = itr.next.next;
        }
        // if its the last node thats being deleted just assign null
        else {
            itr.next = null;
        }
        return head;

    }
}
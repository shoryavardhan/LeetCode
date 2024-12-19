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
    public ListNode reverseList(ListNode head) {
        return reverse(null, head);
    }
    public ListNode reverse(ListNode prev, ListNode node){
        if(node == null){
            return prev;
        }
        var temp = node.next;
         node.next = prev;
        return reverse(node, temp);
    }
}
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==1){
            return lists[0];
        }
        if(lists.length==0){
            return null;
        }
        var q = new PriorityQueue<Integer>();
        for(var list : lists){
            while(list!=null){
                q.offer(list.val);
                list=list.next;
            }
        }
        var x = new ListNode();
        var y =x;
        while(!q.isEmpty()){
                x.next = (new ListNode(q.poll()));
                x=x.next;
             }
        return y.next;
    }
}
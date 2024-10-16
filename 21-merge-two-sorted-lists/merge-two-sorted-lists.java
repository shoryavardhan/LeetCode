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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return recursiveSolution(list1, list2);
    }

    private ListNode recursiveSolution(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }
         if(list2==null){
            return list1;
        }
        if(list1.val<=list2.val){
            list1.next= recursiveSolution(list1.next,list2);
            return list1;
        }
        else{
            list2.next=recursiveSolution(list1,list2.next);
            return list2;
        }
    }

    private ListNode iterativeSolution(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode();
        ListNode res = ans;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                res.next = list1;
                list1 = list1.next;
            } else {
                res.next = list2;
                list2 = list2.next;
            }
            res = res.next;
        }
        if (list1 != null) {
            res.next = list1;
        } else {
            res.next = list2;
        }
        return ans.next;
    }
}
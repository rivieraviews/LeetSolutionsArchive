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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode pt1 = head;
        ListNode pt2 = head;
        
        for (int i = 1; i<=n; i++)
        {
            pt2 = pt2.next;
        }

        if (pt2 == null)
            return head.next;
        
        while (pt2.next != null)
        {
            pt1 = pt1.next;
            pt2 = pt2.next;
        }

        pt1.next = pt1.next.next;
        return head;
    }
}
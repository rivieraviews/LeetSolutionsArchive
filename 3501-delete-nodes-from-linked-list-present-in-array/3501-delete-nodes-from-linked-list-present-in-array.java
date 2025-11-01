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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> hash = new HashSet<>();

        for (int x : nums)
        {
            hash.add(x);
        }

        while (head != null && hash.contains(head.val))
        {
            head = head.next;
        }

        ListNode current = head;

        while (current != null && current.next != null)
        {
            while (current.next != null && hash.contains(current.next.val))
            {
                current.next = current.next.next;
            }

            current = current.next;
        }

        return head;
    }
}
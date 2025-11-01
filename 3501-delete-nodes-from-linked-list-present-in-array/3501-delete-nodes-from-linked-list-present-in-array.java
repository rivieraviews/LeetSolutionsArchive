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
        int maxim = -1;

        for (int n : nums)
        {
            maxim = Math.max(maxim, n);
        }

        boolean[] freq = new boolean[maxim + 1];

        for (int n : nums)
        {
            freq[n] = true;
        }

        ListNode temp = new ListNode();
        ListNode current = temp;

        while (head != null)
        {
            if (head.val >= freq.length || freq[head.val] == false)
            {
                current.next = head;
                current = current.next;
            }

            head = head.next;
        }

        current.next = null;
        return temp.next;
    }
}
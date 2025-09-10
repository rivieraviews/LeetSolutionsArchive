/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val; // data goes here
 *     ListNode next; // reference to next node in the list. this is a reference to a listnode object. and this is how nodes link. it will be null if there is no next node.
 *     
 *     //beginning of constructor overloading.
 *
 *     ListNode() {} //creating an empty linkedlist node with default values. default for int is 0, default for pointer is null.
 *     ListNode(int val) { this.val = val; } //passing a value that will be the payload for the created node
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; } //passing a value (new payload) and a pointer to the next node.
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        //start
        //iterative solution

        if (head == null || head.next == null) //if empty list, or if list just has one node
        {
            return head;
        }

        //iteratively, we have 3-pointer approach.
        //start, current, next

        /*
            a b c d
            reversed - d c b a
        */

        ListNode prevNode = null;
        ListNode currentNode = head;
        ListNode nextNode = null;

        while (currentNode != null)
        {
            //what do i need to NOT LOSE?
            nextNode = currentNode.next;

            //what do i need to DO? -> REVERSE!
            currentNode.next = prevNode;

            //how do we move forward? 
            prevNode = currentNode;
            currentNode = nextNode;
        }

        return prevNode; //since prev is now pointing to new head (old tail)
    }
}
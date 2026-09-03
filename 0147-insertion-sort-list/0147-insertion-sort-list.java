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
    public ListNode insertionSortList(ListNode head) {

        // Dummy node helps when inserting at the beginning
        ListNode dummy = new ListNode(0);

        ListNode current = head;

        while (current != null) {

            // Save the next node before changing pointers
            ListNode nextNode = current.next;

            // Start searching from the beginning of sorted list
            ListNode prev = dummy;

            // Find the correct position
            while (prev.next != null && prev.next.val < current.val) {
                prev = prev.next;
            }

            // Insert current node
            current.next = prev.next;
            prev.next = current;

            // Move to next node from original list
            current = nextNode;
        }

        return dummy.next;
    }
}
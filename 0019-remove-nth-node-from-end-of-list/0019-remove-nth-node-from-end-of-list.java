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
        // take two pointer at a distance of n  and when the second one becomes null remove the first pointer node
        int count = 0;
        ListNode pointerOne = head;
        ListNode pointerTwo = head;
        while (pointerTwo.next != null) {
            if (count >= n) pointerOne = pointerOne.next;
            pointerTwo = pointerTwo.next;
            count++;
        }
        if (count < n) return head.next;
        ListNode removePointer = pointerOne.next;
        pointerOne.next = removePointer.next;
        return head;
    }
}
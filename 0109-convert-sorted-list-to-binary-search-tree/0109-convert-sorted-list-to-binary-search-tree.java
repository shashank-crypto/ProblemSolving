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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public TreeNode createTree (ListNode start, ListNode end) {
        if (start == end) return null;
        ListNode middle = start;
        ListNode dummy = start;
        while (dummy != end && dummy.next != end) {
            dummy = dummy.next.next;
            middle = middle.next;
        }
        TreeNode node = new TreeNode(middle.val);
        node.left = createTree(start, middle);
        node.right = createTree(middle.next, end);
        return node;
    }

    public TreeNode sortedListToBST(ListNode head) {
        return createTree(head, null);
    }
}
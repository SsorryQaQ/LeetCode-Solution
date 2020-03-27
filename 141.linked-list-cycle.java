/*
 * @lc app=leetcode id=141 lang=java
 *
 * [141] Linked List Cycle
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) { return false; }
        ListNode slow = head;
        ListNode fast = slow.next;
        while (slow != fast) {
            if (slow.next == null) { break; }
            if (fast.next == null || fast.next.next == null) { break; }
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow != null && fast != null && slow == fast;
    }
}
// @lc code=end


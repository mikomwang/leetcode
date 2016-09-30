/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddStart = head;
        ListNode odd = head;
        if (odd == null) {
            return null;
        }
        ListNode evenStart = head.next;
        ListNode even = head.next;
        if (even == null) {
            return odd;
        }
        
        while (odd != null && even != null) {
            odd.next = even.next;
            odd = even.next;
            if (odd == null) {
                break;
            }
            even.next = odd.next;
            even = odd.next;
        }
        ListNode traveler = oddStart;
        while (traveler.next != null) {
            traveler = traveler.next;
        }
        traveler.next = evenStart;
        
        return oddStart;
        
    }
}
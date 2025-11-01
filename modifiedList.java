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
      HashSet <Integer> mpp = new HashSet<>();
      for(int i : nums) mpp.add(i);
      while(head != null && mpp.contains(head.val)) head = head.next;
      ListNode curr = head;
      while(curr != null && curr.next != null){
        while(curr.next != null && mpp.contains(curr.next.val)){
            curr.next = curr.next.next;
        }
        curr = curr.next;
      }
      return head;
    }
}

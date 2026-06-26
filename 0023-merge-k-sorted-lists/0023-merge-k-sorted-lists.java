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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        return mergeListsHelper(lists, 0, lists.length-1);

    }
    private ListNode mergeListsHelper(ListNode[] lists, int start, int end){
        if(start == end) return lists[start];
        
        if(start+1 == end){
            return merge2Lists(lists[start], lists[end]);
        }
        int mid = start + (end - start)/2;
        ListNode left = mergeListsHelper(lists, start, mid);
        ListNode right = mergeListsHelper(lists, mid+1, end);
        return merge2Lists(left, right);
    }
    private ListNode merge2Lists(ListNode left, ListNode right){
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode currNode = dummy;
        ListNode ptr1 = left;
        ListNode ptr2 = right;

        while(ptr1 != null && ptr2 != null){
            if(ptr1.val <= ptr2.val){
                currNode.next = ptr1;
                ptr1 = ptr1.next;
            }else{
                currNode.next = ptr2;
                ptr2 = ptr2.next;
            }
            currNode = currNode.next;
        }
        if(ptr1 != null){
            currNode.next = ptr1;
        }else{
            currNode.next = ptr2;
        }
        return dummy.next;
    }
}
package LeetCode.RemoveDuplicatesFromSortedList;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        int value;
        while (temp != null) {
            value = temp.val;
            ListNode iter = temp.next;
            while (iter!=null && iter.val == value) {
                iter = iter.next;
            }
            temp.next = iter;
            temp = iter;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        ListNode result = sol.deleteDuplicates(head);
    }
}
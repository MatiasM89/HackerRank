package LeetCode.ZeroSumLinkedList;

import java.util.HashMap;
import java.util.LinkedList;

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
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode temp = dummy;
        int prefixSum = 0;
        while (temp != null) {
            prefixSum += temp.val;
            map.put(prefixSum, temp);
            temp = temp.next;

        }
        prefixSum = 0;
        temp = dummy;
        while (temp != null) {
            prefixSum += temp.val;
            temp.next = map.get(prefixSum).next;
            temp = temp.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(-3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(1);
        ListNode result = solution.removeZeroSumSublists(head);
    }
}

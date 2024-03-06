package LeetCode.LinkedListCycle2;

import java.util.HashSet;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution{
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();
        while (head != null) {
            if (hashSet.contains(head))
                return head;
            hashSet.add(head);
            head = head.next;
        }
        return null;
    }
}

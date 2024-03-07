package LeetCode.MiddleOfLinkedList;

import java.util.HashSet;
import java.util.LinkedList;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode middleNode(ListNode head) {
        LinkedList<ListNode> list = new LinkedList<>();
        int counter = 0;
        while (head != null) {
            counter++;
            list.add(head);
            head = head.next;
        }

        return list.get(counter / 2);
    }

}

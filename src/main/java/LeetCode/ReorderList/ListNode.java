package LeetCode.ReorderList;

import java.util.LinkedList;
import java.util.List;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public void reorderList(ListNode head) {
        LinkedList<ListNode> list = new LinkedList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.get(list.size() / 2).next = null;
        int end = list.size() - 1;
        for (int i = 0; i < list.size() / 2; i++) {

            ListNode current = list.get(i);
            current.next = list.get(end);
            end--;
        }
        int start = 1;
        for (int i = list.size() - 1; i > list.size() / 2; i--) {
            ListNode current = list.get(i);
            current.next = list.get(start);
            start++;
        }
        head = list.get(0);
    }

}

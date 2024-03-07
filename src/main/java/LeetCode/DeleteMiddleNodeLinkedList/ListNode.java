package LeetCode.DeleteMiddleNodeLinkedList;

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
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }
        LinkedList<ListNode> list = new LinkedList<>();
        int counter = 0;
        while (head != null) {
            counter++;
            list.add(head);
            head = head.next;
        }
        if (counter == 2) {
            list.get(0).next = null;
            return list.get(0);
        }
        ListNode before = list.get((counter / 2) - 1);
        ListNode after = list.get((counter / 2) + 1);
        before.next = after;
        return list.get(0);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        System.out.println(sol.deleteMiddle(head).val);

    }

}

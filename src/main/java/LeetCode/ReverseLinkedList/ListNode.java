package LeetCode.ReverseLinkedList;

import java.util.ArrayList;
import java.util.Collections;

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
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ArrayList<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        ListNode temp = null;
        Collections.reverse(list);
        for (int i = 0; i < list.size() - 1; i++) {
            temp = list.get(i);
            temp.next = list.get(i + 1);
        }
        temp.next.next = null;
        return list.get(0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode result = solution.reverseList(head);
    }
}

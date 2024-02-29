package LeetCode.RemoveNodeFromList;

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }

        ListNode moving = head;
        int size = 1;
        while (moving.next != null) {
            size++;
            moving = moving.next;
        }
        if (n == size) {
            return head.next;
        }
        moving = head;

        int i = 1;
        while (i < size - n) {
            moving = moving.next;
            i++;
        }

        moving.next = moving.next.next;


        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        Solution sol = new Solution();
        sol.removeNthFromEnd(head, 2);
    }
}

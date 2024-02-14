package LeetCode.AddTwoNumbers;

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        while (l1 != null) {
            builder1.append(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            builder2.append(l2.val);
            l2 = l2.next;
        }
        long value = Long.valueOf(builder1.reverse().toString()) + Long.valueOf(builder2.reverse().toString());
        String resultString = String.valueOf(value);
        ListNode result = new ListNode(resultString.charAt(0)-48);
        for (int i = 1; i < resultString.length(); i++) {
            ListNode temp = new ListNode(resultString.charAt(i)-48);
            temp.next = result;
            result = temp;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        Solution solution = new Solution();
        ListNode number = solution.addTwoNumbers(l1, l2);
    }
}

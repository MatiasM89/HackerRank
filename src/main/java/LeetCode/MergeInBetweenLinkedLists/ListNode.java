package LeetCode.MergeInBetweenLinkedLists;

import java.util.List;

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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode end2 = list2;
        while (end2.next != null) {
            end2 = end2.next;
        }
        ListNode dummy = new ListNode();
        dummy.next = list1;
        ListNode aNode = null;
        ListNode bNode = null;
        ListNode temp = dummy;
        int counter = 0;

        while (temp != null) {
            if (counter == a) {
                aNode = temp;
            }
            if (counter == b + 2) {
                bNode = temp;
                break;
            }
            temp = temp.next;
            counter++;
        }
        aNode.next = list2;
        end2.next = bNode;


        return dummy.next;
    }

}

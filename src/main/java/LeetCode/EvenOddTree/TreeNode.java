package LeetCode.EvenOddTree;

import java.util.LinkedList;
import java.util.stream.IntStream;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        int level = 0;
        queue.add(root);

        while (!queue.isEmpty()) {
            LinkedList<TreeNode> currentQueue = new LinkedList<>(queue);
            if (level % 2 == 0) {
                boolean allOdd = currentQueue.stream().allMatch(node -> node.val % 2 != 0);
                boolean isIncreasing = IntStream.range(0, queue.size() - 1).allMatch(index -> currentQueue.get(index).val < currentQueue.get(index + 1).val);
                if (!allOdd || !isIncreasing)
                    return false;
            } else {
                boolean allEven = currentQueue.stream().allMatch(node -> node.val % 2 == 0);
                boolean isDecreasing = IntStream.range(0, queue.size() - 1).allMatch(index -> currentQueue.get(index).val > currentQueue.get(index + 1).val);
                if (!allEven || !isDecreasing)
                    return false;
            }
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode current = queue.removeFirst();
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            level++;
        }
        return true;
    }
}

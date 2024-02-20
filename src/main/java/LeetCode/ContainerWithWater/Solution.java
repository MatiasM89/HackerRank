package LeetCode.ContainerWithWater;

public class Solution {

    public int maxArea(int[] height) {
        int i = 0;
        int k = height.length-1;
        int maxArea = 0;
        while (k!=i) {
            int temp = Math.min(height[i], height[k]) * Math.abs(k-i);
            if (temp > maxArea) {
                maxArea = temp;
            }
            if (height[i] < height[k]) {
                i++;
            } else {
                k--;
            }
        }
        return maxArea;
    }
//    should work but inefficent O(n^2)

//    public int maxArea(int[] height) {
//        int maxArea = 0;
//        for (int i = 0; i < height.length; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                int temp = Math.min(height[i], height[j]) * (j - i);
//                if (temp > maxArea) {
//                    maxArea = temp;
//                }
//            }
//        }
//        return maxArea;
//    }
}

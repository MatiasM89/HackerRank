package LeetCode.InsertInterval;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        while (i < intervals.length) {
            if(intervals[i][0] > newInterval[1]){
                break;
            }
            if (intervals[i][1] < newInterval[0]) {
                result.add(intervals[i]);
            } else {
                if(intervals[i][0] < newInterval[0]){
                    newInterval[0] = intervals[i][0];
                }
                if(intervals[i][1] > newInterval[1]){
                    newInterval[1] = intervals[i][1];
                }
            }
            i++;
        }
        result.add(newInterval);
        for(; i < intervals.length;i++){
            result.add(intervals[i]);
        }
        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int[][] result = solution.insert(intervals, newInterval);
    }
}

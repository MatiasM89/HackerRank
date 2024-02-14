package LeetCode.MajorityElement169;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        int maxValue = map.get(nums[0]);
        int maxKey = nums[0];
        for (Map.Entry<Integer, Integer> iterableMap : map.entrySet()) {
            if(iterableMap.getValue()>maxValue){
                maxValue = iterableMap.getValue();
                maxKey = iterableMap.getKey();
            }
        }

        return maxKey;
    }
}

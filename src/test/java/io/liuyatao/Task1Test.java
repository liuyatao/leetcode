package io.liuyatao;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * 两数之和 https://leetcode-cn.com/problems/two-sum/
 */
public class Task1Test {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            int[] result = new int[2];

            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    result[0] = map.get(nums[i]);
                    result[1] = i;
                    break;
                } else {
                    map.put(target - nums[i], i);
                }
            }
            return result;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        for (int i : result) {
            System.out.println(i);
        }
    }
}

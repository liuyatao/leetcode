package io.liuyatao.binarySearch;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 287. 寻找重复数 https://leetcode-cn.com/problems/find-the-duplicate-number/
 */
public class Task1 {

    class Solution {
        /**
         * 获取中位数，然后统计大于中位数的个数（说明中位数到最大值没有重复的）
         * 
         * @param nums
         * @return
         */
        public int findDuplicate(int[] nums) {
            int left = 1;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2; // 中位数
                int count = 0;
                for (int num : nums) {
                    if (num <= mid) {
                        count++;
                    }
                }
                if (count < mid) { // 不满足条件的
                    right = mid;
                } else { // 满足条件的
                    left = mid + 1;
                }
            }
            return left;
        }
    }

    @Test
    public void name() {
        Solution solution = new Solution();
        int[] nums = { 1, 2, 3, 4, 5, 4 };
        int result = solution.findDuplicate(nums);
        assertEquals(4, result);
    }

}

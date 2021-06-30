package io.liuyatao.twoPoints;

import org.junit.jupiter.api.Test;

/**
 * 反转字符串 https://leetcode-cn.com/problems/reverse-string/description/
 */
public class Task1 {
    class Solution {
        public void reverseString(char[] s) {
            int left = 0;
            int right = s.length - 1;
            while (left < right) {
                char temp = s[right];
                s[right] = s[left];
                s[left] = temp;
                left++;
                right--;
            }
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println("---s1");
        char[] s = { 'h', 'e', 'l', 'l', 'o' };
        solution.reverseString(s);
        for (char c : s) {
            System.out.println(c);
        }
        System.out.println("---s2");
        char[] s1 = { 'H', 'a', 'n', 'n', 'a', 'h' };
        solution.reverseString(s1);
        for (char c : s1) {
            System.out.println(c);
        }
    }
}

package io.liuyatao.twoPoints;

import org.junit.jupiter.api.Test;

/**
 * 反转字符串中的元音字母
 */
public class Task2 {
    class Solution {
        public String reverseVowels(String s) {
            char[] charArray = s.toCharArray();
            int left = 0;
            int right = charArray.length - 1;
            while (left < right) {
                if (!isSpecialLetter(charArray[left])) {
                    left++;
                    continue;
                }
                if (!isSpecialLetter(charArray[right])) {
                    right--;
                    continue;
                }
                // 交换
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
                left++;
                right--;
            }
            return String.copyValueOf(charArray);
        }

        /**
         * 判断是否为元音字母
         * 
         * @param ch
         * @return
         */
        private boolean isSpecialLetter(char ch) {
            Character[] chArray = new Character[] { 'a', 'o', 'e', 'u' };
            for (int i = 0; i < chArray.length; i++) {
                if (ch == chArray[i]) {
                    return true;
                }
            }
            return false;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        String result1 = solution.reverseVowels("hello");
        System.out.println(result1);

        String result2 = solution.reverseVowels("leetcode");
        System.out.println(result2);

    }
}

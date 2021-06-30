package io.liuyatao.string;

import org.junit.jupiter.api.Test;

/**
 * 二进制求和
 */
public class Task1 {
    class Solution {
        public String addBinary(String a, String b) {
            StringBuilder sBuilder = new StringBuilder();
            // 短的签名补0
            int aLength = a.length();
            int bLength = b.length();
            if (aLength > bLength) {
                b = appendZero(b, aLength - bLength);
            } else {
                a = appendZero(a, bLength - aLength);
            }
            int length = Math.max(aLength, bLength);
            int carry = 0;// 进位
            char[] aChar = a.toCharArray();
            char[] bChar = b.toCharArray();
            for (int i = length - 1; i >= 0; i--) {
                int sum = Integer.parseInt(String.valueOf(aChar[i])) + Integer.parseInt(String.valueOf(bChar[i]))
                        + carry;
                carry = sum / 2;
                sBuilder.append(sum % 2);
            }
            if (carry != 0) {
                sBuilder.append(carry);
            }
            return sBuilder.reverse().toString();
        }

        private String appendZero(String str, int zeroCount) {
            StringBuilder sBuilder = new StringBuilder();
            for (int i = 0; i < zeroCount; i++) {
                sBuilder.append("0");
            }
            return sBuilder.append(str).toString();
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        String result = solution.addBinary("1010", "1011");
        System.out.println(result);

    }
}

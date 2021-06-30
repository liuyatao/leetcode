# LeetCode 刷题记录

## 20210630

1. [344. 反转字符串](https://leetcode-cn.com/problems/reverse-string/description/)

``` java
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
```

2. [67. 二进制求和](https://leetcode-cn.com/problems/add-binary/)

``` java
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
```

3. [345. 反转字符串中的元音字母](https://leetcode-cn.com/problems/reverse-vowels-of-a-string/description/)

``` java
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
```
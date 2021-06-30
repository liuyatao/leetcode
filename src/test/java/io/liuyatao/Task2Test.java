package io.liuyatao;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 两数相加 https://leetcode-cn.com/problems/add-two-numbers/
 */
public class Task2Test {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution1 {
        /**
         * 非递归方式,循环条件中创建一个链表
         * 
         * @param l1
         * @param l2
         * @return
         */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dumyHead = new ListNode(-1);
            ListNode pre = dumyHead;
            int carry = 0;
            int value = 0;
            while (l1 != null || l2 != null || carry != 0) {
                int l1Value = 0, l2Value = 0;
                if (l1 != null) {
                    l1Value = l1 == null ? 0 : l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2Value = l2 == null ? 0 : l2.val;
                    l2 = l2.next;
                }
                value = (carry + l1Value + l2Value) % 10;
                carry = (carry + l1Value + l2Value) / 10;
                pre.next = new ListNode(value);
                pre = pre.next;
            }
            return dumyHead.next;
        }
    }

    class Solution2 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
           return addTwoNumbersWithCarry(l1, l2, 0);
        }

        /**
         * 将两数和进位数作为递归函数，终止条件是两个数都为空
         * @param l1
         * @param l2
         * @param carry
         * @return
         */
        public ListNode addTwoNumbersWithCarry(ListNode l1, ListNode l2, int carry) {
            if (l1 == null && l2 == null) {
                return carry == 0 ? null : new ListNode(carry);
            }
            int l1Value = 0;
            int l2Value = 0;
            if (l1 != null) {
                l1Value = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                l2Value = l2.val;
                l2 = l2.next;
            }
            int sum = carry + l1Value + l2Value;
            return new ListNode(sum % 10,
                    addTwoNumbersWithCarry(l1 == null ? null : l1, l2 == null ? null : l2, sum/10));
        }
    }

    class Solution3{

        int carry = 0;
        /**
         *  直接将addTwoNumbers 函数作为递归函数
         * @param l1
         * @param l2
         * @return
         */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null && l2 ==null) {
                return carry == 0 ? null : new ListNode(carry);
            }
         }
    }

    @Test
    public void test1() {
        Solution1 solution = new Solution1();

        // [2,4,3]
        ListNode nodel13 = new ListNode(3);
        ListNode nodel12 = new ListNode(4, nodel13);
        ListNode nodel11 = new ListNode(2, nodel12);

        // [5,6,4]
        ListNode nodel23 = new ListNode(4);
        ListNode nodel22 = new ListNode(6, nodel23);
        ListNode nodel21 = new ListNode(5, nodel22);
        solution.addTwoNumbers(nodel11, nodel21);
    }
}

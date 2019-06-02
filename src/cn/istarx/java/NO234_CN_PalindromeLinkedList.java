package cn.istarx.java;

import jdk.nashorn.internal.ir.IfNode;

import java.util.Stack;

public class NO234_CN_PalindromeLinkedList {

    public static void main(String[] arts) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        System.out.println(isPalindrome(listNode1));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> pre = new Stack<>();
        while (fast != null && fast.next != null) {
            pre.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) { //奇数
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.val != pre.pop()) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}

/**
 * Definition for singly-linked list.
 */
private class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
	@Override
	public String toString() {
		if (next != null) {
			return String.valueOf(val) + "->";
		} else {
			return String.valueOf(val);
		}
	}
 }

class NO2_AddTwoNumbers {
	public static void main(String[] args) {
		ListNode res = addTwoNumbers(l1, l2);
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return l1 == null ? l2 == null ? null : l2 : l1;
		}
		int upNum = 0;
		ListNode current = new ListNode(0);
		ListNode res = current;
		while (l1 != null || l2 != null) {
			int tmp = 0;
			if (l1 != null) {
				tmp += l1.val;
			}
			if (l2 != null) {
				tmp += l2.val;
			}
			tmp += upNum;
			ListNode tmpNode= new ListNode(tmp % 10);
			current.next = tmpNode;
			current = tmpNode;
			upNum = tmp / 10;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		if (upNum != 0) {
			current.next = new ListNode(upNum);
		}
		return res.next;
	}
}
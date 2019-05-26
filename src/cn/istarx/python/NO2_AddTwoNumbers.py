# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
	def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
		if not l1 or not l2:
			if l1:
				return l1
			elif l2:
				return l2
			else:
				return None
		current = ListNode(0)
		res = current
		upNum = 0
		while not l1 or not l2:
			tmp = 0
			if l1:
				tmp = tmp + l1.val
			if l2:
				tmp = tmp + l2.val
			tmp = tmp + upNum
			upNum = tmp / 10
			tmpNode = ListNode(tmp // 10)
			current.next = tmpNode
			current = tmpNode
			if l1:
				l1 = l1.next
			if l2:
				l2 = l2.next
		if upNum != 0:
			current.next = ListNode(upNum)
		return res.next
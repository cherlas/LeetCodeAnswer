class Solution:
	def twoSum(self, nums: List[int], target: int) -> List[int]:
		tmp_dic = {}
		for i in range(len(nums)):
			if nums[i] in tmp_dic:
				return [tmp_dic.get(nums[i]), i]
			tmp_dic[target - nums[i]] = i
		
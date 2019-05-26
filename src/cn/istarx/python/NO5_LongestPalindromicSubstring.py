import pprint
class Solution:
	def longestPalindrome(self, s: str) -> str:
		if not s or len(s) == 0:
			return ''
		res = [[False for i in range(len(s))] for j in range(len(s))]
		max_len = 1
		start = 0
		str_len = len(s)
		for i in range(str_len - 1):
			res[i][i] = True
			if s[i] == s[i + 1]:
				res[i][i + 1] = True
				start = i
				max_len = 2
		res[str_len - 1][str_len - 1] = True
		pprint.pprint(res)
		for tmp_len in range(3, str_len+1):
			for i in range(str_len - tmp_len + 1):
				j = i + tmp_len - 1
				if res[i+1][j-1] and s[i] == s[j]:
					max_len = tmp_len;
					start = i
					res[i][j]=True
		return s[start: start + max_len]

if __name__ == '__main__':
	print(Solution().longestPalindrome("abcda"))
		
		
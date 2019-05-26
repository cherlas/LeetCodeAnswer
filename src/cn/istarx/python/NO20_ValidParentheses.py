class Solution:
    def isValid(self, s: str) -> bool:
        dic = {'(': ')', '[': ']', '{': '}'}
        lst = []
        for c in s:
            if c in dic.keys():
                lst.append(c)
            else:
                if len(lst) == 0:
                    return False
                if c != lst.pop():
                    return False
        return len(lst) == 0
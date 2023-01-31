class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        hashmap = {"(": ")", "{": "}", "[": "]"}

        for i in s:
            if i in hashmap:
                stack.append(i)
            elif stack and hashmap[stack[-1]] == i:
                stack.pop()
            else:
                return False

        return False if stack else True

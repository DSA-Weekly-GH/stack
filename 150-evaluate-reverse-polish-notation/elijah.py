class Solution:
    def evalRPN(self, tokens: list[str]) -> int:
        stack = []
        operators = frozenset({"+", "-", "*", "/"})

        if len(tokens) == 1:
            return int(tokens[0])

        for i in tokens:
            if i not in operators:
                stack.append(i)
            else:
                b = stack.pop()
                a = stack.pop()
                stack.append(int(eval(f"{a} {i} {b}")))
        return stack[0]

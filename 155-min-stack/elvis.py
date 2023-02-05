class MinStack:
    
    def __init__(self):
        self.arr = []
        self.min_stack = []

    def __str__(self):
        return str(self.arr)

    def push(self, val: int) -> None:
        if not self.min_stack or (self.min_stack and val <= self.min_stack[-1]):
            self.min_stack.append(val)
        self.arr.append(val)

    def pop(self) -> None:
        if self.arr[-1] == self.min_stack[-1]:
            self.min_stack.pop()
        self.arr.pop()

    def top(self) -> int:
        return self.arr[-1]

    def getMin(self):
        return self.min_stack[-1]

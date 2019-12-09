class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []

    def push(self, x: int) -> None:
        currMin = self.getMin()
        self.stack.append((x, min(x, currMin)))

    def pop(self) -> None:
        del self.stack[-1]

    def top(self) -> int:
        if self.stack:
            return self.stack[-1][0]
        return None

    def getMin(self) -> int:
        if not self.stack:
            return float('inf')
        return self.stack[-1][1]

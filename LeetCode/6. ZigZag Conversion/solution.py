class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1:
            return s
        num_of_rows = min(numRows, len(s))
        rows = [''] * num_of_rows
        curr_row = 0
        going_down = False
        for ch in s:
            if curr_row == 0 or curr_row == num_of_rows - 1:
                going_down = not going_down
            rows[curr_row] += ch
            
            if going_down:
                curr_row += 1
            else:
                curr_row -= 1
        return ''.join(rows)

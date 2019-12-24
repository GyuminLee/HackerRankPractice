class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        matrix.reverse()
        for row in range(len(matrix)):
            for col in range(row+1, len(matrix)):
                matrix[row][col], matrix[col][row] = matrix[col][row], matrix[row][col]
        return matrix

class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfsMarking(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    
    private void dfsMarking(char[][] grid, int i, int j) {
        // conditions to stop searching
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        // mark current island as water or visited, so next time we won't visit it again
        grid[i][j] = '0';
        
        // do dfs to mark all adjacent islands
        dfsMarking(grid, i-1, j);
        dfsMarking(grid, i+1, j);
        dfsMarking(grid, i, j-1);
        dfsMarking(grid, i, j+1);
    }
}

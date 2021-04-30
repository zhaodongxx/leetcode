/**
 * @author zhaodong5
 * @date 2021/4/30 15:15
 */
public class Solution {

    /**
     * 0 0 0 0 0 0
     * 1 1 0 1 0 0
     * 1 0 0 1 0 1
     * 0 0 0 0 1 1
     * 0 0 0 0 0 0
     * <p>
     * DFS: 深度优先
     */
    public int numIslands(char[][] grid) {
        int amount = 0;
        for (int i = 0; i < grid.length; i++) {
            char[] chars = grid[i];
            for (int j = 0; j < chars.length; j++) {
                if (grid[i][j] == '1' ) {
                    dfs(grid, i, j);
                    amount++;
                }
            }
        }
        return amount;
    }

    private void dfs(char[][] grid, int x, int y) {
        char c = grid[x][y];
        if (c == '1' ) {
            grid[x][y] = '0';
            if (x - 1 >= 0) {
                dfs(grid, x - 1, y);
            }
            if (x + 1 < grid.length) {
                dfs(grid, x + 1, y);
            }
            if (y - 1 >= 0) {
                dfs(grid, x, y - 1);
            }
            if (y + 1 < grid[x].length) {
                dfs(grid, x, y + 1);
            }
        }
    }
}

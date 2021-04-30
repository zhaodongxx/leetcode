import java.util.LinkedList;

/**
 * @author zhaodong5
 * @date 2021/4/30 15:15
 */
public class Solution2 {

    /**
     * BFS: 广度优先
     */
    public int numIslands(char[][] grid) {
        int amount = 0;
        for (int i = 0; i < grid.length; i++) {
            char[] chars = grid[i];
            for (int j = 0; j < chars.length; j++) {
                if (grid[i][j] == '1' ) {
                    bfs(grid, i, j);
                    amount++;
                }
            }
        }
        return amount;
    }

    private void bfs(char[][] grid, int x, int y) {
        LinkedList<String> queue = new LinkedList<>();
        queue.offer(x + "-" + y);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentPoint = queue.pop();

                String[] split = currentPoint.split("-");
                int a = Integer.valueOf(split[0]);
                int b = Integer.valueOf(split[1]);

                char c = grid[a][b];
                if (c == '1' ) {
                    grid[a][b] = '0';
                    if (a - 1 >= 0) {
                        queue.add((a - 1) + "-" + b);
                    }
                    if (a + 1 < grid.length) {
                        queue.add((a + 1) + "-" + b);
                    }
                    if (b - 1 >= 0) {
                        queue.add(a + "-" + (b - 1));
                    }
                    if (b + 1 < grid[a].length) {
                        queue.add(a + "-" + (b + 1));
                    }
                }
            }
        }
    }
}

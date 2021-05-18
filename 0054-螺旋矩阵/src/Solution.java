import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaodong5
 * @date 2021/5/18 17:13
 */
public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {

        ArrayList<Integer> list = new ArrayList<>();
        int xl = 0;
        int xr = matrix[0].length - 1;
        int yt = 0;
        int yb = matrix.length - 1;
        int direction = 1;

        while (xl <= xr && yt <= yb) {
            if (direction % 4 == 1) {
                for (int i = xl; i <= xr; i++) {
                    list.add(matrix[yt][i]);
                }
                yt++;
                direction++;
            } else if (direction % 4 == 2) {
                for (int i = yt; i <= yb; i++) {
                    list.add(matrix[i][xr]);
                }
                xr--;
                direction++;
            } else if (direction % 4 == 3) {
                for (int i = xr; i >= xl; i--) {
                    list.add(matrix[yb][i]);
                }
                yb--;
                direction++;
            } else if (direction % 4 == 0) {
                for (int i = yb; i >= yt; i--) {
                    list.add(matrix[i][xl]);
                }
                xl++;
                direction++;
            }
        }
        return list;
    }
}

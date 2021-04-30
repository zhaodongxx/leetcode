import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaodong5
 * @date 2021/4/30 14:19
 */
public class Solution {

    /**
     * [1,2,3,4,5,6]
     */
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> rem = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            rem.add(nums[i]);
        }
        dfs(ret, new ArrayList<>(), rem);

        return ret;
    }

    /**
     * todo 待优化
     */
    private void dfs(List<List<Integer>> ret, List<Integer> display, List<Integer> rem) {

        if (rem.isEmpty()) {
            ret.add(display);
            return;
        }

        for (int i = 0; i < rem.size(); i++) {
            ArrayList<Integer> tempDisplay = new ArrayList<>(display);
            ArrayList<Integer> tempRem = new ArrayList<>(rem);

            tempDisplay.add(rem.get(i));
            tempRem.remove(i);
            dfs(ret, tempDisplay, tempRem);
        }
    }
}

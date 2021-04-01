import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhaod
 * @date 2021/4/1 22:49
 */
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        if (nums == null || nums.length < 3) {
            return ans;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 2; ) {
            int a = nums[i];
            if (a > 0) {
                break;
            }

            int low = i + 1;
            int high = length - 1;

            while (low < high) {
                if (nums[high] < 0) {
                    break;
                }
                int sum = nums[low] + nums[high] + a;
                if (sum == 0) {
                    ans.add(Arrays.asList(a, nums[low], nums[high]));
                    while (low < high && nums[low] == nums[++low]) ;
                    while (low < high && nums[high] == nums[--high]) ;
                } else if (sum > 0) {
                    high--;
                } else {
                    low++;
                }
            }

            while (nums[i] == nums[++i]) ;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(new Solution().threeSum(arr));
    }
}

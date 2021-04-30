/**
 * @author zhaodong5
 * @date 2021/4/30 14:50
 */
public class Solution {

    /**
     * {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}
     */
    public int search(int[] nums, int target) {
        return dg(nums, target, 0, nums.length - 1);
    }

    private int dg(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (nums[mid] > target) {
            return dg(nums, target, left, mid - 1);
        } else if (nums[mid] == target) {
            return mid;
        } else {
            return dg(nums, target, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        System.out.println(new Solution().search(ints, 11));
    }
}

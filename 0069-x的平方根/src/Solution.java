/**
 * @author zhaodong5
 * @date 2021/4/30 16:58
 */
public class Solution {

    int answar = -1;

    public int mySqrt(int x) {
        dfs(0, x, x);
        return answar;
    }

    private int dfs(int a, int b, int x) {
        if (a > b) {
            return answar;
        }
        int mid = a + (b - a) / 2;
        long i = (long) mid * mid;
        if (i == x) {
            answar = mid;
            return mid;
        } else if (i > x) {
            return dfs(a, mid - 1, x);
        } else if (i < x) {
            answar = mid;
            return dfs(mid + 1, b, x);
        }

        return answar;
    }

    /**
     * 官方题解
     */
    public int mySqrt2(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(2147395599));
    }
}

import java.util.HashMap;

/**
 * @author zhaod
 * @date 2021/4/1 22:49
 */
public class Solution {

    /**
     * 递归+缓存
     */
    public static int climbStairs(int n) {
        return calculate(n, new HashMap<>());
    }

    private static int calculate(int remainingNumber, HashMap<Integer, Integer> cache) {

        Integer num = cache.get(remainingNumber);
        if (num != null) {
            return num;
        }

        if (remainingNumber == 1) {
            return 1;
        }
        if (remainingNumber == 2) {
            return 2;
        }

        int calculate1 = calculate(remainingNumber - 1, cache);
        int calculate2 = calculate(remainingNumber - 2, cache);

        cache.putIfAbsent(remainingNumber - 1, calculate1);
        cache.putIfAbsent(remainingNumber - 2, calculate2);
        return calculate1 + calculate2;
    }

    public static void main(String[] args) {
        int n = 45;
        System.out.println(climbStairs(n));
    }
}

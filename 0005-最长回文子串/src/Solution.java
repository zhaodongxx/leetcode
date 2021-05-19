/**
 * @author zhaodong5
 * @date 2021/5/18 17:53
 */
public class Solution {

    public String longestPalindrome(String s) {
        int len = s.length(), start = 0, end = 0;
        for (int i = 0; i < len; i++) {
            //查找以i为奇数回文字符串的最大长度
            int l = i - 1, r = i + 1;
            while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            if (r - l - 1 > end - start + 1) {
                start = l + 1;  //往右移一个位置
                end = r - 1;        //往左移一个位置
            }

            //查找以i为偶数回文字符串的最大长度
            l = i;
            r = i + 1;
            while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            if (r - l - 1 > end - start + 1) {
                start = l + 1;
                end = r - 1;
            }
        }
        return s.substring(start, end + 1); //返回答案，记住该方法不包含右边界end+1
    }

    public static void main(String[] args) {
        String str = "abcdefgfedcba";
        System.out.println(new Solution().longestPalindrome(str));
    }
}

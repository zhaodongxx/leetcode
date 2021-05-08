/**
 * @author zhaodong5
 * @date 2021/5/8 17:41
 */
public class Solution {

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        // 是否进位。0：不进位；1：进位
        int up = 0;
        StringBuffer sum = new StringBuffer();

        while (i > 0 || j > 0 || up != 0) {
            Integer a = i > 0 ? num1.charAt(i) - '0' : 0;
            Integer b = j > 0 ? num2.charAt(j) - '0' : 0;
            Integer val = a + b + up;
            up = val / 10;
            sum.append(val % 10);
            i--;
            j--;
        }
        sum.reverse();
        return sum.toString();
    }

    public static void main(String[] args) {
        String a = "123456789";
        String b = "987654321";

        System.out.println(new Solution().addStrings(a, b));
    }
}

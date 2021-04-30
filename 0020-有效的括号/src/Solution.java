import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author zhaodong5
 * @date 2021/4/30 9:52
 */
public class Solution {

    public boolean isValid(String s) {

        int len = s.length();
        if (len % 2 != 0) {
            return false;
        }

        LinkedList<Character> stack = new LinkedList<Character>();
        Map<Character, Character> map = new HashMap() {{
            put(']', '[' );
            put('}', '{' );
            put(')', '(' );
        }};

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.isEmpty() || !stack.peek().equals(map.get(c))) {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "([)]";
        System.out.println(new Solution().isValid(str));
    }
}

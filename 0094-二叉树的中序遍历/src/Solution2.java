import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author zhaodong5
 * @date 2021/5/14 15:44
 */
public class Solution2 {

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 栈迭代
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        HashMap<TreeNode, Integer> cache = new HashMap<>();
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        cache.put(root, 1);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (cache.remove(node) == 1) {
                if (node.right != null) {
                    stack.push(node.right);
                    cache.put(node.right, 1);
                }
                stack.push(node);
                cache.put(node, 2);
                if (node.left != null) {
                    stack.push(node.left);
                    cache.put(node.left, 1);
                }
            } else {
                res.add(node.val);
            }
        }

        return res;
    }
}

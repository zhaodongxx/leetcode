import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaodong5
 * @date 2021/5/13 18:30
 */
public class Solution {

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
     * 递归
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        ldr(res, root);
        return res;
    }

    private void ldr(List<Integer> res, TreeNode node) {

        if (node == null) {
            return;
        }

        ldr(res, node.left);
        res.add(node.val);
        ldr(res, node.right);
    }
}

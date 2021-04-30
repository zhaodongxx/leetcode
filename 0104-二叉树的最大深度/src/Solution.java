/**
 * @author zhaodong5
 * @date 2021/4/30 16:51
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

    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }

        return Math.max(dfs(node.left, depth + 1), dfs(node.right, depth + 1));
    }
}

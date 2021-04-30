import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author zhaodong5
 * @date 2021/4/30 10:49
 */
public class Solution {

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }
    }

    Set<String> cache = new HashSet<>();

    /**
     * 深度优先+备忘录
     * <p>
     * 树中节点数目在范围 [2, 105] 内。
     * -109 <= Node.val <= 109
     * 所有 Node.val 互不相同 。
     * p != q
     * p 和 q 均存在于给定的二叉树中。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> orderP = new LinkedList<>();
        LinkedList<TreeNode> orderQ = new LinkedList<>();

        dfs(root, p, orderP);
        dfs(root, q, orderQ);

        int size = Math.min(orderP.size(), orderQ.size());
        for (int i = 0; i < size; i++) {
            if (orderP.get(i).val != orderQ.get(i).val) {
                return orderP.get(--i);
            }
        }
        return orderP.get(--size);
    }

    void dfs(TreeNode node, TreeNode p, LinkedList<TreeNode> order) {
        if (node == null) {
            return;
        }

        // 缓存
        if (cache.contains(node.val + "-" + p.val)) {
            return;
        }

        if (node.val == p.val) {
            order.add(node);
            return;
        }

        dfs(node.left, p, order);
        if (!order.isEmpty()) {
            order.push(node);
            return;
        }
        dfs(node.right, p, order);
        if (!order.isEmpty()) {
            order.push(node);
            return;
        }

        cache.add(node.val + "-" + p.val);
        return;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode = new TreeNode(1, treeNode1, treeNode2);
        TreeNode treeNode3 = new Solution().lowestCommonAncestor(treeNode, treeNode1, treeNode2);

        System.out.println(treeNode3);
    }
}
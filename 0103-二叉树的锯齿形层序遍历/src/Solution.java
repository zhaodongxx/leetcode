import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhaodong5
 * @date 2021/5/8 18:10
 */
public class Solution {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 广度优先+切换指针方向
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        LinkedList<TreeNode> temp = new LinkedList<>();
        if (root == null) {
            return ret;
        }
        temp.addFirst(root);
        boolean left2Right = true;

        while (!temp.isEmpty()) {
            int size = temp.size();
            List<Integer> retItem = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (left2Right) {
                    TreeNode treeNode = temp.pollLast();
                    if (treeNode == null) {
                        continue;
                    }
                    retItem.add(treeNode.val);
                    temp.addFirst(treeNode.left);
                    temp.addFirst(treeNode.right);
                } else {
                    TreeNode treeNode = temp.pollFirst();
                    if (treeNode == null) {
                        continue;
                    }
                    retItem.add(treeNode.val);
                    temp.addLast(treeNode.right);
                    temp.addLast(treeNode.left);
                }
            }
            left2Right = !left2Right;
            if (!retItem.isEmpty()) {
                ret.add(retItem);
            }
        }

        return ret;
    }
}

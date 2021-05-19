/**
 * @author zhaodong5
 * @date 2021/5/19 18:08
 */
public class Solution2 {

    public static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    /**
     * 头插法
     * <p>
     * 1、我们定义两个指针，分别称之为 g(guard 守卫) 和 p(point)。
     * 我们首先根据方法的参数 m 确定 g 和 p 的位置。将 g 移动到第一个要反转的节点的前面，将 p 移动到第一个要反转的节点的位置上。我们以 m=2，n=4为例。
     * 2、将 p 后面的元素删除，然后添加到 g 的后面。也即头插法。
     * 3、根据 m 和 n 重复步骤（2）
     * 4、返回 dummyHead.next
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 定义一个dummyHead, 方便处理
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // 初始化指针
        ListNode g = dummyHead;
        ListNode p = dummyHead.next;

        // 将指针移到相应的位置
        for (int step = 0; step < left - 1; step++) {
            g = g.next;
            p = p.next;
        }

        // 头插法插入节点
        for (int i = 0; i < right - left; i++) {
            ListNode removed = p.next;
            p.next = p.next.next;

            removed.next = g.next;
            g.next = removed;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution.ListNode c = new Solution.ListNode(3);
        Solution.ListNode b = new Solution.ListNode(2, c);
        Solution.ListNode a = new Solution.ListNode(1, b);

        Solution.ListNode listNode = new Solution().reverseBetween(a, 1, 2);
        System.out.println(listNode);
    }
}

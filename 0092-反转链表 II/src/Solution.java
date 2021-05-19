import java.util.Stack;

/**
 * @author zhaodong5
 * @date 2021/5/19 15:24
 */
public class Solution {

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
     * 遍历两次+栈
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {

        Stack<ListNode> stack = new Stack();
        ListNode node = head;
        ListNode tail = null;
        if (head.next == null || right - left == 0) {
            return head;
        }

        int i = 1;
        while (node != null) {
            if (i >= left && i <= right) {
                stack.push(node);
            }
            if (i == right && node.next != null) {
                tail = node.next;
            }
            node = node.next;
            i++;
        }

        i = 1;
        ListNode prev = null;
        node = head;
        while (node != null) {
            if (i < left) {
                if (prev != null) {
                    prev.next = node;
                }
                prev = node;
                node = node.next;
            } else if (i >= left && i <= right) {
                node = stack.pop();
                if (i == 1) {
                    head = node;
                }
                if (prev != null) {
                    prev.next = node;
                }
                prev = node;
            } else if (i == right + 1) {
                prev.next = tail;
                break;
            }
            i++;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode c = new ListNode(3);
        ListNode b = new ListNode(2, c);
        ListNode a = new ListNode(1, b);

        ListNode listNode = new Solution().reverseBetween(a, 1, 2);
        System.out.println(listNode);
    }
}
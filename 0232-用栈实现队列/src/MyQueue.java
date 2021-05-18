import java.util.Stack;

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 *
 * @author zhaodong5
 * @date 2021/5/18 16:30
 */
public class MyQueue {

    private Stack<Integer> a;// 输入栈
    private Stack<Integer> b;// 输出栈

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        a = new Stack();
        b = new Stack();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        a.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (b.isEmpty()) {
            while (!a.isEmpty()) {
                b.push(a.pop());
            }
        }
        if (b.isEmpty()) {
            return -1;
        }
        return b.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (b.isEmpty()) {
            while (!a.isEmpty()) {
                b.push(a.pop());
            }
        }
        if (b.isEmpty()) {
            return -1;
        }

        return b.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return a.isEmpty() && b.isEmpty();
    }
}


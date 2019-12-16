package part5;

import java.util.Stack;

/**
 * @Author: MikeWang
 * @Date: 2019/12/16 10:05 AM
 * @Description: 实现一个栈，该栈带有出栈（pop）、入栈（push）、取最小元素（getMin）3个方法。
 * 时间复杂度O(1)
 */
public class CustomStack {
    private Stack<Integer> mainStack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();

    /**
     * 入栈操作
     *
     * @param element
     */
    public void push(int element) {
        mainStack.push(element);
        if (minStack.empty() || element <= minStack.peek()) {
            minStack.push(element);
        }
    }

    /**
     * 出栈操作
     *
     * @return
     */
    public Integer pop() {
        if (mainStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        return mainStack.pop();
    }

    /**
     * 获取栈的最小元素
     *
     * @return
     * @throws Exception
     */
    public int getMin() throws Exception {
        if (minStack.empty()) {
            throw new Exception("stack is empty");
        }
        return minStack.peek();
    }

    public static void main(String[] args) throws Exception {
        CustomStack stack = new CustomStack();
        stack.push(4);
        stack.push(9);
        stack.push(7);
        stack.push(3);
        stack.push(8);
        stack.push(5);
        System.out.println(stack.getMin());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());

    }
}

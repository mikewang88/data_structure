package datastructure.part5;

import java.util.Stack;

/**
 * @Author: MikeWang
 * @Date: 2019/12/24 10:21 AM
 * @Description:
 * 用栈实现队列
 */
public class StackToList {

    private Stack<Integer> stackA = new Stack<Integer>();
    private Stack<Integer> stackB = new Stack<Integer>();

    /**
     * 入队操作
     * @param element 入队的元素
     */
    public void enQueue(int element){
        stackA.push(element);
    }

    public Integer deQueue(){
        if (stackB.isEmpty()){
            if (stackA.isEmpty()){
                return null;
            }
            transfer();
        }
        return stackB.pop();
    }

    private void transfer(){
        while (!stackA.isEmpty()){
            stackB.push(stackA.pop());
        }
    }

    public static void main(String[] args) {
        StackToList stackToList = new StackToList();
        stackToList.enQueue(1);
        stackToList.enQueue(2);
        stackToList.enQueue(3);
        System.out.println(stackToList.deQueue());
        System.out.println(stackToList.deQueue());
        System.out.println(stackToList.deQueue());
        stackToList.enQueue(4);
        System.out.println(stackToList.deQueue());
    }

}

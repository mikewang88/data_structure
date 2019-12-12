package part5;

import com.sun.prism.impl.PrismTrace;

/**
 * @Author: MikeWang
 * @Date: 2019/12/12 11:39 AM
 * @Description: 判断链表中是否有环
 * 时间复杂度 O(n) 空间复杂度O(1)
 */
public class IScycle {

    public static void main(String[] args) {
        Node node1 = new Node(5);
        Node node2 = new Node(3);
        Node node3 = new Node(7);
        Node node4 = new Node(2);
        Node node5 = new Node(6);
        Node node6 = new Node(8);
        Node node7 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node4;

        System.out.println(isCycle(node1));

        System.out.println(CircleLength(node1));
        System.out.println(enterCycleNode(node1));


    }

    /**
     * 判断是否有环
     *
     * @param head
     * @return
     */
    public static boolean isCycle(Node head) {
        Node p1 = head;
        Node p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                System.out.println("相遇点：" + p2.data);
                return true;
            }
        }
        return false;
    }


    /**
     * 判断入环点
     * @param head
     * @return 头节点---》入环点 = 相遇点--》遇环点
     */
    public static Node enterCycleNode(Node head) {
        Node p1 = head;
        Node p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2){
                System.out.println("说明有环");
                p1 = head;
                while (p1!=p2){
                    p1 = p1.next;
                    p2 = p2.next;
                }
                System.out.println("入环点："+p1.data);
                break;
            }
        }
        return p1;
    }

    /**
     * 获取环长
     *
     * @param first
     * @return
     */
    public static int CircleLength(Node first) {
        Node fast = first;
        Node slow = first;
        while ((fast != null) && (fast.next != null)) {
            fast = fast.next.next;
            slow = slow.next;
            while (fast == slow) {
                int len = 1;
                fast = fast.next.next;
                slow = slow.next;
                while (fast != slow) {
                    len++;
                    fast = fast.next.next;
                    slow = slow.next;
                }
                return len;
            }
        }
        return 0;
    }


    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
}

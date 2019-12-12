package part5;

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

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;

        System.out.println(isCycle(node1));


    }

    public static boolean isCycle(Node head) {
        Node p1 = head;
        Node p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }



    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
}

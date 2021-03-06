package datastructure.part6;

import java.util.HashMap;

/**
 * @Author: MikeWang
 * @Date: 2020/1/6 10:52 AM
 * @Description: 线程不安全
 */
public class LRUCache {
//                 LinkedHashMap
    private Node head;
    private Node end;
    //缓存存储上线
    private int limit;

    private HashMap<String,Node> hashMap;

    public LRUCache(int limit){
        this.limit = limit;
        hashMap = new HashMap<>();
    }

    public void put(String key,String value){
        Node node = hashMap.get(key);
        if (node ==null){
            //
            if (hashMap.size() >= limit){
                String oldKey = removeNode(head);
                hashMap.remove(oldKey);
            }
            node = new Node(key,value);
            addNode(node);
            hashMap.put(key,node);
        }else {
            node.value = value;
            refreshNode(node);
        }
    }

    public String get(String key){
        Node node = hashMap.get(key);
        if (node == null){
            return null;
        }
        refreshNode(node);
        return node.value;
    }

    public void remove(String key){
        Node node = hashMap.get(key);
        removeNode(node);
        hashMap.remove(key);
    }

    /**
     * 刷新被访问节点位置
     * @param node
     */
    private void refreshNode(Node node){
        //如果访问的是尾节点，则无须移动节点
        if (node == end){
            return;
        }
        //移除节点
        removeNode(node);
        //重新插入节点
        addNode(node);

    }

    /**
     * 删除节点
     * @param node
     * @return
     */
    private String removeNode(Node node){
        if (node == head && node == end){
            //移除唯一的节点
            head =null;
            end =null;
        }else if (node == end){
            //移除尾节点
            end =end.pre;
            end.next = null;
        }else if (node == head){
            //移除头节点
            head = head.next;
            head.pre = null;
        }else {
            //移除中间节点
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        return node.key;
    }

    /**
     * 尾部插入节点
     * @param node
     */
    private void addNode(Node node){
        if (end!=null){
            end.next = node;
            node.pre =end;
            node.next = null;
        }
        end = node;
        if (head == null){
            head = node;
        }
    }



    class Node{
        Node(String key,String value){
            this.key = key;
            this.value = value;
        }

        public Node pre;
        public Node next;
        public String key;
        public String value;
    }

    public static void main(String[] args) {

    }
}

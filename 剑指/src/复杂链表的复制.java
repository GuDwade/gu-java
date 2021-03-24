import java.util.HashMap;
import java.util.Map;

public class 复杂链表的复制 {


    public Node copyRandomList(Node head) {
        if (head == null){
            return  head;
        }

        Node cur = head;
        while (cur != null){
            Node next = cur.next;
            Node copy = new Node(cur.val);
            cur.next = copy;
            copy.next = next;
            cur = next;
        }

        cur = head;
        while (cur != null){
            Node copy = cur.next;
            Node next = copy.next;
            if (cur.random != null){
                copy.random = cur.random.next;
            }else {
                copy.random = null;
            }
            cur = next;
        }

        cur = head;
        Node nHead = cur.next;
        while (cur != null){
            Node copy = cur.next;
            Node next = copy.next;
            cur.next = next;
            if (next != null){
                copy.next = next.next;
            }
            cur = next;
        }

        return nHead;
    }

    public Node copyRandomList1(Node head) {
        if (head == null){
            return  head;
        }

        Node cur = head, nHead = null , nTail = null;
        Map<Node,Node> map = new HashMap<>();

        while (cur != null){
            Node node = new Node(cur.val);
            if (nHead == null){
                nHead = node;
                nTail = nHead;
            }else {
                nTail.next = node;
                nTail = nTail.next;
            }
            map.put(cur,node);
            cur = cur.next;
        }

        cur = head;
        nTail = nHead;

        while (cur != null){
            if (cur.random != null){
                nTail.random = map.get(cur.random);
            }else {
                nTail.random = null;
            }

            cur = cur.next;
            nTail = nTail.next;
        }

        return  nHead;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
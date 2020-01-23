class Node {
    int val;
    Node next;
    Node random;

    Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class CopyRandomList {
    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur;
        cur = head;
        while (cur != null) {
            Node node = new Node(0);
            node.val = cur.val;
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }

            cur = cur.next.next;
        }
        cur = head;
        Node nHead = head.next;
        while (cur != null) {
            Node node = cur.next;
            cur.next = node.next;
            if (node.next != null) {
                node.next = node.next.next;
            }
            cur = cur.next;
        }
        return nHead;
    }
}

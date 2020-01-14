class Node{
    int val;
    Node next;
    Node(int val,Node next){
        this.val=val;
        this.next=next;
    }
    Node(int val){
        this(val,null);
    }
}
public class MyLinkList {

    public static Node pushFront(Node head,int val){
        Node nhead=new Node(val);
        nhead.next=head;
        return nhead;
    }

    public static Node popFront(Node head){
        if(head==null){
            throw new RuntimeException("空链表");
        }
        return head.next;
    }

    public static Node pushBack(Node head,int val){
        Node node=new Node(val);
        if(head==null){
            return node;
        }
        Node cur=head;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=node;
        return head;
    }

    public static Node popback(Node head){
        if(head==null){
            throw new RuntimeException("空链表");
        }
        if(head.next==null){
            return null;
        }else {
            Node cur = head;
            while (cur.next.next != null) {
                cur = cur.next;
            }
            cur.next = null;
            return head;
        }
    }

    public  static  void print(Node head){
        if(head==null){
            return;
        }
        Node cur=head;
        while(cur!=null){
            System.out.printf("%s\t",cur.val);
            cur=cur.next;
        }
    }

    public static Node addIndex(Node head,int index,int val){
        if(head==null){
            throw new RuntimeException("空链表");
        }
        Node cur=head;
        Node node=new Node(val);
        while(cur!=null){
            if(cur.val==index){
                Node next=cur.next;
                cur.next=node;
                node.next=next;
                break;
            }
            cur=cur.next;
        }
        return head;
    }

    public static Node removeAllVal(Node head,int val){
        Node nHead=new Node(0);
        nHead.next=head;
        Node cur=nHead;
        Node next=head;
        while(next!=null){
            if(next.val==val){
                cur.next=next.next;
            }else{
                cur=next;
            }
            next=next.next;
        }
        return nHead.next;
    }

    public static void main(String[] args) {
        Node head=new Node(3);
        head=pushFront(head,1);
        head=pushBack(head,2);
        print(head);
        System.out.println();
        head=pushFront(head,0);
        head=pushBack(head,4);
        print(head);
        System.out.println();
        head=popFront(head);
        head=popback(head);
        print(head);
        System.out.println();
        head=addIndex(head,2,10);
        head=pushFront(head,3);
        head=pushBack(head,3);
        print(head);
        System.out.println();
        head=removeAllVal(head,3);
        print(head);
    }
}

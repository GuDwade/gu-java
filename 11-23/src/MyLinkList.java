public class MyLinkList {
    public static Node buildLinkList(){
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        Node n5=new Node(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        return n1;
    }
    public static void printLink(Node head){
        Node cur=head;
        while(cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }
    }
    public static Node pushFront(Node head,int val){
        Node node=new Node(val);
        node.next=head;
        return node;
    }
    public static Node popFront(Node head){
        if(head==null){
            System.out.println("异常");
            return null;
        }else{
            return head.next;
        }
    }
    public static Node pushBack(Node head,int val){
        Node cur=head;
        Node last=new Node(val);
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=last;
        return head;
    }
    public static Node popBack(Node head){
        Node cur=head;
        while(cur.next.next!=null){
            cur=cur.next;
        }
        cur.next=null;
        return head;
    }
    public static Node reserveList(Node head){
        Node cur=head;
        Node nHead=null;
        while(cur!=null){
            Node next=cur.next;
            cur.next=nHead;
            nHead=cur;
            cur=next;
        }
        return nHead;
    }

    public static void main(String[]args){
        Node head=buildLinkList();
        head=pushFront(head,0);
        head=popFront(head);
        head=pushBack(head,6);
        head=popBack(head);
        head=reserveList(head);
        printLink(head);
    }
}

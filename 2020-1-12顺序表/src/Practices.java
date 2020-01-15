public class Practices {
    public static  Node reverseList(Node head) {
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

    public static Node reverseList1(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node p = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static  Node mergeTwoLists(Node l1, Node l2) {
       if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        Node nHead=null;
        Node current=null;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                if(nHead==null){
                    nHead=l1;
                    current=l1;
                }else{
                    current.next=l1;
                    current=current.next;
                }
                l1=l1.next;
            }else{
                if(nHead==null){
                    nHead=l2;
                    current=l2;
                }else{
                    current.next=l2;
                    current=current.next;
                }
                l2=l2.next;
            }
        }
        if(l1==null){
            current.next=l2;
        }else{
            current.next=l1;
        }
        return nHead;
    }

    public static Node bulidList(){
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        Node n5=new Node(5);
        Node n6=new Node(6);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        return  n1;
    }

    public static void main(String[] args) {
        Node n1=bulidList();
        MyLinkList.print(n1);
        System.out.println();
        MyLinkList.print(reverseList(n1));
        System.out.println();
        Node n2=bulidList();
        MyLinkList.print(reverseList1(n2));
        System.out.println();
        Node n3=bulidList();
        Node n4=bulidList();
        MyLinkList.print(mergeTwoLists(n3,n4));
    }

}

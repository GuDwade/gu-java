public class DeleteDuplication {
    public static  Node deleteDuplication(Node pHead){
        if(pHead==null){
            return null;
        }
        Node prev=new Node(1);
        Node fake=prev;
        prev.next=pHead;
        Node cur=pHead;
        Node next=pHead.next;
        while (next!=null){
            if(cur.val!=next.val){
                prev=prev.next;
                cur=cur.next;
                next=next.next;
            }else{
                while(next!=null&&cur.val==next.val){
                    next=next.next;
                }
                prev.next=next;
                cur=next;
                if(next!=null){
                next=cur.next;
                }
            }
        }
        return fake.next;
    }

    public static Node deleteDuplicates(Node head) {
        if(head==null){
            return null;
        }
        Node prev=new Node(1);
        Node fake=prev;
        prev.next=head;
        Node cur=head;
        Node next=head.next;
        while(next!=null){
            if(cur.val!=next.val){
                prev=prev.next;
                cur=cur.next;
                next=next.next;
            }else{
                while(next!=null&&cur.val==next.val){
                    next=next.next;
                }
                prev.next=cur;
                cur.next=next;

            }
        }
        return fake.next;

    }

    public static void main(String[] args) {
        Node n1=new Node (1);
        Node n2=new Node (1);
        Node n3=new Node (2);
        Node n4=new Node (2);
        Node n5=new Node (3);
        Node n6=new Node (4);
        Node n7=new Node (4);
        Node n8=new Node (5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n7;
        n7.next=n8;
        MyLinkList.print(deleteDuplication(n1));
        System.out.println();
        MyLinkList.print(deleteDuplicates(n1));

    }
}

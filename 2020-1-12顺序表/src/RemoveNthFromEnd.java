public class RemoveNthFromEnd {
    public  static Node removeNthFromEnd(Node head, int n) {
        if(head==null){
            return null;
        }
        int sum=0;
        Node p=head;
        while(p!=null){
            sum++;
            p=p.next;
        }
        Node nHead=new Node(0);
        nHead.next=head;
        Node cur=nHead;
        int length=sum-n;
        while(length>0){
            length--;
            cur=cur.next;
        }
        cur.next=cur.next.next;
        return nHead.next;

    }

    public static void main(String[] args) {
        Node n1=Practices.bulidList();
        MyLinkList.print(n1);
        System.out.println();
        MyLinkList.print(removeNthFromEnd(n1,2));
    }
}

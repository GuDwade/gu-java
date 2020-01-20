public class ReverseBetween {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null){
            return head;
        }
        ListNode prev=null;
        ListNode cur=head;
        while(m>1){
            prev=cur;
            cur=cur.next;
            m--;
            n--;
        }
        ListNode con=prev;
        ListNode tail=cur;
        ListNode next=null;
        while(n>0){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
            n--;
        }
        if(con!=null){
            con.next=prev;
        }else{
            head=prev;
        }
        tail.next=cur;
        return  head;
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(5);
        ListNode n6=new ListNode(6);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        ListNode.print(reverseBetween(n1,2,5));
        ListNode.print(reverseBetween(n2,1,2));
    }
}

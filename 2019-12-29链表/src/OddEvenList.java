public class OddEvenList {
    public static ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null||head.next.next==null){
            return head;
        }
        ListNode cur=head;
        int length=0;
        while(cur!=null){
            length++;
            cur=cur.next;
        }
        ListNode odd=new ListNode(0);
        ListNode even=new ListNode(0);
        ListNode oddCur=odd;
        ListNode evenCur=even;
        for(int i=1;i<=length;i++){
            if(i%2==0){
                evenCur.next=head;
                evenCur=evenCur.next;

            }else{
                oddCur.next=head;
                oddCur=oddCur.next;
            }
            head=head.next;

        }
        evenCur.next=null;
        oddCur.next=even.next;
        return odd.next;
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
        ListNode.print(oddEvenList(n1));
        ListNode n7=new ListNode(1);
        ListNode n8=new ListNode(2);
        ListNode n9=new ListNode(3);
        n7.next=n8;
        n8.next=n9;
        ListNode.print(oddEvenList(n7));
    }
}

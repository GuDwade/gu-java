public class SortList {
    public static ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode cur=head;
        int length=0;
        while(cur!=null){
            length++;
            cur=cur.next;
        }
        for(int i=0;i<length-1;i++){
            int tmp=0;
            cur=head;
            ListNode next=head.next;
            for(int j=0;j<length-i-1;j++){
                if(cur.val>=next.val){
                    tmp=next.val;
                    next.val=cur.val;
                    cur.val=tmp;
                }
                cur=next;
                next=next.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(3);
        ListNode n2=new ListNode(8);
        ListNode n3=new ListNode(1);
        ListNode n4=new ListNode(5);
        ListNode n5=new ListNode(9);
        ListNode n6=new ListNode(2);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        ListNode.print(sortList(n1));
    }
}

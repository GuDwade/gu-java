public class RotateRight {
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        int length=0;
        ListNode cur=head;
        while(cur!=null){
            length++;
            cur=cur.next;
        }
        int turn=k%length;
        if(turn==0){
            return head;
        }
        ListNode tmp=head;
        ListNode pre=head;
        for(int i=0;i<length-turn-1;i++){
            pre=pre.next;
        }
        ListNode ret=pre.next;
        ListNode end=ret;
        for(int j=0;j<turn-1;j++){
            end=end.next;
        }
        end.next=tmp;
        pre.next=null;
        return ret;
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        ListNode.print(rotateRight(n1,3));
    }
}

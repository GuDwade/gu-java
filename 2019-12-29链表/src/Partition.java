public class Partition {
    public static ListNode partition(ListNode head, int x) {
        ListNode small=new ListNode(0);
        ListNode smallCur=small;
        ListNode big=new ListNode(1);
        ListNode bigCur=big;
        while(head!=null){
            if(head.val<x){
                smallCur.next=head;
                smallCur=smallCur.next;
            }
            else{
                bigCur.next=head;
                bigCur=bigCur.next;
            }
            head=head.next;
        }
        bigCur.next=null;
        smallCur.next=big.next;
        return small.next;
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(4);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(5);
        ListNode n5=new ListNode(4);
        ListNode n6=new ListNode(1);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        ListNode.print(partition(n1,4));
    }

}

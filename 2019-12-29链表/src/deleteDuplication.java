class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class deleteDuplication {
    public static ListNode deleteDuplication(ListNode pHead){
        if(pHead==null){
            return pHead;
        }
        ListNode prev=new ListNode(1);
        ListNode fake=prev;
        prev.next=pHead;
        ListNode cur=pHead;
        ListNode next=pHead.next;
        while(next!=null){
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
                    next=next.next;
                }
            }
        }
        return  fake.next;
    }
    public void printf(ListNode head){
        while(head!=null){
            System.out.print(head.val);
            head=head.next;
        }
    }
    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(2);
        ListNode n4=new ListNode(2);
        ListNode n5=new ListNode(3);
        ListNode n6=new ListNode(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        deleteDuplication test=new deleteDuplication();
        test.printf(n1);
        test.printf(deleteDuplication(n1));
    }
}


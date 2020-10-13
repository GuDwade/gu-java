package Dec;

public class Day13 {
    //两两交换链表中的节点

    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return  head;
        }

        ListNode prev=new ListNode(-1);
        prev.next=head;
        ListNode cur=prev;

        while (cur.next!=null&&cur.next.next!=null){
            ListNode start=cur.next;
            ListNode end=start.next;
            cur.next=end;
            start.next=end.next;
            end.next=start;
            cur=start;
        }

        return  prev.next;
    }
}

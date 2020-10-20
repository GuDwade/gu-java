package Dec;


public class Day20 {
    //重排链表

    public void reorderList(ListNode head) {
        if (head==null||head.next==null){
            return;
        }

        int len=0;
        ListNode cur=head;
        while (cur!=null){
            len++;
            cur=cur.next;
        }

        cur=head;
        for(int i=0;i<len/2;i++){
            cur=cur.next;
        }

        ListNode past=cur.next;
        cur.next=null;
        ListNode prev=null;

        while (past!=null){
            ListNode next=past.next;
            past.next=prev;
            prev=past;
            past=next;
        }

        cur=head;

        while (cur!=null&&prev!=null){
            ListNode cNext=cur.next;
            ListNode pNext=prev.next;

            cur.next=prev;
            prev.next=cNext;

            cur=cNext;
            prev=pNext;
        }

    }
}

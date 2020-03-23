public class Day17 {
    //链表的中间结点
    public ListNode middleNode(ListNode head) {
        if(head==null){
            return head;
        }
        int size=0;
        ListNode cur=head;
        while(cur!=null){
            size++;
            cur=cur.next;
        }
        int move=size/2;
        ListNode nHead=head;
        while(size>0){
            nHead=nHead.next;
            size--;
        }
        return  nHead;
    }
    //快慢指针
    public ListNode middleNode1(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}

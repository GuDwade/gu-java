public class 链表习题复习 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head==null||k<1){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;

        while (k>0){
            fast=fast.next;
            k--;
        }

        while (fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return  slow;
    }

    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return  head;
        }

        ListNode nHead=null;
        ListNode cur=head;
        ListNode next=null;

        while (cur!=null){
            next=cur.next;
            cur.next=nHead;
            nHead=cur;
            cur=next;
        }
        return  nHead;
    }

    public ListNode reverseList1(ListNode head) {
        if(head==null||head.next==null){
            return  head;
        }

        ListNode nHead=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode node=new ListNode(cur.val);
            node.next=nHead;
            nHead=node;
            cur=cur.next;
        }
        return  nHead;
    }

    public ListNode deleteNode(ListNode head, int val) {
        if(head==null){
            return  null;
        }

        ListNode fake=new ListNode(0);
        ListNode prev=fake;
        prev.next=head;
        ListNode cur=head;

        while (cur!=null){
            if(cur.val==val){
                prev.next=cur.next;
                break;
            }else{
                prev=prev.next;
                cur=cur.next;
            }
        }
        return fake.next;
    }
}

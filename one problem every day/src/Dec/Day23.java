package Dec;

public class Day23 {
    // 回文链表
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return  true;
        }

        ListNode slow=head;
        ListNode fast=head;

        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode prev=null;
        while (slow!=null){
            ListNode next=slow.next;
            slow.next=prev;
            prev=slow;
            slow=next;
        }

        ListNode cur=head;
        while (prev!=null){
            if (prev.val!=cur.val){
                return  false;
            }
            prev=prev.next;
            cur=cur.next;
        }

        return  true;
    }
}

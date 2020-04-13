public class April_13th {
    //分割链表
    public ListNode partition(ListNode head, int x) {
        if(head==null){
            return head;
        }

        ListNode bigHead=null,bigTail=null,smallHead=null,samllTail=null;

        ListNode cur=head;

        while(cur!=null){
            if(cur.val<x){
                if(smallHead==null){
                    smallHead=cur;
                    samllTail=smallHead;
                }else{
                    samllTail.next=cur;
                    samllTail=cur;
                }
            }else{
                if(bigHead==null){
                    bigHead=cur;
                    bigTail=bigHead;
                }else{
                    bigTail.next=cur;
                    bigTail=cur;
                }
            }
            cur=cur.next;
        }

        if(smallHead==null){
            return bigHead;
        }
        if(bigHead==null){
            return smallHead;
        }

        bigTail.next=null;
        samllTail.next=bigHead;
        return smallHead;
    }
    //回文链表   逆置链表
    public boolean isPalindrome(ListNode head) {
        if(head==null){
            return true;
        }

        ListNode newHead=reserveAndClone(head);
        ListNode cur1=head;
        ListNode cur2=newHead;

        while (cur1!=null&&cur2!=null){
            if(cur1.val!=cur2.val){
                return  false;
            }
            cur1=cur1.next;
            cur2=cur2.next;
        }

        return  true;

    }

    public ListNode reserveAndClone(ListNode head){
        if(head==null){
            return head;
        }

        ListNode nHead=null;


        while (head!=null){
           ListNode node=new ListNode(head.val);
           node.next=nHead;
           nHead=node;
           head=head.next;
        }

        return  nHead;
    }

    //回文链表   快慢指针
    public boolean isPalindrome1(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }

        ListNode fast=head, slow=head;
        //找中间结点
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //逆置后半部分
        ListNode prev=null;
        ListNode next=null;
        while(slow!=null){
            next=slow.next;
            slow.next=prev;
            prev=slow;
            slow=next;
        }

        ListNode cur=head;
        //此时链表是相交的 交点就是中间结点
        while(prev!=null){
            if(cur.val!=prev.val){
                return false;
            }
            cur=cur.next;
            prev=prev.next;
        }
        return  true;
    }
}

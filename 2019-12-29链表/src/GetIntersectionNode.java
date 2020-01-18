public class GetIntersectionNode {
    public  static  void print(ListNode head){
        if(head==null){
            return;
        }
        ListNode cur=head;
        while(cur!=null){
            System.out.printf("%s\t",cur.val);
            cur=cur.next;
        }
        System.out.println();
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode p=headA;
        ListNode q=headB;
        while(p!=q){
            p=(p==null)?headA:p.next;
            q=(q==null)?headB:q.next;
        }
        return q;
    }

    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode p=headA;
        ListNode q=headB;
        int lengthOfA=0;
        int lengthOfB=0;
        while(p!=null){
            lengthOfA++;
            p=p.next;
        }
        while(q!=null){
            lengthOfB++;
            q=q.next;
        }
        int length=lengthOfA-lengthOfB;
        if(length>0){
            while(length>0){
                length--;
                headA=headA.next;
            }
        }else{
            while(length<0){
                length++;
                headB=headB.next;
            }
        }
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}

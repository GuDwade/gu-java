public class GetIntersectionNode {
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

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(5);
        ListNode n6=new ListNode(6);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        ListNode n7=new ListNode(5);
        n7.next=n3;
        ListNode.print(getIntersectionNode1(n1,n7));
        ListNode.print(getIntersectionNode(n1,n7));
    }
}

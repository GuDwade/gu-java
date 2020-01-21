public class HasCycle {
    public static boolean hasCycle(ListNode head) {
        if(head==null||head.next==null){
            return false;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        while(slow!=fast){
            if(fast==null||fast.next==null){
                return false;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return true;
    }

    public static ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null){
            return null;
        }
        ListNode same=getIntersect(head);
        if(same==null){
            return null;
        }
        ListNode ret=head;
        while(ret!=same){
            ret=ret.next;
            same=same.next;
        }
        return ret;
    }

    public static ListNode getIntersect(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return slow;
            }
        }
        return null;
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
        n6.next=n3;
        System.out.println(hasCycle(n1));
        ListNode n7=new ListNode(7);
        ListNode n8=new ListNode(8);
        ListNode n9=new ListNode(9);
        n7.next=n8;
        n8.next=n9;
        System.out.println(hasCycle(n7));
        ListNode.print(getIntersect(n1));
    }
}

package Dec;



public class Day4 {
    //两数相加
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null){
            return  l2;
        }

        if (l2==null){
            return  l1;
        }

        ListNode prev=new ListNode(-1);
        ListNode cur=prev;
        int sum=0;
        int fac=0;

        while (l1!=null||l2!=null){
            int a=l1==null?0:l1.val;
            int b=l2==null?0:l2.val;

            sum=(a+b+fac)%10;
            fac=(a+b+fac)/10;

            ListNode node=new ListNode(sum);
            cur.next=node;
            cur=cur.next;

            l1=l1==null?null:l1.next;
            l2=l2==null?null:l2.next;
        }


        if(fac!=0){
            cur.next=new ListNode(fac);
        }

        return  prev.next;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
package May;

public class Day16 {
    //K 个一组翻转链表
    public ListNode reverseKGroup(ListNode head, int k) {
         ListNode cur=head;
         int len=0;

         while (cur!=null){
             len++;
             cur=cur.next;
         }

         if (len<k){
             return  head;
         }

         ListNode fake=new ListNode(-1);
         ListNode prev,next;
         prev=fake;
         prev.next=head;
         cur=head;

         for(int i=0;i<len/k;i++){
             for(int j=0;j<k-1;j++){
                 next=cur.next;
                 //可以将之前已经逆置的部分看作一个整体
                 cur.next=next.next;
                 next.next=prev.next;
                 prev.next=next;
             }
             prev=cur;
             cur=prev.next;

         }
         return  fake.next;
    }
}

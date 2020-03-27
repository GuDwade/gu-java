import java.util.HashSet;
import java.util.Set;

public class March_27th {
    public static class ListNode {
     int val;
     ListNode next;

     ListNode(int x) {
         val = x;
     }

    }


    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer>set=new HashSet<>();
        ListNode cur=head;
        ListNode prev=null;
        while(cur!=null){
           if(!set.contains(cur.val)){
               set.add(cur.val);
               prev=cur;
           }else{
               prev.next=cur.next;
           }
           cur=cur.next;
        }
        return head;
    }
}

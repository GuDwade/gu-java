package June;

import java.util.HashSet;
import java.util.Set;

public class Day19 {
    // 移除重复节点

    public ListNode removeDuplicateNodes(ListNode head) {
        if(head==null){
            return  head;
        }
        Set<Integer>set=new HashSet<>();
        ListNode cur=head;
        ListNode prev=null;

        while (cur!=null){
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

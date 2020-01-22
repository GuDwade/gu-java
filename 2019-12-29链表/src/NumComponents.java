import java.util.HashSet;
import java.util.Set;

public class NumComponents {
    public static int numComponents(ListNode head, int[] G) {
        Set<Integer> Gset = new HashSet();
        for (int x: G){
            Gset.add(x);
        }
        ListNode cur = head;
        int ret= 0;
        while (cur != null) {
            if (Gset.contains(cur.val) &&(cur.next == null || !Gset.contains(cur.next.val))){
                ret++;
            }
            cur = cur.next;
        }
        return ret;
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(0);
        ListNode n4=new ListNode(3);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        int[]arr={1,2,3};
        System.out.println(numComponents(n1,arr));
    }
}

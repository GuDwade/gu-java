import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 从尾到头打印链表 {
    public int[] reversePrint(ListNode head) {
        if(head == null){
            return new int[]{};
        }
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;

        while(cur != null){
            stack.push(cur.val);
            cur = cur.next;
        }

        int[] rets = new int[stack.size()];
        int idx = 0;
        while(!stack.isEmpty()){
            rets[idx++] = stack.pop();
        }

        return rets;
    }

    public int[] reversePrint1(ListNode head) {
        if (head == null){
            return  new int[]{};
        }
        List<Integer> list = new ArrayList<>();
        dfs(head,list);

        int sz = list.size();
        int[] rets = new int[sz];
        for(int i = 0; i < sz; i++ ){
            rets[i] = list.get(i);
        }

        return  rets;
    }

    private void dfs(ListNode head, List<Integer> list) {
        if (head == null){
            return;
        }
        dfs(head.next,list);
        list.add(head.val);

    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

import java.util.Stack;

public class Day38 {
    //两素相加 逆置链表
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode L1=reserveAndClone(l1);
        ListNode L2=reserveAndClone(l2);

        ListNode head=null;
        ListNode tail=null;
        int sum=0,add=0;

        while(L1!=null||L2!=null){
            int x=L1==null?0:L1.val;
            int y=L2==null?0:L2.val;
            sum=(x+y+add)%10;
            add=(x+y+add)/10;
            ListNode node =new ListNode(sum);
            if(head==null){
                head=node;
                tail=head;
            }else{
                tail.next=node;
                tail=node;
            }
            L1=L1==null?null:L1.next;
            L2=L2==null?null:L2.next;
        }
        if(add==1){
            ListNode node =new ListNode(1);
            tail.next=node;
            tail=node;
        }
        ListNode nHead=reserveAndClone(head);
        return nHead;
    }

    public ListNode reserveAndClone(ListNode head){
        if(head==null){
            return head;
        }

        ListNode prev=null;
        ListNode cur=head;

        while(cur!=null){
            ListNode node=new ListNode(cur.val);
            node.next=prev;
            prev=node;
            cur=cur.next;
        }
        return prev;
    }
    //两数相加 栈
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        Stack<Integer>stack1=new Stack<>();
        Stack<Integer>stack2=new Stack<>();

        while(l1!=null){
            stack1.push(l1.val);
            l1=l1.next;
        }

        while (l2!=null){
            stack2.push(l2.val);
            l2=l2.next;
        }

        ListNode head=null;
        int sum=0;
        int add=0;

        while(!stack1.isEmpty()||!stack2.isEmpty()){
            int x=stack1.isEmpty()?0:stack1.pop();
            int y=stack2.isEmpty()?0:stack2.pop();

            sum=(x+y+add)%10;
            add=(x+y+add)/10;

            ListNode node=new ListNode(sum);
            node.next=head;
            head=node;
        }

        if(add==1){
            ListNode node=new ListNode(1);
            node.next=head;
            head=node;
        }

        return  head;

    }
}

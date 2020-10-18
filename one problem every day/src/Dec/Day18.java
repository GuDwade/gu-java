package Dec;


public class Day18 {
    //删除链表的倒数第N个节点

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return  head;
        }

        ListNode nHead=new ListNode(0);
        nHead.next=head;
        ListNode fast=head;
        ListNode slow=nHead;

        for(int i=0;i<n;i++){
            fast=fast.next;
        }


        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }

        slow.next=slow.next.next;
        return  nHead.next;
    }


    public static int maxLengthBetweenEqualCharacters(String s) {
        int ret=-1;
        for(int i=0;i<s.length()-1;i++){
            char cur=s.charAt(i);
            for(int j=s.length()-1;j>i;j--){
                if(s.charAt(j)==cur){
                    ret=Math.max(ret,j-i-1);
                }
            }
        }
        return  ret;
    }

    public static void main(String[] args) {
        System.out.println(maxLengthBetweenEqualCharacters("aa"));
        System.out.println(maxLengthBetweenEqualCharacters("abca"));
        System.out.println(maxLengthBetweenEqualCharacters("cbzxy"));
    }
}

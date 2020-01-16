public class Continue {
    public static Node partition(Node pHead, int x) {
        if(pHead == null || pHead.next == null)
        {
            return pHead;
        }
        Node big=new Node(1);
        Node bigCur=big;
        Node small=new Node(2);
        Node smallCur=small;
        Node cur=pHead;
        while(cur!=null){
            if(cur.val<x){
                smallCur.next=new Node(cur.val);
                smallCur=smallCur.next;
            }else{
                bigCur.next=new Node(cur.val);
                bigCur=bigCur.next;
            }
            cur=cur.next;
        }
        Node l1=big.next;
        smallCur.next=l1;
        return small.next;
    }

    public static void main(String[] args) {
        Node n1=Practices.bulidList();
        Node n2=Practices.reverseList(n1);
        MyLinkList.print(n2);
        System.out.println();
        MyLinkList.print(partition(n2,4));

    }
}

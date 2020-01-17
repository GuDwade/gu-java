public class AddTwoNumbers {
    public static Node addTwoNumbers(Node l1, Node l2) {
        Node prev=new Node(1);
        Node p=l1;
        Node q=l2;
        Node cur=prev;
        int plus=0;
        while(p!=null||q!=null){
            int x= (p!=null)?p.val:0;
            int y= (q!=null)?q.val:0;
            int sum=x+y+plus;
            plus=sum/10;
            cur.next=new Node(sum%10);
            cur=cur.next;
            if(p!=null){
                p=p.next;
            }
            if(q!=null){
                q=q.next;
            }
        }
        if(plus>0){
            cur.next=new Node(plus);
        }
        return prev.next;
    }

    public static void main(String[] args) {
        Node n1=new Node(9);
        Node n2=new Node(3);
        Node n3=new Node(4);
        n1.next=n2;
        n2.next=n3;
        Node n4=new Node(1);
        Node n5=new Node(6);
        Node n6=new Node(5);
        Node n7=new Node(4);
        n4.next=n5;
        n5.next=n6;
        n6.next=n7;
        MyLinkList.print(addTwoNumbers(n1,n4));
    }
}

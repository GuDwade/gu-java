class Node{
    int val;
    Node next;
    Node(int val){
        this.val=val;
        this.next=null;
    }
}
public class Solution {
    public Node Merge(Node list1,Node list2 ){
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        Node nHead=null;
        Node current=null;
        while(list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                if(nHead==null){
                    nHead=list1;
                    current=list1;
                }else{
                    current.next=list1;
                    current=current.next;
                }
                list1=list1.next;
            }else{
                if(nHead==null){
                    nHead=list2;
                    current=list2;
                }else{
                    current.next=list2;
                    current=current.next;
                }
                list1=list2.next;
            }
        }
        if(list1==null){
            current.next=list2;
        }else{
            current.next=list1;
        }
        return nHead;
    }
}

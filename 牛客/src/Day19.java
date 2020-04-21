import java.util.HashMap;
import java.util.Map;


public class Day19 {
    public int getValue(int[] gifts, int n) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int gift:gifts){
            map.put(gift,map.getOrDefault(gift,0)+1);
        }

        for(Map.Entry<Integer,Integer>es:map.entrySet()){
            if(es.getValue()>=n/2){
                return es.getKey();
            }
        }
        return  0;
    }

    public ListNode partition(ListNode pHead, int x) {
        if(pHead==null){
            return  null;
        }

        ListNode smallHead=null;
        ListNode smallTail=null;

        ListNode bigHead=null;
        ListNode bigTail=null;

        ListNode cur=pHead;
        while (cur!=null){
            if(cur.val<x){
                if(smallHead==null){
                    smallHead=cur;
                }else{
                    smallTail.next=cur;
                }
                smallTail=cur;
            }else{
                if (bigHead==null){
                    bigHead=cur;
                }else{
                    bigTail.next=cur;
                }
                bigTail=cur;
            }
            cur=cur.next;
        }

        if (smallHead==null){
            return  bigHead;
        }
        if (bigHead==null){
            return  smallHead;
        }
        bigTail.next=null;
        smallTail.next=bigHead;
        return  smallHead;
    }
}

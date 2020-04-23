import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day21 {
    //买珠子
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext()){
            String  sale=scan.nextLine();
            String  want=scan.nextLine();
            isBuy(sale,want);
        }
    }

    public static void isBuy(String sale,String want){
        Map<Character,Integer>map=new HashMap<>();
        for(char ch:sale.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int count=0;
        for(char ch:want.toCharArray()){
            Integer num=map.get(ch);
            if (num==null||num==0){
                count++;
            }else{
                map.put(ch,num-1);
            }
        }
        if(count!=0){
            System.out.println("No"+" "+count);
        }else{
            System.out.println("Yes"+" "+(sale.length()-want.length()));
        }
    }

    //链表求和
    public ListNode plusAB(ListNode a, ListNode b) {
        if (a==null){
            return b;
        }
        if (b==null){
            return a;
        }
        ListNode nHead=null;
        ListNode nTail=nHead;
        int sum=0;
        int add=0;

        while (a!=null||b!=null){
            int x=a==null?0:a.val;
            int y=b==null?0:b.val;

            sum=(x+y+add)%10;
            add=(x+y+add)/10;

            ListNode node=new ListNode(sum);
            if (nHead==null){
                nHead=node;
            }else{
                nTail.next=node;
            }
            nTail=node;

            a=a==null?null:a.next;
            b=b==null?null:b.next;
        }
        if (add==1){
            ListNode node=new ListNode(1);
            nTail.next=node;
            nTail=node;
        }

        return  nHead;
    }
}

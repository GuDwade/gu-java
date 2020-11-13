package Nov;

import java.util.ArrayList;
import java.util.List;

public class Day13 {

    public static ListNode oddEvenList(ListNode head) {
        if(head==null ||head.next==null ||head.next.next==null){
            return  head;
        }

        ListNode evenHead=head.next;
        ListNode odd=head ,even=evenHead;

        while (even!=null&&even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }

        odd.next=evenHead;
        return  head;
    }

    public static  ListNode buildList(){
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(5);
        ListNode n6=new ListNode(6);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=null;
        return  n1;
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer>ret =new ArrayList<>();
        if (matrix==null||matrix.length==0||matrix[0].length==0){
            return ret;
        }
        int m=matrix.length;
        int n=matrix[0].length;

        int startX=0;
        int startY=0;
        int endX=m-1;
        int endY=n-1;
        int idx=0;

        while(startX<=endX&&startY<=endY){

            if(startX<=endX){
                for(int i=startY;i<=endY;i++){
                    ret.add(matrix[startX][i]);
                }
            }

            if(startY<=endY){
                for(int i=startX+1;i<=endX;i++){
                    ret.add(matrix[i][endY]);
                }
            }

            if(startX<endX&&startY<endY){
                for(int i=endY-1;i>=startY;i--){
                    ret.add(matrix[endX][i]);
                }
            }

            if(startX<endX&&startY<endY){
                for(int i=endX-1;i>startX;i--){
                    ret.add(matrix[i][startY]);
                }
            }

            startX++;
            startY++;
            endX--;
            endY--;

        }
        return ret;
    }

    public static int removeDuplicates(int[] nums) {
        int i=0;
        for(int n:nums){
            if(i<2||n>nums[i-2]){
                nums[i++]=n;
            }
        }
        return  i;
    }


    public static void main(String[] args) {
        ListNode head=buildList();
        head=oddEvenList(head);
        int []nums={0,0,1,1,1,1,2,3,3};
        removeDuplicates(nums);
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
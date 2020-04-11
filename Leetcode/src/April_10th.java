import java.util.LinkedList;
import java.util.Queue;

public class April_10th {
    public void setZeroes(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        Queue<int[]>queue=new LinkedList<>();

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==0){
                    queue.offer(new int[]{i,j});
                }
            }
        }

        while (!queue.isEmpty()){
            int[]tmp=queue.poll();
            int x=tmp[0];
            int y=tmp[1];

            for(int i=0;i<col;i++){
                matrix[x][i]=0;
            }
            for(int j=0;j<row;j++){
                matrix[j][y]=0;
            }
        }

    }

    public void setZeroes1(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;

        boolean[]Row=new boolean[row];
        boolean[]Col=new boolean[col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==0){
                    Row[i]=true;
                    Col[j]=true;
                }
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(Row[i]==true||Col[j]==true){
                    matrix[i][j]=0;
                }
            }
        }


    }

    public int kthToLast(ListNode head, int k) {

        ListNode cur=head;
        int count=0;

        while (cur!=null){
            count++;
            cur=cur.next;
        }
        cur=head;
        int step=count-k;
        while(step>0){
            step--;
            cur=cur.next;
        }

        return cur.val;
    }

    public int kthToLast1(ListNode head, int k) {
        ListNode fast=head;
        ListNode slow=head;

        while (k>0){
            fast=fast.next;
            k--;
        }

        while (fast!=null){
            slow=slow.next;
            fast=fast.next;
        }

        return  slow.val;
    }
    //删除 node结点
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
	//链表求和
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=null;
        ListNode tail=head;

        int count=0;
        int add=0;

        while (l1!=null||l2!=null){
            int num1=l1==null?0:l1.val;
            int num2=l2==null?0:l2.val;

             count=(num1+num2+add)%10;
             add=(num1+num2+add)/10;

             ListNode node =new ListNode(count);
             if(head==null){
                 head=node;
                 tail=head;
             }else {
                 tail.next=node;
                 tail=tail.next;
             }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;

        }
        if(add==1){
            tail.next=new ListNode(1);
        }
        return  head;

    }

    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode cur=head;
        ListNode next=null;
        while(cur!=null){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }

        return prev;
    }
}

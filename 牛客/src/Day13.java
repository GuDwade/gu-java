import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day13 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n=scanner.nextInt();
            System.out.println(GetsequeueOddNum(n));
        }
    }

    public static String GetsequeueOddNum(int n){
        Queue<Integer>queue=new LinkedList<>();
        int value=n*n*n;
        int sum=0;
        int i=1;
        while(sum!=value){
            while(queue.size()<n){
                sum+=i;
                queue.offer(i);
                i+=2;
            }
            if(sum!=value){
                sum-=queue.poll();
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!queue.isEmpty()){
            sb.append(queue.poll());
            if(!queue.isEmpty()){
                sb.append('+');
            }
        }
        return sb.toString();
    }

    public void make(){
        Scanner scan = new Scanner(System.in);
        int[] num= new int[10];
        for(int i = 0;i <10;i++){
            num[i] = scan.nextInt();
        }

        for(int j=1;j<10;j++) {
            if (num[j] != 0) {
                System.out.print(j);
                num[j] = num[j]-1;
                break;
            }
        }

        for(int k = 0;k <10;k++){
            int sum=num[k];
            while(sum>0){
                System.out.print(k);
                sum--;
            }
        }
    }

}

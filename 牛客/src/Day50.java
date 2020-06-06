import java.util.Scanner;

public class Day50 {
    //左右最小值
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNextInt()){
            int n=scan.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=scan.nextInt();
            }
            int[] left=new int[n];
            left[0]=-1;
            for(int i=1;i<n;i++){
               int j=i-1;
               while (j>=0){
                   if (arr[j]<arr[i]){
                       break;
                   }else{
                       j--;
                   }
               }
               if(j>=0){
                   left[i]=j;
               }else{
                   left[i]=-1;
               }
            }
            int[] right=new int[n];
            right[n-1]=-1;
            for(int i=n-2;i>=0;i--){
                int j=i+1;
                while (j<n){
                    if (arr[j]<arr[i]){
                        break;
                    }else{
                        j++;
                    }
                }
                if (j<n){
                    right[i]=j;
                }else{
                    right[i]=-1;
                }
            }
            for(int i=0;i<n;i++){
                System.out.println(left[i]+" "+right[i]);
            }


        }
    }

    //数组中出现一次的数子
    public void fun(){
        Scanner scan=new Scanner(System.in);
        while (scan.hasNextInt()){
            int n=scan.nextInt();
            int cnt=0;
            int[]arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=scan.nextInt();
                cnt^=arr[i];
            }
            int flag=cnt&(-cnt);
            int left=0,right=0;
            for(int num:arr){
                if ((num&flag)==0){
                    left^=num;
                }else{
                    right^=num;
                }
            }
            if (left<right){
                System.out.println(left+" "+right);
            }else{
                System.out.println(right+" "+left);
            }
        }
    }
}

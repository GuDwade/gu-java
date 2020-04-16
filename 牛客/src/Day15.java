import java.util.Scanner;

public class Day15 {
    //统计成绩
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
         while (scanner.hasNext()){
             int N=scanner.nextInt();
             if(N<=0){
                 break;
             }
             int[]grades=new int[N];
             for(int i=0;i<N;i++){
                 grades[i]=scanner.nextInt();
             }
             int grade=scanner.nextInt();
             int count=0;
             for(int i=0;i<N;i++){
                 if(grades[i]==grade){
                     count++;
                 }
             }
             System.out.println(count);

         }
    }

    //洗牌
    public static void card(){
        Scanner scan=new Scanner(System.in);
        int groups=scan.nextInt();
        while(groups>0){
            int n=scan.nextInt();
            int k=scan.nextInt();
            int[]group=new int[2*n];
            for(int i=0;i<2*n;i++){
                group[i]=scan.nextInt();
            }
            groups--;
            int[]sort=sortCard(group,n,k);
            for(int i=0;i<2*n;i++){
                if(i==2*n-1){
                    System.out.print(sort[i]);
                }else{
                    System.out.print(sort[i]+" ");
                }
            }
            System.out.println();
        }

    }

    public static int[] sortCard(int[]group,int n,int k){
        int[]ret=new int[2*n];
        while(k>0){
            int i=n-1, j=2*n-1;
            for(int l=2*n-1;l>=1;l-=2){
                if(j>=n&&i>=0){
                    ret[l]=group[j--];
                    ret[l-1]=group[i--];
                }
            }
            k--;
            if(k>0){
                group=ret.clone();
            }
        }
        return  ret;
    }
}

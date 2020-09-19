import java.util.Scanner;

public class 米哈游 {
    static int [][]letters;
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNextInt()){
            int m=scan.nextInt();
            int n=scan.nextInt();

            letters=new int[m][n];
            int l=0;
            int r=n-1;
            int u=0;
            int d=m-1;
            int cur='A';
            while (l<r&&u<d){
                for(int i=l;i<=r;i++){
                    letters[u][i]=cur%'A'==0?'A':cur;
                    cur++;
                }
                u++;
                for(int j=u;j<=d;j++){
                    letters[j][r]=cur%'A'==0?'A':cur;
                    cur++;
                }
                r--;

                for(int k=r;k>=0;k--){
                    letters[d][k]=cur%'A'==0?'A':cur;
                    cur++;
                }
                d--;

                for (int h=d;h>=u;h--){
                    letters[h][l]=cur%'A'==0?'A':cur;
                    cur++;
                }
                l++;
            }

            for(int[]arr:letters){
                for(int tmp:arr){
                    System.out.println((char)(tmp));
                }
            }

        }
    }
}

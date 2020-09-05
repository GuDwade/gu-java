import java.util.Scanner;

public class Fourth {
    public static void main(String[] args) {


        Scanner scan=new Scanner(System.in);
        while (scan.hasNextInt()){
            int n=scan.nextInt();
            int m=scan.nextInt();
            int k=scan.nextInt();
            int d=scan.nextInt();
            int[][]num=new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    num[i][j]=scan.nextInt();
                }
            }
            int ret=maxSum(num,n,m,k,d);
        }

    }

    private static int maxSum(int[][] num, int n, int m, int k, int d) {
        int[]clo=new int[n];
        int[]row=new int[m];
        int ret=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                clo[i]+=num[i][j];
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                row[i]+=num[j][i];
            }
        }

        while (k>0){
            int maxCol=-1;
            int maxRow=-1;
            int idxCol=-1;
            int idxRow=-1;

            for(int i=0;i<n;i++){
                if(clo[i]>maxCol){
                    maxCol=clo[i];
                    idxCol=i;
                }
            }

            for(int j=0;j<m;j++){
                if (row[j]>maxRow){
                    maxRow=row[j];
                    idxRow=j;
                }
            }

            if (clo[idxCol]>=row[idxRow]){
                ret+=clo[idxCol];
                clo[idxCol]-=m*d;
                for(int r=0;r<m;r++){
                    row[r]-=d;
                }
            }else{
                ret+=row[idxRow];
                row[idxRow]-=n*d;
                for(int c=0;c<n;c++){
                    clo[c]-=d;
                }
            }
            k--;
        }
        return  ret;
    }
}

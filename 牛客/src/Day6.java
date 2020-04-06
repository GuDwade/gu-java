import java.util.Scanner;

public class Day6 {
    //装蛋糕
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int W=scanner.nextInt();
        int H=scanner.nextInt();
        System.out.println(cakes(W,H));

    }

    public  static int max(int x,int y ){
        return x*y/gcd(x,y);
    }

    public static int gcd(int x,int y ){
        return  y==0?x:gcd(y,x%y);
    }

    public static int cakes(int W,int H){
        int[][] dp=new int[W][H];
        //左 右 上 下
        int[] dx={0,0,-2,2};
        int[] dy={-2,2,0,0};
        int count=W*H;
        for(int i=0;i<W;i++){
            for(int j=0;j<H;j++){
                dp[i][j]=1;
                for(int k=0;k<4;k++){
                    int x=i+dx[k];
                    int y=j+dy[k];
                    if(x>=0&&x<W&&y>=0&y<H&&dp[x][y]==1){
                        dp[i][j]=0;
                        count--;
                        break;
                    }
                }
            }
        }
        return count;
    }
}

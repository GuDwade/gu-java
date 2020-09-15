import java.util.Scanner;

public class DuXiaoMan {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNextLine()){
            int n=scan.nextInt();
            int k=scan.nextInt();
            scan.nextLine();
            char[][]roads=new char[n][];
            for(int i=0;i<n;i++){
                roads[i]=scan.nextLine().toCharArray();
            }
            int[][]dp=new int[n][n];
            dp[0][0]=0;
            for(int i=1;i<n;i++){
                if (roads[0][i]=='1'){
                    break;
                }else if (roads[0][i]=='#'){
                    dp[0][i]=dp[0][i-1]+k;
                }else{
                    dp[0][i]=dp[0][i-1]+1;
                }
            }

            for(int j=1;j<n;j++){
                if (roads[j][0]=='1'){
                    break;
                }else if (roads[j-1][0]=='#'){
                    dp[j][0]=dp[j-1][0]+k;
                }else{
                    dp[j][0]=dp[j-1][0]+1;
                }
            }

            for(int i=1;i<n;i++){
                for(int j=1;j<n;j++){
                    if (roads[i][j]=='1'){
                        dp[i][j]=0;
                    }else if (roads[i][j]=='#'){
                        int up=dp[i-1][j]==0?Integer.MAX_VALUE:dp[i-1][j];
                        int left=dp[i][j-1]==0?Integer.MAX_VALUE:dp[i][j-1];
                        if (up==left&&up==Integer.MAX_VALUE){
                            dp[i][j]=0;
                        }else {
                            dp[i][j]=Math.min(up,left)+k;
                        }
                    }else{
                        int up=dp[i-1][j]==0?Integer.MAX_VALUE:dp[i-1][j];
                        int left=dp[i][j-1]==0?Integer.MAX_VALUE:dp[i][j-1];
                        if (up==left&&up==Integer.MAX_VALUE){
                            dp[i][j]=0;
                        }else {
                            dp[i][j]=Math.min(up,left)+1;
                        }
                    }


                }
            }

            if (dp[n-1][n-1]==0){
                System.out.println("No solution");
            }else{
                System.out.println(dp[n-1][n-1]);
            }

        }
    }

//    private static void dfs(char[][] roads, int x, int y, int times) {
//        if (roads[x][y]=='1'){
//            return;
//        }
//
//        int add=1;
//        if (roads[x][y]=='#'){
//            add=k;
//        }
//        times+=add;
//
//        if (x==n-1&&y==n-1){
//            if (times<sum){
//                sum=times;
//            }
//            return;
//        }
//
//       for(int i=0;i<2;i++){
//            int newX=x+dx[i];
//            int newY=y+dy[i];
//            if(newX>=0&&newX<n&&newY>=0&&newY<n){
//                dfs(roads,newX,newY,times);
//            }
//       }
//
//       times+=add;
//    }


//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        while (scanner.hasNextInt()){
//            long n=scanner.nextInt();
//            long m=scanner.nextInt();
//            long cnt=n*3;
//            long sum=cnt*(cnt+1)/2*m;
//            System.out.println(sum);
//        }
//
//    }
}

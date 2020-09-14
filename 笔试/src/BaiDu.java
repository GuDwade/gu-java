import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaiDu {
//    static int cnt=0;
//    public static void main(String[] args) {
//        Scanner scan=new Scanner(System.in);
//        while (scan.hasNextInt()){
//            int sz=scan.nextInt();
//            int n=scan.nextInt();
//            int[]nums=new int[n];
//            for(int i=0;i<n;i++){
//                nums[i]=scan.nextInt();
//            }
//            Arrays.sort(nums);
//            dfs(nums,0,sz,0);
//            System.out.println(cnt);
//        }
//    }
//
//    private static void dfs(int[] nums,int idx,int sum,int n) {
//        if (sum<0){
//            return;
//        }
//
//        if (sum>=0){
//            if (n>cnt){
//                cnt=n;
//            }
//        }
//
//        for(int i=idx;i<nums.length;i++){
//            sum-=nums[i];
//            dfs(nums, idx+1, sum, n+1);
//            sum-=nums[i];
//        }
//    }
    static int[]dx={-1,1,0,0};
    static int[]dy={0,0,-1,1};
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext()){
            int n=scan.nextInt();
            char[][]roads=new char[n][];
            scan.nextLine();
            for(int i=0;i<n;i++){
                roads[i]=scan.nextLine().toCharArray();
            }

            Queue<int[]>queue=new LinkedList<>();
            for(int i=0;i<n;i++){
                if(roads[0][i]=='0'){
                    roads[0][i]='*';
                    int[]pot=new int[2];
                    pot[0]=0;
                    pot[1]=i;
                    queue.add(pot);
                }

                if (roads[n-1][i]=='0'){
                    roads[n-1][i]='*';
                    int[]pot=new int[2];
                    pot[0]=n-1;
                    pot[1]=i;
                    queue.add(pot);
                }
            }

            for(int j=0;j<n;j++){
                if(roads[j][0]=='0'){
                    roads[j][0]='*';
                    int[]pot=new int[2];
                    pot[0]=j;
                    pot[1]=0;
                    queue.add(pot);
                }

                if(roads[j][n-1]=='0'){
                    roads[j][n-1]='*';
                    int[]pot=new int[2];
                    pot[0]=j;
                    pot[1]=n-1;
                    queue.add(pot);
                }
            }

            while (!queue.isEmpty()){
                int[]arr=queue.poll();
                for(int i=0;i<4;i++){
                    int newX=arr[0]+dx[i];
                    int nexY=arr[1]+dy[i];
                    if (newX>=0&&newX<n&&nexY>=0&&nexY<n&&roads[newX][nexY]=='0'){
                        roads[newX][nexY]='*';
                        queue.add(new int[]{newX,nexY});
                    }
                }

            }

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if (roads[i][j]=='0'){
                        roads[i][j]='1';
                    }
                    if (roads[i][j]=='*'){
                        roads[i][j]='0';
                    }
                }
            }

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(roads[i][j]);
                }
                System.out.println();
            }
        }
    }
}

import java.util.LinkedList;
import java.util.Queue;

public class Day34 {
    //机器人运动范围
    public static int movingCount(int m, int n, int k) {
        int[]dx={1,0};
        int[]dy={0,1};
        //表示可否到达 初始为false 若可以到达改为true
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        Queue<int[]>queue=new LinkedList<>();
        queue.offer(new int[]{0,0});
        int count=1;
        while (!queue.isEmpty()){
            int[]tmp=queue.poll();
            for(int i=0;i<2;i++){
                int x=tmp[0]+dx[i];
                int y=tmp[1]+dy[i];
                if(x<m&&y<n&&isMove(x,y,k)&&!visited[x][y]){
                    //visited[x][y]必须为false才能++   若为true说明可以到达已经++ 不用重复计算
                    count++;
                    visited[x][y]=true;
                    queue.offer(new int[]{x,y});
                }
            }
        }
        return count;

    }
    public  static boolean isMove(int i,int j,int k){
        int sum1=0;
        int sum2=0;
        while(i!=0){
            int x=i%10;
            i=i/10;
            sum1+=x;
        }
        while (j!=0){
            int y=j%10;
            j=j/10;
            sum2+=y;
        }
        return  sum1+sum2<=k;
    }

    public static boolean isSubsequence(String s, String t) {
        int i=0;
        int j=0;
        while(i<s.length()&&j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                i++;
            }
            j++;
        }
        return i==s.length();
    }

    public static boolean isSubsequence1(String s, String t) {
       int idx=-1;
       for(char c:s.toCharArray()){
           //public int indexOf(int ch,int fromIndex)返回指定字符第一次出现的字符串内的索引，以指定的索引开始搜索。
           idx=t.indexOf(c,idx+1);
           if(idx==-1){
               return false;
           }
       }
       return true;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(3,2,17));
    }
}

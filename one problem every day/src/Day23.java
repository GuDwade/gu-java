import java.util.LinkedList;
import java.util.Queue;

public class Day23 {
    //腐烂的橘子
    public int orangesRotting(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        Queue<Integer>queue=new LinkedList<>();
        int count=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    queue.offer(i*n+j);
                }
                if(grid[i][j]==1){
                    count++;
                }
            }
        }

        int time=0;
        while(!queue.isEmpty()&&count>0){
            time++;
            int sz=queue.size();
            for(int k=0;k<sz;k++){
                int p=queue.poll();
                //i表示行 j表示列
                //上一个元素就是 i-1行 j列的元素
                int i=p/n;
                int j=p%n;
                if(j-1>=0&&grid[i][j-1]==1){
                    count--;
                    grid[i][j-1]=2;
                    queue.offer(i*n+j-1);
                }
                if(j+1<n&&grid[i][j+1]==1){
                    count--;
                    grid[i][j+1]=2;
                    queue.offer(i*n+j+1);
                }
                if(i-1>=0&&grid[i-1][j]==1){
                    count--;
                    grid[i-1][j]=2;
                    queue.offer((i-1)*n+j);
                }
                if(i+1<m&&grid[i+1][j]==1){
                    count--;
                    grid[i+1][j]=2;
                    queue.offer((i+1)*n+j);
                }
            }
        }
        return count==0?time:-1;
    }
}

import java.util.LinkedList;
import java.util.Queue;

public class Day39 {
    //0-1矩阵
    //广度优先搜索
    public int[][] updateMatrix(int[][] matrix) {
        int []dx={-1,1,0,0};
        int []dy={0,0,-1,1};
        int m=matrix.length;
        int n=matrix[0].length;

        Queue<int[]>queue=new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    queue.offer(new int[]{i,j});
                }else{
                    matrix[i][j]=-1;
                }
            }
        }

        while (!queue.isEmpty()){
            int[]tmp=queue.poll();
            int x=tmp[0], y=tmp[1];
            for(int k=0;k<4;k++){
                int newX=x+dx[k];
                int newY=y+dy[k];
                if(newX>=0&&newX<m&&newY>=0&&newY<n&&matrix[newX][newY]==-1){
                    matrix[newX][newY]=matrix[x][y]+1;
                    queue.offer(new int[]{newX,newY});
                }
            }
        }
        return matrix;
    }
}

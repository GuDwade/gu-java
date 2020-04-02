import java.util.Arrays;

public class Day28 {
    //复制数组
    public static void gameOfLife(int[][] board) {
        int[]dx={-1,0,1,-1,1,-1,0,1};
        int[]dy={-1,-1,-1,0,0,1,1,1};

        int m=board.length;
        int n=board[0].length;

        int [][]helper=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                helper[i][j]=board[i][j];
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int count=0;
                for(int k=0;k<8;k++){
                    int x=i+dx[k];
                    int y=j+dy[k];
                    if(x>=0 && x<m && y>=0 && y<n && helper[x][y]==1){
                        count++;
                    }
                }
                if(board[i][j]==1){
                    if(count<2||count>3){
                        board[i][j] = 0;
                    }
                }
                if(board[i][j]==0){
                    if(count==3){
                        board[i][j] = 1;
                    }
                }
            }
        }


    }
    //添加复合状态
    public static void gameOfLife1(int[][] board) {
        int[]dx={-1,0,1,-1,1,-1,0,1};
        int[]dy={-1,-1,-1,0,0,1,1,1};

        int m=board.length;
        int n=board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int count=0;
                for(int k=0;k<8;k++){
                    int x=i+dx[k];
                    int y=j+dy[k];
                    if(x>=0 && x<m && y>=0 && y<n && Math.abs(board[x][y])==1){
                        count++;
                    }
                }
                if(board[i][j]==1){
                    if(count<2||count>3){
                        board[i][j] = -1;
                    }
                }
                if(board[i][j]==0){
                    if(count==3){
                        board[i][j] = 2;
                    }
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==-1){
                    board[i][j]=0;
                }
                if(board[i][j]==2){
                    board[i][j]=1;
                }
            }
        }


    }
    public static void main(String[] args) {
        int[][]board={{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        System.out.println(board[0][1]);

    }
}

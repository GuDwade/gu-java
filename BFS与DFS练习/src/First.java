import java.util.*;

public class First {
    public static int numSquares(int n) {
        Queue<Integer>queue=new LinkedList<>();
        queue.offer(0);
        int[]ret=new int[n+1];
        Arrays.fill(ret,Integer.MAX_VALUE);
        ret[0]=0;

        while (!queue.isEmpty()){
            int t=queue.poll();
            if (t==n){
                return ret[t];
            }
            for(int i=1;i*i+t<=n;i++){
                int tmp=t+i*i;
                if (ret[tmp]>ret[t]+1){
                    ret[tmp]=ret[t]+1;
                    queue.offer(tmp);
                }
            }

        }
        return  0;
    }
    //图像渲染
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor){
            return image;
        }
        Queue<int[]>queue=new LinkedList<>();
        queue.offer(new int[]{sr,sc});

        int row=image.length;
        int col=image[0].length;
        int[]dx={-1,1,0,0};
        int[]dy={0,0,-1,1};
        int oddColor=image[sr][sc];

        while (!queue.isEmpty()){
            int[]tmp=queue.poll();
            int x=tmp[0], y=tmp[1];
            image[x][y]=newColor;
            for(int i=0;i<4;i++){
                int newX=tmp[0]+dx[i];
                int newY=tmp[1]+dy[i];

                if(newX>=0&&newX<row&&newY>=0&&newY<col&&image[newX][newY]==oddColor){
                    queue.offer(new int[]{newX,newY});
                }
            }
        }
        return  image;
    }
    //岛屿数量 :统计1的个数 ，遇到一个1就把他相连的所有1全部变为0
    public int numIslands1(char[][] grid) {
        if(grid==null||grid.length==0){
            return 0;
        }
        int res=0;
        int row=grid.length;
        int col=grid[0].length;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if (grid[i][j]=='1'){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return  res;
    }

    private void dfs(char[][] grid, int i, int j) {
        int[]dx={-1,1,0,0};
        int[]dy={0,0,-1,1};

        grid[i][j]='0';
        for(int k=0;k<4;k++){
            int x=i+dx[k],y=j+dy[k];
            if (x>=0&&x<grid.length&&y>=0&&y<grid[0].length&&grid[x][y]=='1'){
                dfs(grid,x,y);
            }
        }
    }

    //被围绕的区域
    public void solve(char[][] board) {
        if (board==null||board.length==0){
            return;
        }
        int row=board.length;
        int col=board[0].length;
        //左右
        for(int i=0;i<row;i++){
            if (board[i][0]=='O'){
                dfsBoard(board,i,0);
            }
            if (board[i][col-1]=='O'){
                dfsBoard(board,i,col-1);
            }
        }

        //上下
        for(int j=0;j<col;j++){
            if(board[0][j]=='O'){
                dfsBoard(board,0,j);
            }
            if(board[row-1][j]=='O'){
                dfsBoard(board,row-1,j);
            }
        }
        //替换 是O说明被完全围绕，是*不能被完全围绕
        for(int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (board[i][j]=='O'){
                    board[i][j]='X';
                }
                if (board[i][j]=='*') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    private void dfsBoard(char[][] board, int i, int j) {
        int[]dx={-1,1,0,0};
        int[]dy={0,0,-1,1};

        board[i][j]='*';
        for(int k=0;k<4;k++){
            int x=i+dx[k],y=j+dy[k];
            if (x>=0&&x<board.length&&y>=0&&y<board[0].length&&board[x][y]=='O'){
                dfsBoard(board,x,y);
            }
        }

    }

    public static void main(String[] args) {
        int a=numSquares(13);
    }
}

package August;


public class Day10 {
    //被围绕的区域

    int[]dx={-1,1,0,0};
    int[]dy={0,0,-1,1};

    public void solve(char[][] board) {

        if(board==null||board.length==0||board.length<=2||board[0].length<=2){
            return;
        }

        int m=board.length;
        int n=board[0].length;

        //左右
        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                dfs(i,0,board);
            }
            if(board[i][n-1]=='O'){
                dfs(i,n-1,board);
            }
        }
        //上下
        for(int j=0;j<n;j++){
            if(board[0][j]=='O'){
                dfs(0,j,board);
            }
            if(board[m-1][j]=='O'){
                dfs(m-1,j,board);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if (board[i][j]=='O'){
                    board[i][j]='X';
                }
                if (board[i][j]=='*'){
                    board[i][j]='O';
                }
            }
        }
    }

    private void dfs(int i, int j, char[][] board) {
        board[i][j]='*';
        for(int k=0;k<4;k++){
            int x=i+dx[k];
            int y=j+dy[k];
            if (x>=0&&x<board.length&&y>=0&&y<board[0].length&&board[x][y]=='O'){
                dfs(x,y,board);
            }
        }
    }
}

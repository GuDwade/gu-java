package August;

public class Day17 {
    //扫雷游戏
    int[]dx={-1,-1,-1,0,0,1,1,1};
    int[]dy={-1,0,1,-1,1,-1,0,1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int x=click[0];
        int y=click[1];
        if (board[x][y]=='M'){
            board[x][y]='X';
        }else{
            dfs(board,x,y);
        }

        return  board;
    }

    private void dfs(char[][] board, int x, int y) {
        int cnt=0;
        for(int i=0;i<8;i++){
            int newX=x+dx[i];
            int newY=y+dy[i];

            if(newX>=0&&newX<board.length&&newY>=0&&newY<board[0].length&&board[newX][newY]=='M'){
                cnt++;
            }
        }
        if (cnt>0){
            board[x][y] = (char)(cnt + '0');
        }else{
            board[x][y]='B';
            for(int i=0;i<8;i++){
                int newX=x+dx[i];
                int newY=y+dy[i];

                if(newX>=0&&newX<board.length&&newY>=0&&newY<board[0].length&&board[newX][newY]=='E'){
                   dfs(board,newX,newY);
                }
            }
        }
    }
}

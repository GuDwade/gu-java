public class Path {

    int n,m;
    int[]dx={-1,1,0,0};
    int[]dy={0,0,-1,1};

    public  boolean exist(char[][] board, String word) {
        if(board==null||board.length==0||board[0].length==0){
            return  false;
        }
        n=board.length;
        m=board[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (dfs(board,i,j,word,0)){
                    return  true;
                }
            }
        }
        return  false;
    }

    private  boolean dfs(char[][] board, int i, int j, String word, int idx) {

        if (board[i][j]!=word.charAt(idx)){
            return  false;
        }
        if (idx==word.length()-1){
            return  true;
        }

        board[i][j]='*';
        for(int k=0;k<4;k++){
            int x=i+dx[k];
            int y=j+dy[k];
            if(x>=0&&x<n&&y>=0&&y<m&board[x][y]!='*'){
                if (dfs(board,x,y,word,idx+1)){
                    return  true;
                }
            }
        }
        board[i][j]=word.charAt(idx);
        return  false;
    }
}

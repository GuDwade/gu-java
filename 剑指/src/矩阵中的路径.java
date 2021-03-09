public class 矩阵中的路径 {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    int n ;
    int m;

    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;

        for(int i = 0; i < n; i++ ){
            for (int j = 0; j < m; j++ ){
                if (board[i][j] == word.charAt(0)){
                    if (dfs(board,i,j,word,0)){
                        return  true;
                    }
                }
            }
        }

        return  false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int idx) {
        if (board[i][j] != word.charAt(idx)){
            return  false;
        }

        if (idx == word.length() - 1){
            return  true;
        }

        board[i][j] = '*';

        for(int k = 0; k < 4; k++ ){
            int x = i + dx[k];
            int y = j + dy[k];

            if (x >= 0 && x < n && y >= 0 && y < m){
                if (dfs(board,x,y,word,idx + 1)){
                    return  true;
                }
            }
        }
        board[i][j] = word.charAt(idx);
        return false;
    }
}

package Sep;

public class Day14 {
    //单词搜索

    int []dx={-1,1,0,0};
    int []dy={0,0,-1,1};
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (dfs(board,word,i,j,0)){
                    return  true;
                }
            }
        }

        return  false;
    }

    private boolean dfs(char[][] board, String word, int i, int j,int idx) {
        if (board[i][j]!=word.charAt(idx)){
            return  false;
        }

        if (idx==word.length()-1){
            return  true;
        }

        board[i][j]='*';

        for(int k=0;k<4;k++){
            int newX=i+dx[k];
            int newY=j+dy[k];

            if (newX>=0&&newX<board.length&&newY>=0&&newY<board[0].length){
                if (dfs(board, word, newX, newY, idx+1)){
                    return  true;
                }
            }
        }

        board[i][j]=word.charAt(idx);
        return  false;
    }

    public static void main(String[] args) {
        Day14 test=new Day14();
        System.out.println(test.exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABF"));
    }
}

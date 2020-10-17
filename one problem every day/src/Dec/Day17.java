package Dec;

import java.util.ArrayList;
import java.util.List;

public class Day17 {
    //N皇后
    List<List<String>>ret=new ArrayList<>();
    boolean[][]board;
    boolean[]col,pie,na;
    int n;
    public List<List<String>> solveNQueens(int n) {
        this.n=n;
        board=new boolean[n][n];
        col=new boolean[n];
        pie=new  boolean[n*2];
        na=new boolean[n*2];
        dfs(0);
        return  ret;
    }

    private void dfs(int i) {
        if (i==n){
            createSolution(board);
            return;
        }

        //遍历当前行的列
        for(int j=0;j<n;j++){
            if (col[j]||pie[i+j]||na[i-j+n]){
                continue;
            }

            board[i][j]=true;
            col[j]=true;
            pie[i+j]=true;
            na[i-j+n]=true;
            dfs(i+1);
            na[i-j+n]=false;
            pie[i+j]=false;
            col[j]=false;
            board[i][j]=false;

        }
    }

    private void createSolution(boolean[][] board) {
        List<String>path=new ArrayList<>();
        for(int i=0;i<n;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<n;j++){
                if (board[i][j]){
                    sb.append('Q');
                }else{
                    sb.append('.');
                }
            }
            path.add(sb.toString());
        }
        ret.add(new ArrayList<>(path));
    }

    public static void main(String[] args) {
        Day17 test=new Day17();
        List<List<String>>list=test.solveNQueens(4);
        for(List<String>l:list){
            System.out.println(l);
        }
    }
}

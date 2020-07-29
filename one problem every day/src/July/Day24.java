package July;

import java.util.ArrayList;
import java.util.List;

public class Day24 {
    /*
    List<Integer> list=new ArrayList<>();
    int []dx={-1,1,0,0};
    int []dy={0,0,-1,1};
    int m,n;
    int max;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0){
            return 0;
        }
        if (matrix.length==1&&matrix[0].length==1){
            return 1;
        }
        max=0;
        m=matrix.length;
        n=matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dfs(matrix,i,j,0);
            }
        }
        return max;
    }

    private void dfs(int[][] matrix, int i, int j,int last) {
        if (last>=matrix[i][j]){
            max=Math.max(max,list.size());
            return;
        }

        list.add(matrix[i][j]);
        matrix[i][j]=-matrix[i][j];
        for(int k=0;k<4;k++){
            int x=i+dx[k];
            int y=j+dy[k];
            if(x>=0&&x<m&&y>=0&&y<n){
                dfs(matrix,x,y,-matrix[i][j]);

            }
        }
        matrix[i][j]=-matrix[i][j];
        list.remove(list.size()-1);
    }
    */
    public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int rows, columns;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        rows = matrix.length;
        columns = matrix[0].length;
        int[][] memo = new int[rows][columns];
        int ans = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                ans = Math.max(ans, dfs(matrix, i, j, memo));
            }
        }
        return ans;
    }

    public int dfs(int[][] matrix, int row, int column, int[][] memo) {
        if (memo[row][column] != 0) {
            return memo[row][column];
        }
        ++memo[row][column];
        for (int[] dir : dirs) {
            int newRow = row + dir[0], newColumn = column + dir[1];
            if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && matrix[newRow][newColumn] > matrix[row][column]) {
                memo[row][column] = Math.max(memo[row][column], dfs(matrix, newRow, newColumn, memo) + 1);
            }
        }
        return memo[row][column];
    }



    public static void main(String[] args) {
        Day24 test=new Day24();
        int i = test.longestIncreasingPath(new int[][]{{9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        });
        int j = test.longestIncreasingPath(new int[][]{{1}});
        System.out.println(j);
    }
}

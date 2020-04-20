import java.util.LinkedList;
import java.util.Queue;

public class Day44 {
    //岛屿数量

    //dfs
    public void dfs(char[][] grid, int r, int c) {
        int row = grid.length;
        int col = grid[0].length;

        if (r < 0 || c < 0 || r >= row || c >= col || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    dfs(grid, r, c);
                }
            }
        }

        return count;
    }

    //bfs
    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        Queue<int[]>queue=new LinkedList<>();

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    grid[i][j]='0';
                    count++;
                    queue.add(new int[]{i,j});
                    while (!queue.isEmpty()){
                        int []tmp=queue.poll();
                        int r=tmp[0],c=tmp[1];
                        if(r-1>=0&&grid[r-1][c]=='1'){
                            grid[r-1][c]='0';
                            queue.add(new int[]{r-1,c});
                        }
                        if(r+1<row&&grid[r+1][c]=='1'){
                            grid[r+1][c]='0';
                            queue.add(new int[]{r+1,c});
                        }
                        if(c-1>=0&&grid[r][c-1]=='1'){
                            grid[r][c-1]='0';
                            queue.add(new int[]{r,c-1});
                        }
                        if(c+1<col&&grid[r][c+1]=='1'){
                            grid[r][c+1]='0';
                            queue.add(new int[]{r,c+1});
                        }
                    }
                }

            }
        }
        return count;
    }
}


import java.util.LinkedList;
import java.util.Queue;

public class 岛屿数量 {

    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};

    boolean[][] isVisted;
    char[][] grid;
    int row;
    int col;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        int count = 0;
        row = grid.length;
        if (row == 0){
            return  0;
        }
        col = grid[0].length;
        isVisted = new boolean[row][col];
        for(int i = 0; i < row; i++ ){
            for(int j = 0; j < col; j++){
                if (grid[i][j] == '1' && !isVisted[i][j]){
                    count++;
                   // dfs(i,j);
                    bfs(i, j);
                }
            }
        }

        return  count;
    }



    private void bfs(int i, int j) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i * col + j );
        isVisted[i][j] = true;

        while (!queue.isEmpty()){
            int idx = queue.poll();

            int x = idx/ col;
            int y = idx % col;


            for(int k = 0; k < 4; k++){
                int newX = x + dx[k];
                int newY = y + dy[k];

                if (newX >= 0 && newX < row && newY >= 0 && newY < col && grid[newX][newY] == '1'&&!isVisted[newX][newY]){
                    queue.offer(newX * newY);
                    isVisted[newX][newY] = true;
                }
            }


        }

    }

    private void dfs(int x, int y) {
        isVisted[x][y] = true;

        for(int i = 0; i < 4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newX < row && newY >= 0 && newY < col && grid[newX][newY] == '1'&&!isVisted[newX][newY]){
                dfs(newX,newY);
            }
        }
    }

    public int numIslands1(char[][] grid) {
        row = grid.length;
        if (row == 0){
            return  0;
        }
        col = grid[0].length;

        int[][] directions = {{1,0},{0,1}};
        UnionFind uf = new UnionFind(row * col);
        int spaces = 0;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if (grid[i][j] == '0'){
                    spaces++;
                }else{
                    for(int[] dir : directions){
                        int x = i + dir[0];
                        int y = j + dir[1];

                        if (x < row && y < col && grid[x][y] == '1'){
                            uf.union(i * col + j, x * col + y);
                        }
                    }
                }
            }
        }

        return  uf.getCount() - spaces;
    }


}

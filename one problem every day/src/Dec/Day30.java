package Dec;

public class Day30 {
    //岛屿的周长

    int [] dx={-1,1,0,0};
    int [] dy={0,0,-1,1};

    public int islandPerimeter(int[][] grid) {
        int n=grid.length, m=grid[0].length;
        int ret=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    for(int k=0;k<4;k++){
                        int x=i+dx[k], y=j+dy[k];
                        if (x<0||x>=n||y<0||y>=m||grid[x][y]==0){
                                ret+=1;
                        }
                    }
                }
            }
        }

        return  ret;
    }


    public int islandPerimeter1(int[][] grid) {
        int n=grid.length, m=grid[0].length;
        int ret=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (grid[i][j]==1){
                    ret+=dfs(i,j,grid,n,m);
                }
            }
        }

        return  ret;
    }

    private int dfs(int x, int y, int[][] grid, int n, int m) {
        if (x<0||x>=n||y<0||y>=m||grid[x][y]==0){
            return  1;
        }

        if (grid[x][y]==2){
            return  0;
        }

        grid[x][y]=2;
        int ret=0;

        for(int k=0;k<4;k++){
            int newX=x+dx[k], newY=y+dy[k];
            ret+=dfs(newX,newY,grid,n,m);
        }

        return  ret;

    }

    public static void main(String[] args) {
        Day30 test=new Day30();
        int [][]gird={
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        };
        System.out.println(test.islandPerimeter1(gird));
    }
}

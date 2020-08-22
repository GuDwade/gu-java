package August;


import java.util.ArrayList;
import java.util.List;

public class Day19 {
    //千位分隔数
    public static String thousandSeparator(int n) {
        String num= String.valueOf(n);
        if(n<1000){
           return  num;
        }
        int idx=num.length()-1;
        StringBuilder sb=new StringBuilder();
        int cnt=0;
        while (idx>=0){
            cnt++;
            sb.append(num.charAt(idx));
            if (cnt%3==0&&idx>0){
                sb.append('.');
            }
            idx--;
        }

        return sb.reverse().toString();
    }

    //二维网格图中探测环
    int m,n;
    List<int[]>list;

    int[]dx={-1,1,0,0};
    int[]dy={0,0,-1,1};
    public boolean containsCycle(char[][] grid) {
         m=grid.length;
         n=grid[0].length;

         for(int i=0;i<m;i++){
             for(int j=0;j<n;j++){
                 list=new ArrayList<>();
                 if(dfs(i,j,grid,grid[i][j])){
                     return  true;
                 }
             }
         }
         return  false;
    }

    private boolean dfs(int i, int j,char[][] grid,char same) {

        if (grid[i][j]!=same){
            return  false;
        }

        list.add(new int[]{i,j});
        grid[i][j]='*';

        if (list.size()>=4){
            int[]start=list.get(0);
            int[]end=list.get(list.size()-1);
            double dis= Math.sqrt(Math.pow(start[0]-end[0],2)+Math.pow(start[1]-end[1],2));
            if (dis==1){
                return true;
            }
        }


        for(int k=0;k<4;k++){
            int x=i+dx[k];
            int y=j+dy[k];
            if (x>=0&&x<m&&y>=0&&y<n){
                if (dfs(x,y,grid,same)){
                    return true;
                }
            }
        }

        list.remove(list.size()-1);
        grid[i][j]=same;
        return  false;
    }

    public static void main(String[] args) {
        Day19 test=new Day19();
        char[][]gird={
                {'c','c','c','a'},
                {'c','d','c','c'},
                {'c','c','e','c'},
                {'f','c','c','c'},
        };
        System.out.println(test.containsCycle(gird));
    }
}

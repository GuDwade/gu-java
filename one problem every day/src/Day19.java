public class Day19 {
    //三维形体的表面积
    public int surfaceArea(int[][] grid) {
        int len=grid.length;
        int area=0;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                int count=grid[i][j];        //放置的方块个数
                if(count>0){
                    area+=count*4+2;         //个数乘以4个侧面+上下底面

                    if(i>0){
                        area-=Math.min(count,grid[i-1][j])*2; //计算i方向上重叠的部分 重叠一个减少两个面
                    }

                    if(j>0){
                        area-=Math.min(count,grid[i][j-1])*2;  //计算j方向上重叠的部分
                    }

                }
            }
        }
        return area;
    }
}

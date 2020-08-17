package August;

import java.util.LinkedList;
import java.util.Queue;

public class Day13 {

    //图像渲染
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oddColor=image[sr][sc];
        if (oddColor==newColor){
            return  image;
        }
        Queue<int[]>queue=new LinkedList<>();
        queue.add(new int[]{sr,sc});
        int[]dx={-1,1,0,0};
        int[]dy={0,0,1,-1};

        while (!queue.isEmpty()){
            int[]arr=queue.poll();
            int x=arr[0];
            int y=arr[1];
            image[x][y]=newColor;
            for(int i=0;i<4;i++){
                int newX=x+dx[i];
                int newY=y+dy[i];
                if (newX>=0&&newX<image.length&&newY>=0&&newY<image[0].length&&image[newX][newY]==oddColor){
                    queue.add(new int[]{newX,newY});
                }
            }
        }

        return  image;
    }
}

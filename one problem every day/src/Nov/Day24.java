package Nov;

import java.util.Arrays;

public class Day24 {
	
	// 用最少数量的箭引爆气球
    public static int findMinArrowShots(int[][] points) {

        if (points == null || points.length == 0){
            return  0;
        }
        Arrays.sort(points,(a,b) -> {
            return  a[1] - b[1];
        });

        int right = points[0][1];
        int count = 1;

        for(int i = 1; i < points.length; i++) {
            if (right < points[i][0]) {
                right = points[i][1];
                count++;
            }
        }

        return  count;
    }

    public static void main(String[] args) {
        findMinArrowShots(new int[][]{
                {10,16},{2,8},{1,6},{7,12}
        });
    }
}

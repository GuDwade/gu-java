package Nov;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Day17 {
    // 根据身高重建队列

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(o1,o2)->{
            return o1[0]==o2[0]?o1[1]-o2[1]:o2[0]-o1[0];
        });

        List<int[]>ret=new LinkedList<>();
        for(int []peo:people){
            ret.add(peo[1],peo);
        }
        return  ret.toArray(new int[people.length][2]);
    }

    public static void main(String[] args) {
        int [][]arr=reconstructQueue(new int[][]{
                {7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}
        });
    }
}

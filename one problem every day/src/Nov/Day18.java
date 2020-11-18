package Nov;

import java.util.*;

public class Day18 {
    //距离顺序排列矩阵单元格

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        List<int[]> roads =new LinkedList<>();
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
               int []arr=new int[]{i,j};
               roads.add(arr);
            }
        }

        Collections.sort(roads,(o1, o2) ->{
            int x1=Math.abs(o1[0]-r0)+Math.abs(o1[1]-c0);
            int x2=Math.abs(o2[0]-r0)+Math.abs(o2[1]-c0);
            return  x1-x2;
        });

        return  roads.toArray(new int[R*C][2]);
    }

    public int[][] allCellsDistOrder1(int R, int C, int r0, int c0) {
        int [][] rets =new int[R*C][2];
        int idx=0;

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                int []arr=new int[]{i,j};
                rets[idx++]=arr;
            }
        }
        Arrays.sort(rets,(o1,o2)->{
            int x1=Math.abs(o1[0]-r0)+Math.abs(o1[1]-c0);
            int x2=Math.abs(o2[0]-r0)+Math.abs(o2[1]-c0);
            return  x1-x2;
        });

        return  rets;
    }

    //桶排序
    public int[][] allCellsDistOrder2(int R, int C, int r0, int c0) {
        int max=Math.max(r0,R-1-r0)+Math.max(c0,C-1-c0);
        List<LinkedList<int[]>> lists =new ArrayList<>(max+1);
        for(int i=0;i<=max;i++){
            lists.add(new LinkedList<>());
        }

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                int []arr={i,j};
                int dist=Math.abs(i-r0)+Math.abs(j-c0);
                lists.get(dist).add(arr);
            }
        }

        int [][]rets=new int[R*C][];
        int idx=0;
        for(LinkedList<int[]>list:lists){
            if (list==null){
                continue;
            }
            for(int[]arr:list){
                rets[idx++]=arr;
            }
        }

        return  rets;
    }
}

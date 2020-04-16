import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day40 {
	//合并重复区间
    public int[][] merge(int[][] intervals) {
        if(intervals.length<2){
            return  intervals;
        }

        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]>list=new ArrayList<>();

        int i;
        for(i=0;i<intervals.length-1;i++){
            if(intervals[i][1]>=intervals[i+1][0]){
                intervals[i+1][0]=intervals[i][0];
                intervals[i+1][1]=Math.max(intervals[i][1],intervals[i+1][1]);
            }else{
                list.add(intervals[i]);
            }
        }
        //如果最后两个不能合并 两个都添加   可以合并最后一个变为合并后的区间 加入进去
        list.add(intervals[i]);
        //return list.toArray(new int[list.size()][2]);
        int[][]ret=new int[list.size()][];
        for(int j=0;j<list.size();j++){
            ret[j]=list.get(j);
        }
        return  ret;
    }
}

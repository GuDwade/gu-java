package June;

public class Day8 {
    //每日温度
    public int[] dailyTemperatures(int[] T) {
        int[]ret=new int[T.length];
        for (int i=0;i<T.length;i++){
            int j=i+1;
            for(;j<T.length;j++){
                if (T[j]>T[i]){
                    break;
                }
            }
            if (j==T.length){
                ret[i]=0;
            }else{
                ret[i]=j-i;
            }
        }
        return  ret;
    }
}

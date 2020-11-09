package Nov;

import java.util.Arrays;

public class Day9 {

    //最接近原点的 K 个点

    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points,((a,b)->{
            return  myPow(a)-myPow(b);
        } ));
        int [][]ret=new int[K][2];
        for(int i=0;i<K;i++){
            ret[i][0]=points[i][0];
            ret[i][1]=points[i][1];
        }
        return  ret;
    }

    private int myPow(int[] a) {
        return  a[0]*a[0]+a[1]*a[1];
    }


    public int[][] kClosest1(int[][] points, int K) {
        for(int i=(points.length-2)/2;i>=0;i--){
            shiftDown(points,i,points.length);
        }

        int len=points.length;
        for(int i=0;i<K;i++){
            swap(points,0,len-1-i);
            shiftDown(points,0,len-1-i);
        }
        int [][] ret=new int[K][2];

        int idx=0;
        while (idx<K){
            ret[idx][0]=points[len-1-idx][0];
            ret[idx][1]=points[len-1-idx][1];
            idx++;
        }

        return  ret;
    }

    private void shiftDown(int[][] points, int idx, int len) {
        int left=idx*2+1;
        while (left<len){
            int min=left;
            int right=idx*2+2;
            if (right<len){
                if (myPow(points[right])<myPow(points[left])){
                    min=right;
                }
            }

            if (myPow(points[idx])<myPow(points[min])){
                break;
            }

            swap(points,idx,min);
            idx=min;
            left=idx*2+1;
        }
    }

    private void swap(int[][] points, int idx, int min) {
        int tmp0=points[min][0];
        int tmp1=points[min][1];

        points[min][0]=points[idx][0];
        points[min][1]=points[idx][1];

        points[idx][0]=tmp0;
        points[idx][1]=tmp1;

    }


    public static void main(String[] args) {
        Day9 test=new Day9();
        test.kClosest1(new int[][]{{3,3},{5,-1},{-2,4}},2);
    }
}

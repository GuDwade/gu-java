package Dec;

public class Day16 {
    //有序数组的平方
    public static int[] sortedSquares(int[] A) {
        int n=A.length;
        int start=0;
        while (start<n&&A[start]<0){
            start++;
        }

        int []ret=new int[n];
        int l=start-1, r=start,idx=0;

        while (l>=0&&r<n){
            if (A[r]<=-A[l]){
                ret[idx++]=A[r]*A[r];
                r++;
            }else{
                ret[idx++]=A[l]*A[l];
                l--;
            }
        }

        while (l>=0){
            ret[idx++]=A[l]*A[l];
            l--;
        }

        while (r<n){
            ret[idx++]=A[r]*A[r];
            r++;
        }

        return  ret;
    }

    public static void main(String[] args) {
        System.out.println(sortedSquares(new int[]{-4, -1, 0, 3, 10}));
    }

}

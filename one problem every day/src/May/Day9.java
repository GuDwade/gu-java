package May;

public class Day9 {

    //平方根

    public int mySqrt(int x) {
        int left=0;
        int right=x;

        while(left<right){
            int mid=left+right+1>>1;
            if(mid<=x/mid){
                left=mid;
            }else{
                right=mid-1;
            }
        }

        return left;
    }
}

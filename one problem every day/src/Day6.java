public class Day6 {
    //将数组分成和相等的三部分
    public static boolean canThreePartsEqualSum(int[] A) {
        int sum=0;
        for(int val:A){
            sum+=val;
        }
        //如果和不是3的倍数 也不能均分为3部分
        if(sum%3!=0){
            return false;
        }
        int targert=sum/3;
        int count=0;
        int start=0;
        int leftsum=0;
        while(start<A.length){
            leftsum+=A[start];
            if(leftsum==targert){
                leftsum=0;
                count++;
            }
            start++;
        }
        //和等于0的时候可能会被分成3份或更多
        return count==3||(sum==0&&count>=3);
    }
    public static boolean canThreePartsEqualSum1(int[] A) {
        int sum=0;
        for(int val:A){
            sum+=val;
        }
        //如果和不是3的倍数 也不能均分为3部分
        if(sum%3!=0){
            return false;
        }
        int targert=sum/3;
        int start=0;
        int end=A.length-1;
        int leftSum=0;
        int rightSum=0;
        while(start<end){
            leftSum+=A[start];
            if(leftSum!=targert){
                start++;
            }else{
                break;
            }
        }
        //使中间部分可以至少有一个
        while(end>start+1){
            rightSum+=A[end];
            if (rightSum!=targert){
                end--;
            }else{
                break;
            }
        }
        return rightSum==targert&&leftSum==targert;
    }

    public static void main(String[] args) {
        int[]arr={10,-10,10,-10,-10,10,10,-10};
        System.out.println(canThreePartsEqualSum(arr));
        System.out.println(canThreePartsEqualSum1(arr));
    }
}

package Dec;

public class Day25 {
	//数组中的最长山脉
    public static int longestMountain1(int[] A) {
        int ret=0;
        for(int i=0;i<A.length-1;i++){
            int l =i+1;

            if (A[l]<=A[i]){
                continue;
            }

            while (l<A.length&&A[l]>A[l-1]){
                l++;
            }

            int r=l;

            if(r>=A.length){
                continue;
            }

            while (r<A.length&&A[r]<A[r-1]){
                r++;
            }

            if(r==l){
                continue;
            }

            ret=Math.max(ret,r-i);

        }


        return  ret;
    }

    public static int longestMountain(int[] A) {
        if(A==null||A.length==0){
            return  0;
        }
        int len=A.length;
        int []left=new int[len];
        left[0]=0;

        for(int i=1;i<A.length;i++){
            if (A[i]>A[i-1]){
                left[i]=left[i-1]+1;
            }
        }

        int []right=new int[len];
        right[len-1]=0;

        for(int i=len-2;i>=0;i--){
            if (A[i]>A[i+1]){
                right[i]=right[i+1]+1;
            }
        }

        int max=0;
        for(int i=0;i<len;i++){
            if (left[i]!=0&&right[i]!=0){
                max=Math.max(max,left[i]+right[i]+1);
            }
        }

        return  max;
    }

    public static void main(String[] args) {
        System.out.println(longestMountain(new int[]{0,2,3}));
    }
}

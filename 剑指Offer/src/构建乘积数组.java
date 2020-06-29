import java.util.Arrays;

public class 构建乘积数组 {
    public static int[] constructArr(int[] a) {
        if(a==null||a.length==0){
            return  a;
        }
        int n=a.length;
        int[]left=new int[n];
        left[0]=1;
        for(int i=1;i<n;i++){
            left[i]=left[i-1]*a[i-1];
        }
        System.out.println(Arrays.toString(left));
        int[] right=new int[n];
        right[n-1]=1;
        for(int i=n-2;i>=0;i--){
            right[i]=right[i+1]*a[i+1];
        }
        System.out.println(Arrays.toString(right));
        int[]ret=new int[n];
        for(int i=0;i<n;i++){
            ret[i]=left[i]*right[i];
        }

        return  ret;

    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(constructArr(new int[]{1, 2, 3, 4, 5}))
        );
    }


}

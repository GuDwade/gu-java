import java.util.Arrays;

public class Day6 {
    public static int[] sortedSquares(int[] A) {
        int []ret=new int[A.length];
        for(int i=0;i< ret.length;i++){
            ret[i]=A[i]*A[i];
        }
        Arrays.sort(ret);
        return ret;
    }
    public static String reverseOnlyLetters(String S) {
        char[]tmp=S.toCharArray();
        int left=0;
        int right=S.length()-1;
        while(left<right){
            while(!isLetters(tmp[left])&&left<right){
                left++;
            }
            while(!isLetters(tmp[right])&&left<right){
                right--;
            }
            char t=tmp[left];
            tmp[left]=tmp[right];
            tmp[right]=t;
            left++;
            right--;
        }
        return new String(tmp);
    }
    public static boolean isLetters(char c){
        if((c>='A'&&c<='Z')||(c>='a'&&c<='z')){
            return  true;
        }
        return  false;
    }

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("asvghda65dW8932E6"));
        int[]test={-3,6,3,2,9};
        System.out.println(Arrays.toString(sortedSquares(test)));
    }
}

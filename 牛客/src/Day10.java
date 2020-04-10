import java.util.Arrays;
import java.util.Scanner;

public class Day10 {
    public static void main(String[] args) {
        //countOfNumber();
        int[]arr=multiply(new int[]{1,2,3,4,5});
        System.out.println(Arrays.toString(arr));
    }

    public static void countOfNumber(){
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        for(int i=0;i<=9;i++){
            int count=0;
            for(char c:str.toCharArray()){
                if(c-'0'==i){
                    count++;
                }
            }
            if(count>0){
                System.out.println(i+":"+count);
            }
        }
    }

    //构建乘积数组
    public static int[] multiply(int[] A) {
        int n=A.length;
        int[]B=new int[n];
        int[]left=new int[n];        //ledt[i]表示A[i]左边所有数的乘机
        int[]right=new int[n];      //right[i]表示A[i]右边所有数的乘机

        left[0]=1;
        for(int i=1;i<n;i++){
            left[i]=left[i-1]*A[i-1];
        }

        right[n-1]=1;
        for(int j=n-2;j>=0;j--){
            right[j]=right[j+1]*A[j+1];
        }

        for(int k=0;k<n;k++){
            B[k]=left[k]*right[k];
        }

        return B;
    }
}

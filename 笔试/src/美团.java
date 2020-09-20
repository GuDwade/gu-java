import java.util.Arrays;
import java.util.Scanner;

public class 美团 {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNextInt()){
            int n=scan.nextInt();
            int nums[]=new int[n];
            for(int i=0;i<n;i++){
                nums[i]=scan.nextInt();
            }
            boolean flag=false;
            for(int i=0;i<n;i++){
                if (nums[i]%2==0||nums[i]>n){
                    flag=true;
                    break;
                }
            }
            if (flag){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
        }
    }
}

//    public static void main(String[] args) {
//        Scanner scan=new Scanner(System.in);
//        while (scan.hasNextInt()){
//            int n=scan.nextInt();
//            int p=scan.nextInt();
//            int q=scan.nextInt();
//            int[]a=new int[p];
//            for(int i=0;i<p;i++){
//                a[i]=scan.nextInt();
//            }
//
//            int[]b=new int[q];
//            for(int j=0;j<q;j++){
//                b[j]=scan.nextInt();
//            }
//            int both=0;
//            Arrays.sort(a);
//            Arrays.sort(b);
//            int i=0,j=0;
//            while (i<p&&j<q){
//                if (a[i]<b[j]){
//                    i++;
//                }else if (a[i]==b[j]){
//                    i++;
//                    j++;
//                    both++;
//                }else if (a[i]>b[j]){
//                    j++;
//                }
//            }
//            System.out.print((p-both)+" "+(q-both)+" "+both);
//        }
//    }
//    public static void main(String[] args) {
//        Scanner scan=new Scanner(System.in);
//        while (scan.hasNextLine()){
//            String str=scan.nextLine();
//            int[]up=new int[26];
//            int[]low=new int[26];
//            for(int i=0;i<str.length();i++){
//                char cur=str.charAt(i);
//                if (cur>='A'&&cur<='Z'){
//                    up[cur-'A']++;
//                }
//                if (cur>='a'&&cur<='z'){
//                    low[cur-'a']++;
//                }
//            }
//            int upCnt=0;
//            for(int num:up){
//                upCnt+=num;
//            }
//
//
//            System.out.println(Math.abs(upCnt-str.length()/2));
//        }
//    }


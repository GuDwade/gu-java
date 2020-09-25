import java.util.Arrays;
import java.util.Scanner;

public class San60 {
//    public static void main(String[] args) {
//        Scanner scan =new Scanner(System.in);
//        while (scan.hasNextLine()){
//            String str=scan.nextLine();
//            boolean flag=judge(str);
//            if(flag){
//                System.out.println();
//            }else{
//                System.out.println();
//            }
//        }
//    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNextInt()){
            int n=scan.nextInt();
            int m=scan.nextInt();
            boolean []isId=new boolean[n+1];
            Arrays.fill(isId,true);
            int [][]cards=new int[m][2];
            for(int i=0;i<m;i++){
                for(int j=0;j<2;j++){
                    cards[i][j]=scan.nextInt();
                }
            }
            int one=0;
            for(int i=0;i<m;i++){
                if (cards[i][1]==0){
                    if (one>0){
                        isId[cards[i][0]]=false;
                    }
                }

                if (cards[i][1]==1){
                    one++;
                    if(i!=1){
                        isId[cards[i][0]]=false;
                    }
                }
            }

            for(int i=1;i<=n;i++){
                if (isId[i]){
                    System.out.print(i);
                    if (i!=n){
                        System.out.print(" ");
                    }
                }
            }

        }


    }

    private static boolean judge(String str) {
        if (str.length()<8){
            return  false;
        }

        int a=0,b=0,c=0,d=0;

        for(char cur:str.toCharArray()){
            if(cur>='A'&&cur<='Z'){
                if (a==0){
                    a++;
                }
            }else if(cur>='a'&&cur<='z'){
                if(b==0){
                    b++;
                }
            }else if(cur>='0'&&cur<='9'){
                if(c==0){
                    c++;
                }
            }else{
                if (d==0){
                    d++;
                }
            }
        }

        return  a+b+c+d>=4;

    }
}

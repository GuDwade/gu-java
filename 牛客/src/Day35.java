import java.util.Scanner;

public class Day35 {

    //上台阶
    public static int countWays1(int n) {
        if(n<=1){
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n==3){
            return  4;
        }
        int a=1,b=2,c=4;
        for(int i=4;i<=n;i++){
            int tmp=((a+b)%1000000007+c)%1000000007;
            a=b;
            b=c;
            c=tmp;
        }
        return  c;
    }

    //剪刀石头布
    static int aWin,aTie,aLost,aC,aJ,aB;
    static int bWin,bTie,bLost,bC,bJ,bB;
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        int n=scan.nextInt();
        for (int i=0;i<n;i++){
            char A=scan.next().charAt(0);
            char B=scan.next().charAt(0);
            compare(A,B);
        }

        System.out.println(aWin+" "+aTie+" "+aLost);
        System.out.println(bWin+" "+bTie+" "+bLost);

        if(aC>aB&&aC>=aJ){
            System.out.print('C');
        }else if(aC<=aB&&aB>=aJ){
            System.out.print('B');
        }else if(aJ>aB&&aJ>aC){
            System.out.print('J');
        }
        System.out.print(' ');
        if(bC>bB&&bC>=bJ){
            System.out.print('C');
        }else if(bC<=bB&&bB>=bJ){
            System.out.print('B');
        }else if(bJ>bB&&bJ>bC){
            System.out.print('J');
        }

    }



    private static void compare(char a, char b) {
        if (a==b){
            aTie++;
            bTie++;
        }

        if(a=='C'){
            if (b=='J'){
                aWin++;
                aC++;
                bLost++;
            }
            if (b=='B'){
                aLost++;
                bWin++;
                bB++;
            }
        }

        if (a=='J'){
            if (b=='C'){
                bWin++;
                bC++;
                aLost++;
            }
            if (b=='B'){
                aWin++;
                aJ++;
                bLost++;
            }
        }
        if (a=='B'){
            if(b=='C'){
                aWin++;
                aB++;
                bLost++;
            }
            if(b=='J'){
                bWin++;
                aLost++;
                bJ++;
            }
        }
    }

}

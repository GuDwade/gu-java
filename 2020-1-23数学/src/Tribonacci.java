public class Tribonacci {
    public static int tribonacci(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 1;
        }
        return tribonacci(n-3)+tribonacci(n-2)+tribonacci(n-1);
    }

    public static int tribonacci1(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 1;
        }
        int  a=0,b=0,c=1,d=1;
        for(int i=3;i<=n;i++){
            a=b;
            b=c;
            c=d;
            d=a+b+c;
            //向后移动
        }
        return d;
    }
    public static void main(String[] args) {
        System.out.println(tribonacci(20));
        System.out.println(tribonacci1(20));
    }
}

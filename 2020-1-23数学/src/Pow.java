public class Pow {
    public static double myPow(double x, int n) {
        long N=n;
        if(N<0){
            x=1/x;
            N=-N;
        }
        double ret=1;
        for(long i=0;i<N;i++){
            ret=ret*x;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.5,3));
    }
}

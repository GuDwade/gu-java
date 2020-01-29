public class Ugly {
    public static boolean isUgly(int num) {
        if(num<1){
            return false;
        }
        while(num!=1){
            if(num%2==0){
                num=num/2;
                continue;
            }
            if(num%3==0){
                num=num/3;
                continue;
            }
            if(num%5==0){
                num=num/5;
                continue;
            }
            return false;

        }
        return true;
    }

    public static int nthUglyNumber(int n) {
        if(n==1){
            return 1;
        }
        int[]ret=new int[n];
        int n2=0;
        int n3=0;
        int n5=0;
        ret[0]=1;
        for(int i=1;i<n;i++){
            int x2=ret[n2]*2;
            int x3=ret[n3]*3;
            int x5=ret[n5]*5;
            int min=Math.min(x2,Math.min(x3,x5));
            ret[i]=min;
            if(min==x2){
                n2++;
            }
            if(min==x3){
                n3++;
            }
            if(min==x5){
                n5++;
            }
        }
        return ret[n-1];
    }
    public static void main(String[] args) {
        System.out.println(isUgly(30));
        System.out.println(nthUglyNumber(10));
    }
}

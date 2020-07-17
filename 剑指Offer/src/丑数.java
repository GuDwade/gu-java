public class 丑数 {
    //三指针
    public int nthUglyNumber(int n) {
        if(n==1){
            return 1;
        }

        int[]ret=new int[n];
        ret[0]=1;
        int n2=0;
        int n3=0;
        int n5=0;

        for(int i=1;i<n;i++){
            int x2=ret[n2]*2;
            int x3=ret[n3]*3;
            int x5=ret[n5]*5;

            int min=Math.min(Math.min(x2,x3),x5);

            if(min==x2){
                n2++;
            }

            if(min==x3){
                n3++;
            }

            if(min==x5){
                n5++;
            }

            ret[i]=min;
        }

        return ret[n-1];

    }
}

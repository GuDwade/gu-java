public class IntegerReplacement {
    public static int integerReplacement(int n) {
        int ans = 0;
        while(n!=1){
            if((n&1)==0){
                n=n>>>1;
                ans++;
            }else{
                if(n==3){
                    n--;
                }else if((n&2)==2){
                    n++;
                }else{
                    n--;
                }
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(integerReplacement(8));
    }
}

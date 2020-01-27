public class IsPerfectSquare {
    public static boolean isPerfectSquare(int num) {
        if(num<2){
            return true;
        }
        long left=2;
        long right=num/2;
        long square=0;
        long x=0;
        while(left<=right){
            x=left+(right-left);
            square=x*x;
            if(square==num){
                return true;
            }else if(square>num){
                right--;
            }else{
                left++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(14));
        System.out.println(isPerfectSquare(625));
    }
}

public class IsPalindrome {
    public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int ret=0;
        int tmp=0;
        int cur=x;
        while(cur!=0){
            ret=cur%10;
            tmp=tmp*10+ret;
            cur=cur/10;
        }
        return tmp==x;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(0));
    }
}

package June;

public class Day7 {
    //回文数
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }

        int newNum=0;
        int cur=x;
        while(cur!=0){
            int tmp=cur%10;
            newNum=newNum*10+tmp;
            cur/=10;
        }

        return newNum==x;
    }
}

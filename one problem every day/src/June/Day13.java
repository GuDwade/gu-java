package June;

public class Day13 {
    //验证回文串
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int i=0;
        int j=s.length()-1;
        while(i<j){
            while(i<j&&!isLetterAndSum(s.charAt(i))){
                i++;
            }
            while(i<j&&!isLetterAndSum(s.charAt(j))){
                j--;
            }
            if(i<j){
                if(s.charAt(i)!=s.charAt(j)){
                    return false;
                }else{
                    i++;
                    j--;
                }
            }
        }
        return true;
    }
    public boolean isLetterAndSum(char c){
        if(c>='a'&&c<='z'||c>='0'&&c<='9'){
            return true;
        }else{
            return  false;
        }
    }
}

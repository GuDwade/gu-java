package May;

public class Day17 {
    //验证回文字符串 Ⅱ 可以删去一个字符
    public boolean validPalindrome(String s) {
        int left=0;
        int right=s.length()-1;
        while(left<right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }else{
                boolean flag1=true,flag2=true;
                for(int i=left,j=right-1;i<j;i++,j--){
                    if(s.charAt(i)!=s.charAt(j)){
                        flag1=false;
                        break;
                    }
                }
                for(int i=left+1,j=right;i<j;i++,j--){
                    if(s.charAt(i)!=s.charAt(j)){
                        flag2=false;
                        break;
                    }
                }
                return flag1||flag2;
            }
        }
        return true;
    }
}

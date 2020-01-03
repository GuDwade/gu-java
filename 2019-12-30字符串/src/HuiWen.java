public class HuiWen {
    public static boolean isPalindrome(String s) {
        if (s.isEmpty()){
            return true;
        }
        s = s.toLowerCase();
        StringBuilder str = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                str.append(c);
            }
        }
        return str.toString().equals(str.reverse().toString());
    }
    public static boolean isPalindrome1(String s){
        if(s.isEmpty()){
            return true;
        }
        char[]ch=s.toCharArray();
        int sz=ch.length;
        for(int i=0;i<sz/2;i++){
            if(ch[i]!=ch[sz-1-i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome("abba"));
        System.out.println(isPalindrome1("上海海上"));
    }
}

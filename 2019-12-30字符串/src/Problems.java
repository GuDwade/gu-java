public class Problems {
    public static void reverseString(char[] s) {
        int sz=s.length;
        for(int i=0;i<sz/2;i++){
            char tmp=s[i];
            s[i]=s[sz-i-1];
            s[sz-i-1]=tmp;
        }
    }
    public static boolean isVewel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
    public static String reverseVowels(String s) {
        if(s.isEmpty()){
            return s;
        }
        char[]ch=s.toCharArray();
        int left=0;
        int right=s.length()-1;
        while(left<right){
            if(!isVewel(ch[left])){
                left++;
            }
            if(!isVewel(ch[right])){
                right--;
            }
            if(isVewel(ch[left])&&isVewel(ch[right])){
                char tmp=ch[left];
                ch[left]=ch[right];
                ch[right]=tmp;
                left++;
                right--;
            }
        }

        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        String str="gegegogo";
        System.out.println(reverseVowels(str));
    }
}

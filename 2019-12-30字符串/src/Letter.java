public class Letter {
    public static String reverseOnlyLetters(String s) {
        char[]result=s.toCharArray();
        int left=0;
        int right=result.length-1;
        while(left<right){
            while(!isLetters(result[left])&& left < right){
                left++;
            }
            while(!isLetters(result[right])&& left < right){
                right--;
            }
            char tmp=result[left];
            result[left]=result[right];
            result[right]=tmp;
            left++;
            right--;
        }
        return new String(result);
    }
    public static boolean isLetters(char c){
        if((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
            return true;
        }
        return false;
    }
    public static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
            return true;
        }
        return false;
    }
    public static String dropOnlyVowel(String s){
        char[] c=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        for(char i:c){
            if(!isVowel(i)){
                sb.append(i);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(dropOnlyVowel("asdghfauwefysg"));
        System.out.println(reverseOnlyLetters("ab8cdaskjdag_dgha"));
    }

}

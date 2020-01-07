public class Homework {
    
    public int compareTo(String s1, String s2){
        int shortLen = (s1.length()>=s2.length())?s2.length():s1.length();
        for(int i = 0; i < shortLen; i++){
            if(s1.charAt(i) > s2.charAt(i)){
                return 1;
            }
            if(s1.charAt(i) < s2.charAt(i)){
                return -1;
            }
        }
        if(s1.length() == s2.length()){
            return 0;
        }
        return (s1.length() - s2.length() > 0) ? 1 : -1;
    }

    public boolean contains(String s1, String s2){
        int count = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) == s2.charAt(0)){
                for(int j = 0; j < s2.length(); j++){
                    if(i + j < s1.length()) {
                        if (s1.charAt(i + j) != s2.charAt(j)) {
                            break;
                        }
                        count++;
                    }
                }
                if(count == s2.length()){
                    return true;
                }
            }
        }
        return false;
    }

    public int IndexOf(String s1, String s2){
        int count = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) == s2.charAt(0)){
                for(int j = 0; j < s2.length(); j++){
                    if(i + j < s1.length()) {
                        if (s1.charAt(i + j) != s2.charAt(j)) {
                            break;
                        }
                        count++;
                    }
                }
                if(count == s2.length()){
                    return 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
           Homework hw=new Homework();
           System.out.println(hw.contains("gufucheng","fu"));
           System.out.println(hw.contains("gufucheng","fucheng"));
           System.out.println(hw.contains("gufucheng","fuchengh"));
           System.out.println(hw.IndexOf("yangsilin","yan"));
           System.out.println(hw.compareTo("ab","ac"));
           System.out.println(hw.compareTo("abc","ab"));

    }
}

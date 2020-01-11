public class MaxString {
    public static String gcdOfStrings(String str1, String str2) {
        while (!str1.equals(str2)) {
            if(str1.length() > str2.length()) {
                str1 = str1.replaceAll(str2, "");
            }
            else if(str1.length() < str2.length()) {
                str2 = str2.replaceAll(str1, "");
            }
            else {
                if(!str1.equals(str2)) {
                    return "";
                }
            }
            if(str1.length() == 0) {
                return str2;
            }
            if(str2.length() == 0) {
                return str1;
            }
        }
        return str1;
    }

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ababab","abab"));
    }
}

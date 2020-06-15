package June;

public class Day11 {
    //最长公共前缀
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0||strs==null){
            return "";
        }
        String str = strs[0];
        for(int i = 1; i < strs.length; i++){
            while(strs[i].indexOf(str) != 0){
                str=str.substring(0, str.length() - 1);
            }
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println("string".indexOf(""));
    }
}

public class 翻转单词顺序 {
    public static String reverseWords(String s) {
        s=s.trim();
        int r=s.length()-1;
        int l=s.length()-1;
        StringBuilder sb=new StringBuilder();

        while (r>=0){
            while (r>=0&&s.charAt(r)==' '){
                r--;
            }
            l=r;
            while (l>=0&&s.charAt(l)!=' '){
                l--;
            }
            sb.append(s.substring(l+1,r+1));
            if (l>0){
                sb.append(" ");
            }
            r=l;
        }

        return  sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world!  "));
    }
}

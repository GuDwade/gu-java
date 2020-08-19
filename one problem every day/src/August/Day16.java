package August;

public class Day16 {
    //回文子串
    //aaa
    public int countSubstrings(String s) {
        int count=0;

        for(int i=0;i<s.length();i++){
            for(int l=i,r=i;l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r);l--,r++){
                count++;
            }
            for(int l=i,r=i+1;l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r);l--,r++){
                count++;
            }
        }

        return  count;

    }
}

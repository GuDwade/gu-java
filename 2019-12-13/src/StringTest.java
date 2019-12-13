public class StringTest {
    public int compareTo(String str1,String str2){
        int len1=str1.length();
        int len2=str2.length();
        int shortlen=0;
        if(len1<=len2){
            shortlen=len1;
        }else{
            shortlen=len2;
        }
        for(int i=0;i<shortlen;i++){
            if(str1.charAt(i)<str2.charAt(i)){
                return -1;
            }else if(str1.charAt(i)>str2.charAt(i)){
                return 1;
            }else
                continue;
        }
        if(len1 == len2) {
            return 0;
        }else{
            return (len1>len2?1:-1);
        }
    }

    public static void main(String[] args) {
        StringTest str=new StringTest();
        int a=str.compareTo("abc","def");
        System.out.println(a);
    }

}

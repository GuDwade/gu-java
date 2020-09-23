import java.util.Arrays;

public class YouZan {
    public static void main(String[] args) {
        YouZan test =new YouZan();
        System.out.println(test.complement(0));
        char c='1';
       // System.out.println((int)c );
    }

    public String complement (int a) {

        if (a>=0){
            return  change(a);
        }else{
            String str=change(-a);
            char[]bits=str.toCharArray();
            for(int i=0;i<32;i++){
                if(bits[i]=='0'){
                    bits[i]='1';
                }else{
                    bits[i]='0';
                }
            }
            int mod=0;
            int add=1;
            int idx=31;
            while (mod==0&&idx>0){
                int sum=bits[idx]-'0'+add;
                mod=sum%2;
                bits[idx--]=(char)(mod+48);
            }
            return new String(bits);
        }
    }

    private String change(int a) {
        char[]bits=new char[32];
        Arrays.fill(bits,'0');
        int idx=31;
        while (a>0){
            int mod=a%2;
            bits[idx--]=(char)(mod+48);
            a/=2;
        }
        return new String(bits);
    }
}

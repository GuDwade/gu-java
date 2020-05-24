
import java.util.Scanner;

public class Day41 {

    //字符串加解密

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
           String toEncrypt=scan.next();
           String toUnEncrypt=scan.next();
           System.out.println(Encrypt(toEncrypt));
           System.out.println(unEncrypt(toUnEncrypt));
        }
    }

    private static String unEncrypt(String toUnEncrypt) {
        StringBuilder sb=new StringBuilder();
        for (char ch:toUnEncrypt.toCharArray()){
            if (ch>='0'&&ch<='9'){
                int cur=ch-48-1;
                if (cur<0){
                    cur=9;
                }
                ch=(char)(cur+48);
            }else if (ch>='a'&&ch<='z'){
                int cur=(ch-1)%96;
                if (cur==0){
                    cur+=122;
                }else{
                    cur+=96;
                }
                ch=(char)(cur-32);
            }else if (ch>='A'&&ch<='Z'){
                int cur=(ch-1)%64;
                if (cur==0){
                    cur+=90;
                }else{
                    cur+=64;
                }
                ch=(char)(cur+32);
            }
            sb.append(ch);
        }
        return sb.toString();
    }

    private static String Encrypt(String toEncrypt) {
        StringBuilder sb=new StringBuilder();
        for (char ch:toEncrypt.toCharArray()){
            if (ch>='0'&&ch<='9'){
                int cur=(ch-48+1)%10;
                ch=(char)(cur+48);
            }else if (ch>='a'&&ch<='z'){
                int cur=(ch+1)%123;
                if (cur==0){
                    cur+=97;
                }
                ch=(char)(cur-32);
            }else if (ch>='A'&&ch<='Z'){
                int cur=(ch+1)%91;
                if (cur==0){
                    cur+=65;
                }
                ch=(char)(cur+32);
            }
            sb.append(ch);
        }
        return sb.toString();
    }


}

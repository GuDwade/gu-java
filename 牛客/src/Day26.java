import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day26 {

    static Map<Integer,Integer>map=new HashMap<>();

    public static void main(String[] args) {


        Scanner scanner=new Scanner(System.in);
        String ip=scanner.nextLine();
        String[]part=ip.split("\\.");
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<part.length;i++){
            sb.append(changeToTwo(part[i]));
        }

        long ipNum=changeToTen(sb.toString());
        System.out.println(ipNum);

        StringBuilder sec=new StringBuilder();
        String num=scanner.nextLine();
        String numToTwo=new String(bigChange(num));
        String[]numIp=new String[4];
        int start=0;
        int len=8;
        for(int i=0;i<4;i++){
            numIp[i]=numToTwo.substring(start,start+len);
            sec.append(changeToTen(numIp[i]));
            if(i<3){
                sec.append('.');
            }
            start+=len;

        }
        System.out.println(sec);

    }

    private static char[] bigChange(String num) {
        char[]res=new char[32];
        Arrays.fill(res,'0');
        long n=Integer.valueOf(num);
        int idx=res.length-1;
        while (n!=0){
            long mod=n%2;
            res[idx--]=(char)(mod+48);
            n=n/2;
        }
        return res;
    }

    private static long changeToTen(String s) {
        int len=s.length();
        long fac=1;
        long sum=0;
        for (int i=0;i<s.length();i++){
            int num=(int)(s.charAt(len-1-i)-'0');
            sum+=num*fac;
            fac*=2;
        }
        return sum;
    }

    private static char[] changeToTwo(String s) {
        int num=Integer.valueOf(s);
        char[]tmp=new char[8];
        Arrays.fill(tmp,'0');
        int idx=tmp.length-1;
        while (num!=0){
            int mod=num%2;
            tmp[idx--]=(char)(mod+48);
            num=num/2;
        }
        return tmp;
    }


    public static void find(){

        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n=scanner.nextInt();
            for(int i=0;i<n;i++){
                map.put(scanner.nextInt(),i);
            }
            int find=scanner.nextInt();
            if (map.get(find)==null){
                System.out.println(-1);
            }else{
                System.out.println(map.get(find));
            }
        }

    }
}

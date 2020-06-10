import java.util.Scanner;

public class Day36 {
    //16进制转换 
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNext()){
            String str=scan.nextLine();
            int idx=str.length()-1;
            int factor=1;
            int sum=0;
            int tmp=0;
            while (idx>=0&&str.charAt(idx)!='x'){
                if (str.charAt(idx)>='A'&&str.charAt(idx)<='F'){
                    tmp=str.charAt(idx)-'A'+10;
                }else{
                    tmp=str.charAt(idx)-48;
                }
                sum+=tmp*factor;
                factor*=16;
                idx--;
            }
            System.out.println(sum);
        }
    }
    //字母统计
    public  static  void  countLetters(){
        int []letters=new int[26];
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String str=scanner.nextLine();
            for (char ch:str.toCharArray()){
                if (ch<='Z'&&ch>='A'){
                    letters[ch-'A']++;
                }
            }
            for(int i=65;i<=90;i++){
                System.out.println((char)i+":"+letters[i-65]);
            }
        }
    }
}

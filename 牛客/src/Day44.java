import java.util.Scanner;

public class Day44 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNextLine()){
            String str=scan.nextLine();
            //System.out.println(change(str));
            System.out.println(reverse(str));
        }
    }
    //骆驼命名法
    private static String change(String str) {
        String[]arr=str.split("_");
        if (arr.length==1){
            return arr[0];
        }
        StringBuilder sb=new StringBuilder(arr[0]);
        for(int i=1;i<arr.length;i++){
            char[]tmp=arr[i].toCharArray();
            if(tmp[0]<='z'&&tmp[0]>='a'){
                tmp[0]=(char)(tmp[0]-32);
            }
            sb.append(tmp);
        }
        return sb.toString();
    }

    //单词倒排
    public static String reverse(String sentence){
        int left=sentence.length()-1;
        int right=sentence.length()-1;
        StringBuilder sb=new StringBuilder();
        while (right>=0){
            while (right>=0&&isLetters(sentence.charAt(right))){
                right--;
            }
            if (left-right>0){
                sb.append(sentence.substring(right+1,left+1));
            }
            if (right>0&&sb.length()>0){
                sb.append(' ');
            }
            left=right;
            while (left>=0&&!isLetters(sentence.charAt(left))){
                left--;
            }
            right=left;
        }
        return sb.toString();
    }

    public static boolean isLetters(char c){
        if((c<='z'&&c>='a')||(c<='Z'&&c>='A')){
            return true;
        }
        return  false;
    }
}

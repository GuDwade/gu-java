import java.util.Scanner;

public class 科大讯飞 {
//    public static void main(String[] args) {
//        Scanner scan=new Scanner(System.in);
//        while (scan.hasNextLine()){
//            String str=scan.nextLine();
//            StringBuilder sb=new StringBuilder();
//            int idx=0;
//
//            while (idx<str.length()){
//                char cur=str.charAt(idx);
//                int cnt=0;
//                int j=idx;
//                while (j<str.length()&&str.charAt(j)==cur){
//                    cnt++;
//                    j++;
//                }
//                if(cnt>1){
//                    sb.append(cnt);
//                }
//                sb.append(cur);
//                idx=j;
//            }
//            System.out.println(sb.toString());
//        }
//    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNextInt()){
            int day=scan.nextInt();
            if(day==1){
                System.out.println(6);
            }else if(day==2){
                System.out.println(18);
            }else{
                int []jumps=new int[day+1];
                jumps[1]=3;
                jumps[2]=3;
                for(int i=3;i<=day;i++){
                    jumps[i]=jumps[i-1]+jumps[i-2];
                }

                int half=0;
                int sum=0;
                for(int i=day;i>0;i--){
                    half+=jumps[i];
                    sum=half*2;
                    half=sum;
                }

                System.out.println(sum);
            }

        }
    }
}

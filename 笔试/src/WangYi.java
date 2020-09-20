import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WangYi {
    static List<List<String>>ret;
    static List<String>path;
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNextLine()){
            int n=Integer.valueOf(scan.nextLine());
            String []strings=new String[n];
            for(int i=0;i<n;i++){
                strings[i]=scan.nextLine();
            }
            String[][]strs=new String[n][];
            for(int i=0;i<n;i++){
                strs[i]=strings[i].split(" ");
            }
            int num=1;
            for(int i=0;i<n;i++){
                num*=strs[i].length;
            }
            ret=new ArrayList<>();
            path=new ArrayList<>();
            dfs(strs,0,n);
            for(int k=0;k<num/strs[0].length;k++){
                for(int i=k;i<ret.size();i+=num/strs[0].length){
                    StringBuilder sb=new StringBuilder();
                    for(int j=0;j<ret.get(i).size();j++){
                        sb.append(ret.get(i).get(j));
                        if(j<ret.get(i).size()-1){
                            sb.append('-');
                        }
                    }
                    System.out.println(sb.toString());
                }
            }

        }
    }

    private static void dfs(String[][] strs, int rol,int cnt) {

        if(path.size()==cnt){
            ret.add(new ArrayList<>(path));
            return;
        }

        for(int i=0;i<strs[rol].length;i++){
            path.add(strs[rol][i]);
            dfs(strs,rol+1,cnt);
            path.remove(path.size()-1);
        }
    }

//    public static void main(String[] args) {
//        Scanner scan=new Scanner(System.in);
//        while (scan.hasNextLine()){
//            String str=scan.nextLine();
//            System.out.println(many(str));
//        }
//    }
//
//    private static int many(String str) {
//        int cnt=0;
//        int len=str.length();
//        for(int i=0;i<str.length();i++){
//            for(int l=i,r=i;l>=0&&r<len&&str.charAt(l)==str.charAt(r);l--,r++){
//                if (r-l>0){
//                    cnt++;
//                }
//            }
//
//            for(int l=i,r=i+1;l>=0&&r<len&&str.charAt(l)==str.charAt(r);l--,r++){
//                cnt++;
//            }
//        }
//        return  cnt;
//    }
}

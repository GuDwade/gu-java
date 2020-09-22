import java.util.*;

public class AiQiYi {
//    public static void main(String[] args) {
//        Scanner scan=new Scanner(System.in);
//        while (scan.hasNextLine()){
//            String str=scan.nextLine();
//            System.out.println(longMaxSubString(str));
//        }
//    }

    static List<List<Integer>>ret;
    static List<Integer>path;

//    public static void main(String[] args) {
//        ret=new ArrayList<>();
//       path=new ArrayList<>();
//        int []arr={-1 ,0 ,1, 2 ,-1, -4};
//        Arrays.sort(arr);
//        boolean[]isUsed=new boolean[arr.length];
//        dfs(arr,0,0,isUsed);
//        for(int i=0;i<ret.size();i++){
//            List<Integer>cur=ret.get(i);
//            for(int j=0;j<cur.size();j++){
//                System.out.print(cur.get(j));
//                if(j!=cur.size()-1){
//                    System.out.print(" ");
//                }
//            }
//            System.out.println();
//        }
//    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        List<Integer> list=new ArrayList<>();
        ret=new ArrayList<>();
        path=new ArrayList<>();
        while (scan.hasNextInt()){
            list.add(scan.nextInt());
        }
        int[]arr=new int[list.size()];
        for(int i=0;i<arr.length;i++){
            arr[i]=list.get(i);
        }
        Arrays.sort(arr);
        boolean[]isUsed=new boolean[arr.length];
        dfs(arr,0,0,isUsed);
        Collections.sort(ret,(l1,l2)->{
            int ret=l1.get(0)-l2.get(0);
            if (ret==0){
                ret=ret=l1.get(1)-l2.get(1);
                if (ret==0){
                    ret=ret=l1.get(2)-l2.get(2);
                }
            }
            return  ret;
        });
        for(int i=0;i<ret.size();i++){
            List<Integer>cur=ret.get(i);
            for(int j=0;j<cur.size();j++){
                System.out.print(cur.get(j));
                if(j!=cur.size()-1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static void dfs(int[] arr, int idx,int sum,boolean[]isUsed) {
        if (path.size()==3){
            if (sum==0){
                Collections.sort(path);
                if (!ret.contains(path)){
                    ret.add(new ArrayList<>(path));
                }
            }
            return;
        }
        for(int i=idx;i<arr.length;i++){
            if (isUsed[i]){
                continue;
            }
            if (i>=1&&arr[i-1]==arr[i]&&isUsed[i-1]==false){
                continue;
            }
            isUsed[i]=true;
            path.add(arr[i]);
            dfs(arr,idx+1,sum+arr[i],isUsed);
            isUsed[i]=false;
            path.remove(path.size()-1);
        }
    }

    private static int number(int[] arr) {
        int val=arr[0];
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if (arr[i]==val){
                cnt++;
            }else{
                cnt--;
                if (cnt==0){
                    val=arr[i+1];
                }
            }
        }
        return  val;
    }

    private static int longMaxSubString(String str) {
        Set<Character> set=new HashSet<>();
        int cnt=0;
        int idx=0;
        for(int i=0;i<str.length();i++){
            while (set.contains(str.charAt(i))){
                set.remove(str.charAt(idx));
                idx++;
            }
            set.add(str.charAt(i));
            cnt=Math.max(cnt,i-idx+1);
        }
        return  cnt;
    }
}

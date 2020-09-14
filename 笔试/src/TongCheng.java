import java.util.Scanner;

public class TongCheng {
    public static void main2(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNextLine()){
            String str=scan.nextLine();
            int[]arr=new int[26];

            for(char cur:str.toCharArray()){
                arr[cur-'A']++;
            }

            for(int i=0;i<26;i++){
                if (arr[i]!=0){
                    System.out.print((char)(i+'A')+"="+arr[i]+" ");
                }
            }
        }


    }

    public static void main1(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNextLine()){
            String str=scan.nextLine();
            int l=0,r=0;
            int start=0,end=0;
            while (l<str.length()){
                while (l<str.length()&&!is58(str.charAt(l))){
                    l++;
                }
                r=l;
                while (r<str.length()&&is58(str.charAt(r))){
                    r++;
                }
                if(r-l>end-start){
                    start=l;
                    end=r;
                }
                l=r;
            }
            System.out.println(str.substring(start,end));
        }
    }

    private static boolean is58(char c) {
        if(c=='5'||c=='6'||c=='7'||c=='8'){
            return  true;
        }
        return  false;
    }
    static  int max;
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNextLine()){
            String str=scan.nextLine();
            str=str.substring(1,str.length()-1);
            String[]strings=str.split(",");
            int []nums=new int[strings.length];
            for(int i=0;i<strings.length;i++){
                nums[i]=Integer.valueOf(strings[i]);
            }
            if(nums.length<=5){
                int sum=0;
                for(int n:nums){
                    sum+=n;
                }
                System.out.println(sum);
            }else{
                dfs(nums,5,0,0,0);
                System.out.println(max);
            }

        }
    }

    private static void dfs(int[] nums, int cnt, int sum,int left,int right) {
        if (cnt==0){
              if (sum>max){
                  max=sum;
              }
              return ;
        }

        dfs(nums,cnt-1,sum+nums[left],left+1,right);
        dfs(nums,  cnt-1, sum+nums[nums.length-right-1],left,right+1);


    }


}

import java.util.Stack;

public class 伴鱼 {
    public static int movingCount (int m, int n, int k) {
        if(k<0){
            return 0;
        }
        int[][]roads=new int[m][n];
        int count=1;
        roads[0][0]=1;
        for(int i =1;i<n;i++){
            if (isRight(0,i,k)){
                roads[0][i]=roads[0][i-1];
                count++;
            }else{
                break;
            }
        }

        for(int j=1;j<m;j++){
            if (isRight(j,0,k)){
                roads[j][0]=roads[j-1][0];
                count++;
            }else{
                break;
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if ((roads[i][j-1]==1||roads[i-1][j]==1)&&isRight(i,j,k)){
                    roads[i][j]=1;
                    count++;
                }
            }
        }
        return  count;
    }

    private static boolean isRight(int i, int j,int k) {
        int sum=0;
        while (i!=0){
            sum+=i%10;
            i/=10;
        }

        while (j!=0){
            sum+=j%10;
            j/=10;
        }

        return sum<=k;
    }

    public static int minInsertions (String s) {
       int ret=0;
       Stack<Character>stack=new Stack<>();
       for(int i=0;i<s.length();i++){
           char cur=s.charAt(i);
           //"(()))"
           if(cur=='('){
               stack.push(cur);
           }else if(cur==')'){
               if(stack.isEmpty()){
                   if (i+1<s.length()&&s.charAt(i+1)==')'){
                       ret+=1;
                       i++;
                   }else{
                       ret+=2;
                   }
               }else{
                   if (i+1<s.length()&&s.charAt(i+1)==')'){
                       i++;
                       stack.pop();
                   }else{
                       ret++;
                       stack.pop();
                   }
               }
           }
       }
       while (!stack.isEmpty()){
           ret+=2;
           stack.pop();
       }
        return  ret;
    }
    public static void main(String[] args) {
        System.out.println(movingCount(2, 3, 1));
        System.out.println(minInsertions("(()))"));
        System.out.println(minInsertions("())"));
        System.out.println(minInsertions("(((((("));
    }
}

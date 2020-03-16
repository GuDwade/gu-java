public class Day11 {
    public static int compress(char[] chars) {
        //start 表示一个新元素的起始位置
        int start=0;
        //end表示旧元素的末位置
        int end=0;
        while(start<chars.length){
            chars[end++]=chars[start];//end更替为新元素 并end记录元素个数
            int startIndex=start;// 记录开始位置
            while(start<chars.length&&chars[start]==chars[end-1]){
                start++;
                //直到不等于时 start此时位于新元素开头
            }
            if(start-startIndex>1){
                for(char c:String.valueOf(start-startIndex).toCharArray()){
                    chars[end++]=c;
                    //end记录旧元素个数 后移开始记录新元素
                }
            }
        }
        return  end;
    }

    public static String compressString(String S) {
        StringBuilder sb=new StringBuilder();
        char[]chars=S.toCharArray();
        int end=0;
        int start=0;
        int count =0;
        while(start<S.length()){
            while(end<S.length()&&chars[start]==chars[end]){
                end++;
                count++;
            }
            sb.append(chars[start]);
            sb.append(String.valueOf(count));
            start=end;
            count=0;
        }
        if(sb.length()>=S.length()){
            return S;
        }
        return sb.toString();
    }


    public static void main(String[] args) {
       char[]chars={'a','a','b','b','b','c','c','c','c','c'};
       System.out.println(compress(chars));
       String str="aabbbccccc";
       System.out.println(compressString(str));
    }
}

public class Day29 {
    //字符串转整数
    public int myAtoi(String str){
        char[]ch=str.toCharArray();
        int index=0;
        while(ch[index]==' '){
            index++;
        }
        if(index==str.length()) {
            return 0;
        }

        boolean sign=true;
        if(ch[index]=='-'){
            sign=false;
            index++;
        }else if(ch[index]=='+'){
            index++;
        }else if(!Character.isDigit(ch[index])){
            return 0;
        }

        int ans=0;
        while (index < str.length()&& Character.isDigit(ch[index])) {
            int digit = ch[index] - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                // ans * 10 + digit > Integer.MAX_VALUE时 越界
                return sign? Integer.MAX_VALUE: Integer.MIN_VALUE;
            }
            ans = ans * 10 + digit;
            index++;
        }
        return sign?ans:-ans;
    }
}

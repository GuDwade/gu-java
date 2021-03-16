public class 替换空格 {


    public String replaceSpace(String s) {
        if(s == null || s.length() == 0){
            return s;
        }

        int cnt = 0;
        for(char ch : s.toCharArray()){
            if(ch == ' '){
                cnt++;
            }
        }
        int len = s.length();
        char[] rets = new char[len + cnt * 2];
        int idx = 0;
        for(char ch : s.toCharArray()){
            if(ch == ' '){
                rets[idx++] = '%';
                rets[idx++] = '2';
                rets[idx++] = '0';
            }else{
                rets[idx++] = ch;
            }
        }

        return new String(rets);
    }
}

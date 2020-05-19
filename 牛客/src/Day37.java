
public class Day37 {
    //最佳公共祖先
    public int getLCA(int a, int b) {
        if(a==1||b==1){
            return  1;
        }

        while(a != b){
            if(a > b){
                a /= 2;
            }else{
                b /= 2;
            }
        }
        return a;
    }
    //空格替换
    public String replaceSpace(String iniString, int length) {
        int count=0;
        for(int i=0;i<length;i++){
            if(iniString.charAt(i)==' '){
                count++;
            }
        }
        char[]newString=new char[length+count*2];
        int idx=0;
        for(char tmp:iniString.toCharArray()){
            if (tmp==' '){
                newString[idx++]='%';
                newString[idx++]='2';
                newString[idx++]='0';
            }else{
                newString[idx++]=tmp;
            }
        }
        return new String(newString);
    }
}

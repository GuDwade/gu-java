package Dec;

public class Day21 {
    //长按键入
    public static boolean isLongPressedName(String name, String typed) {

        if (name.equals(typed)){
            return  true;
        }

        int i=0, j=0;
        int len1=name.length(),len2=typed.length();

        while (i<len1&&j<len2){
            if (name.charAt(i)==typed.charAt(j)){
                char cur=name.charAt(i);
                int start1=i,start2=j;
                while (i<len1&&name.charAt(i)==cur){
                    i++;
                }

                while (j<len2&&typed.charAt(j)==cur){
                    j++;
                }

                if(j-start2<i-start1){
                    return  false;
                }

            }else{
                return  false;
            }
        }

        return  i==len1&&j==len2;
    }

    public static void main(String[] args) {
        System.out.println(isLongPressedName("alex"
                ,"alexxr"));
    }
}

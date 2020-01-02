public class Learning {
    public static boolean isNumber(String str){
        char[] ch=str.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i]<'0'||ch[i]>'9'){
                return false;
            }
        }
        return true;
    }
    public static String firstUpper(String str){
        if("".equals(str)||str==null){
            return str;
        }
        if(str.length()>1){
            return str.substring(0,1).toUpperCase()+str.substring(1);
        }
        return  str.toUpperCase();
    }
    public static void main(String[] args) {
        //字符与字符串
        char[]arr={'y','s','l','h','a','a'};
        String str=new String(arr);
        System.out.println(str);
        String str1=new String(arr,1,3);//起始位置 个数
        System.out.println(str1);
        String str2="yangsilin";
        System.out.println(str2.charAt(3));
        char[]yang=str2.toCharArray();
        for(int i=0;i<yang.length;i++){
            System.out.print(yang[i]);
        }
        System.out.println(new String(yang,1,5));
        String str3="susgh4ui";
        System.out.println(isNumber(str3));
        byte[]bt={'2','4','5','6'};
        String str4=new String(bt);
        String str5=new String(bt,0,3);
        System.out.println(str4);
        System.out.println(str5 );
        byte[]bt1=str5.getBytes();
        System.out.println("ac".compareTo("Ac"));
        String gu="gufucheng";
        System.out.println(gu.contains(gu));
        System.out.println(gu.indexOf("fu"));
        System.out.println(gu.indexOf("gu",3));
        System.out.println(gu.startsWith("gu"));
        System.out.println(gu.startsWith("fu",2));
        System.out.println(gu.endsWith("eng"));
        gu=gu.replace("gu","Gu");
        System.out.println(gu);//字符串不变，产生新的字符串
        //字符串拆分
        String gy="love or don't love";
        String []result=gy.split(" ");
        for(String s:result){
            System.out.println(s);
        }
        //字符串获取
        String st="gufuxiang hahaha";
        System.out.println(st.substring(6));
        System.out.println(st.substring(3,9));
        //其他操作
        String cao="GuGDYGHDJFHJHgffua";
        System.out.println(cao.toUpperCase());
        System.out.println(cao.toLowerCase());
        System.out.println(cao.isEmpty());
        System.out.println(cao.length());
        System.out.println(firstUpper("gufucheng"));
    }
}
public class StringPra {
    public static void main(String[] args) {
        //构造方法特殊
        //StringBuilder可变，String不可变
        StringBuilder sb=new StringBuilder("gufucheng");
        sb.append(" is ");
        sb.append("good");
        sb.reverse();
        String str=sb.toString();
        System.out.println(str);
        //常量池  （缓存）
        String  s="hello";
        String  q="hello";
        String  p="hello";
        //判断引用是否指向同一对象
        System.out.println(s==q);
        System.out.println(p==q);
        //判断字符串是否相等
        System.out.println(s.equals(p));
        System.out.println(p.equals(q));
        /*
        String str1="yangsiling";
        String str2=new String(str1);
        String str3=new String(str1);
        System.out.println(str1.equals(str2));
        System.out.println(str1==str2);
        System.out.println(str3==str2);
        */
        /*
        String str1="hello" +" "+"word";
        String str2="hello word";
        System.out.println(str1==str2);
        */
        String str0="nihao";
        String str1=new String(str0);
        str1=str1.intern();//是否有equals(str0)的对象，如果有返回池中对象的引用，如果没有，放入池中
        System.out.println(str0==str1);
        //遍历字符串
        String str5="xiangydaxue";
        for(int i=0;i<str5.length();i++){
            char c=str5.charAt(i);
            System.out.print(c+" ");
        }
        System.out.println(" ");
        char[]charArr=str5.toCharArray();
        for(char c: charArr){
            System.out.print(c+" ");
        }

    }
}

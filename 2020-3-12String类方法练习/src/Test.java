import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Test {
    public static void main(String[] args) {

        String str=new String("abcdefg");
        String str1="abcdefg";

        System.out.println(str1==str);//false
        System.out.println(str.equals(str1));//true
        System.out.println(str.charAt(0));//a

        //字符串连接
        String str2="hello";
        String str3="word";
        //将指定的字符串连接到该字符串的末尾。
        System.out.println(str2.concat(str3));
        System.out.println(str2+" "+str3);
        System.out.println(1+"123"+2+3);
        System.out.println("123"+(2+3));


        //替换
        String str4="abcabc";
        System.out.println(str4.replace("ab","AB"));
        System.out.println(str4.replace("ab","ABCD"));
        System.out.println(str4.replace('a','b'));//bbcbbc
        System.out.println(str4.replaceFirst("a","b"));//bbcabc
        System.out.println(str4.replaceAll("a","b"));//bbcbbc

        //查找
        String str5="abcdefg";
        System.out.println(str5.indexOf("def"));//3
        System.out.println(str5.indexOf("gh"));//-1
        System.out.println(str.lastIndexOf("def"));//3

        //截取子字符串
        String str7="abcdefghijk";
        System.out.println(str7.substring(5));//fghijk [5,str.length())
        System.out.println(str7.substring(5,11)); //[5,11) 包头不包尾


        System.out.println("abcDEf".toLowerCase());
        System.out.println("abcDEf".toUpperCase());


        //所有操作都返回新字符串  原字符串不变
        String str8="  a b c ";
        System.out.println(str8.length());
        System.out.println(str8.trim());//去除首尾空格
        System.out.println(str8.trim().length());
        System.out.println(str8.replace(" ",""));//去除全部空格


        String str9="www:baidu:com";
        System.out.println(Arrays.toString(str9.split(":")));//去掉：
        System.out.println(Arrays.toString(str9.split("ww")));
        System.out.println(Arrays.toString(str9.split(":",2)));
        System.out.println(Arrays.toString(str9.split(":",5)));
        System.out.println(str9.split(":",5).length);
        System.out.println(Arrays.toString(str9.split(":",-2)));
        System.out.println(str9.split(":",-2).length);


        String str10=String.join("-","java","is","cool");
        System.out.println(str10);
        HashSet<String>strings=new LinkedHashSet<>();
        strings.add("java");
        strings.add("is");
        strings.add("so");
        strings.add("cool");
        System.out.println(String.join("-",strings));

        String str11="I love China";
        char[]ch=str11.toCharArray();
        System.out.println(String.copyValueOf(ch));
        System.out.println(String.copyValueOf(ch,3,9));
    }
}

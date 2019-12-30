import sun.nio.cs.ext.GB18030;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class StringMethod {
    private static  byte[] transform(byte[]a,String fromCharset,String toCharset) throws UnsupportedEncodingException {
        String s=new String(a,fromCharset);
        return s.getBytes(toCharset);
    }
    private  static  boolean isNumber(String str){
        char[]arr=str.toCharArray();
        for(char c:arr){
            if(c<'0'||c>'9'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[]arr="中国人".getBytes("GB18030");
        for(byte b:arr){
            System.out.printf("\\x%x",b);
        }
        System.out.println(" ");
        /*
        byte[]arr1=transform(arr,"GB18030","UTG-8");
        for(byte b:arr1){
            System.out.printf("\\x%x",b);
        }
        System.out.println();
        */
         //abc<bbc  abc<abcd abcd<bbc

        System.out.println("abc".compareTo("bbc"));
        System.out.println("abc".compareTo("abcd"));
        System.out.println("abcd".compareTo("bbc"));
        System.out.println("gufucheng".contains("gucheng"));
        System.out.println("gufucheng".startsWith("gu"));
        System.out.println("gufucheng".endsWith("eng"));
    }
}
import java.io.File;
import java.util.Scanner;
import java.io.*;
public class CreatFile{
    public static void main(String[]args)throws Exception{
        String str;
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入内容");
        str=in.readLine();
        FileWriter fw=new FileWriter("E:\\gucheng.txt");
        fw.write(str);
        fw.close();
        System.out.println(str);
    }
}
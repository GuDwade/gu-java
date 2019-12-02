import java.io.*;
public class CopyFileByChar{
    public static void main(String[]args){
        try{
            FileReader input=new FileReader("E:\\gucheng.txt");
            FileWriter output=new FileWriter("E:\\gufucheng1.txt");
            int c=input.read();
            while(c!=-1){
                output.write(c);
                System.out.println((char)c);
                c=input.read();
            }
            input.close();
            output.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
}

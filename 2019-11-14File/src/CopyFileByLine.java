import java.io.*;
public class CopyFileByLine {
    public static void main(String[] args) {
        try{
            FileReader input=new FileReader("E:\\gucheng.txt");
            BufferedReader br=new BufferedReader(input);
            FileWriter ouput=new FileWriter("E:\\gufucheng2.txt");
            BufferedWriter bw=new BufferedWriter(ouput);
            String s=br.readLine();
            while(s!=null) {
                bw.write(s);
                bw.newLine();
                System.out.println(s);
                s = br.readLine();
            }
            br.close();
            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

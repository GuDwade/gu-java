import org.omg.CORBA.portable.OutputStream;

import java.net.*;
import java.io.*;

public class TestServer {
    public static void main(String[] args) {
        ServerSocket s=null;
        try{
            s=new ServerSocket(8888);
        }catch(IOException e){}
        while(true){
            try{
                Socket s1=s.accept();
                OutputStream os= (OutputStream) s1.getOutputStream();
                DataOutputStream  dos=new DataOutputStream(os);
                dos.writeUTF("hello world");
                dos.close();
                s1.close();
            }catch(IOException e){}
        }
    }
}

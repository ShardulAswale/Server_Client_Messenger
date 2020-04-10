package cn4;
import java.io.*;
import java.net.*; 
public class Prac3_CN {
    static DataInputStream dis;
    static DataOutputStream dout;
    static BufferedReader br;
    public static void main(String[] args) {
        try{
                ServerSocket server=new ServerSocket(2000);  
                Socket s=server.accept();  
            while(true){
                dis=new DataInputStream(s.getInputStream());
                String  str=(String)dis.readUTF();  
                System.out.println("message= "+str);
               
                br=new BufferedReader(new InputStreamReader(System.in)); 
                dout=new DataOutputStream(s.getOutputStream());
                dout.writeUTF(br.readLine());  
                dout.flush();
                                 
                 if(str.equalsIgnoreCase("bye")){
                     System.out.println("Server client chat over");
                     break;
                 }
            }
          }
        catch(IOException ex){
                System.out.println(ex.getCause());
        }
    }
}
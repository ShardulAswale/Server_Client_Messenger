package cn4;
import java.io.*;
import java.net.*;
public class Client {  
    static DataInputStream dis;
    static DataOutputStream dout;
    static BufferedReader br;
    static String string;  
    public static void main(String[] args) {
        try{
          Socket client = new Socket("localhost",2000);
            if(client.getPort() == 2000){
                System.out.println("CONNECTION ESTABLISHED!!!");
            }
            else{
                System.out.println("ERROR IN ESTABLISHING CONNECTION");
            }
            while(true){
                br=new BufferedReader(new InputStreamReader(System.in));
                string = br.readLine();
                dout=new DataOutputStream(client.getOutputStream());
                dout.writeUTF(string);  
                dout.flush();
                
                if(string.equalsIgnoreCase("bye")){
                    System.out.println("Server client chat over");
                    break;
                }
                 dis=new DataInputStream(client.getInputStream());
                 String  str=(String)dis.readUTF();  
                 System.out.println("message= "+str);
                 
                 if(str.equalsIgnoreCase("bye")){
                     System.out.println("Server client chat over");
                     break;
                 }
            }
          }
        catch(Exception ex){
                System.out.println(ex.getCause());
        }
    }
}

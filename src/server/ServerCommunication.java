
package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerCommunication {
    
     public static void main(String[] args) throws IOException {

         ServerSocket ss = new ServerSocket(5027);
         Socket s =  ss.accept();
         System.out.println("The server is listening... ");
         System.out.println("The server is expecting a client...");
         
         InputStream is = s.getInputStream();
         OutputStream os = s.getOutputStream();
         BufferedReader bfr = new BufferedReader(new InputStreamReader(is));
        
         System.out.println("The client says:");
         
         System.out.println(bfr.readLine());
         os.write("Which operation you want?\r\n".getBytes());
         
         String op = bfr.readLine();
         System.out.println("The client has chosen: "+ op);
         
         os.write("Enter numbers\r\n".getBytes());
        String opr = bfr.readLine();
        
        int o1 = Integer.parseInt(opr.split(",")[0]);
        int o2 = Integer.parseInt(opr.split(",")[1]);
        
        String res = "";
        switch(op){
        
        case"-": 
                res = String.valueOf(o1 - o2);
        break;
        case"+":
                 res = String.valueOf(o1 + o2);
        break;
        case"*":
                res = String.valueOf(o1 * o2);
        break;
        case"/":
                if(o2==0){
                    res = "You cannot divide by zero!";
                }
                else{
                res = String.valueOf(o1 / o2);
                }
        break;
        }
     os.write((res+"\r\n").getBytes());
    }
    
}


package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;


public class ClientCommunication {


    public static void main(String[] args) throws IOException {
        
        Socket s = new Socket("localhost",5027);
        
        InputStream is = s.getInputStream();
        OutputStream os = s.getOutputStream();
        
        BufferedReader bfr = new BufferedReader(new InputStreamReader(is));
        
        os.write("We have a connection!\r\n".getBytes());
        System.out.println(bfr.readLine());
        
        System.out.println("Select operation: + - * / :");
        String op = new Scanner(System.in).nextLine()+"\r\n";
        os.write(op.getBytes());
        System.out.println(bfr.readLine());
        System.out.println("Enter the first number: ");
        String op1 = new Scanner(System.in).nextLine();
        System.out.println("Enter the second number:");
        String op2 = new Scanner(System.in).nextLine();
        
        String opr = op1.trim()+","+op2.trim()+"\r\n";
        os.write(opr.getBytes());
        System.out.println(bfr.readLine());
    }
    
}

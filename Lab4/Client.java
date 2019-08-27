package menual.solution;
import java.net.*;  
import java.io.*;  
import java.util.*;
class Client{  
    public static void main(String args[])throws Exception{  
        Scanner hi = new Scanner(System.in);
        System.out.print("Enter Ip Address:");
        String IpAddress = hi.next();
        Socket s = new Socket(IpAddress,3300);
        DataInputStream in = new DataInputStream(s.getInputStream());  
        DataOutputStream out = new DataOutputStream(s.getOutputStream());  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        String str="",str2="";  
        while(!str.equals("bye")){
            System.out.print("Clinet:");
            str = br.readLine();  
            if(str=="bye")break;
            out.writeUTF(str);  
            out.flush();  
            str2 = in.readUTF();  
            System.out.println("                                   Server says: "+str2);  
        }  
        out.close();  
        s.close();  
}}  
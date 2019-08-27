package menual.solution;
import java.net.*;  
import java.io.*;  
class Server{  
    public static void main(String args[])throws Exception{  
        ServerSocket ss = new ServerSocket(3300);  
        System.out.println("Waiting for Client.....");
        Socket s = ss.accept();  //waits for client
        System.out.println("Let't Chat..");
        DataInputStream in=new DataInputStream(s.getInputStream());  
        DataOutputStream out=new DataOutputStream(s.getOutputStream());  
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
        String str="",str2="";  
        while(!str.equals("bye")){  
            str = in.readUTF();  
            System.out.println("                                    Client says: "+str);  
            System.out.print("Server:");
            str2 = br.readLine();  
            out.writeUTF(str2);  
            out.flush();  
        }  
        in.close();  
        s.close();  
        ss.close();  
}}  
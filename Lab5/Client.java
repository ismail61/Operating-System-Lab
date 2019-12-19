/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat_System;

import java.io.*;
import java.net.*;
import java.lang.*;
class Client
{
public static void main(String a[])throws IOException
{
    DatagramSocket ds=new DatagramSocket(4444);
        while(true)
        {                
            
                byte b[]=new byte[1024];

                DatagramPacket dp=new DatagramPacket(b,b.length);
                
                ds.receive(dp);
                String msg=new String(dp.getData());
                System.out.println("Msg Received:"+msg);
                
                InetAddress add=dp.getAddress();
                int port=dp.getPort();
                System.out.print("Enter a line of text to send:");
                BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
                String msg1=br.readLine();
                byte[]b1=msg1.getBytes();
                DatagramPacket dp1=new DatagramPacket(b1,b1.length,add,port);

                ds.send(dp1);
                if(msg1.equals("exit"))
                System.exit(0);
        }
    }
}
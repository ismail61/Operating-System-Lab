/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat_System;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class Server
{
public static void main(String a[])throws Exception
{
        while(true)
                {
                DatagramSocket ds=new DatagramSocket();
                BufferedReader br=new   BufferedReader(new InputStreamReader(System.in));
                System.out.println("Enter the Message:");
                String msg=br.readLine();
                byte b1[]=msg.getBytes();
                InetAddress add=InetAddress.getLocalHost();
                DatagramPacket dp=new DatagramPacket(b1,b1.length,add,4444);
                ds.send(dp);
                if(msg.equals("exit"))
                System.exit(0);
                byte b[]=new byte[1024];
                DatagramPacket dp1=new DatagramPacket(b,b.length);
                ds.receive(dp1);
                String msg1=new String(dp1.getData());
                System.out.println("Received msg:"+msg1);
                }
        }
}
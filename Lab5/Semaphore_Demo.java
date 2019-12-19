/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package two_two_semester;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
class Shared{
    static int count =0;
}
class Mythread extends Thread{
    private Semaphore sema;
    private String name;
    Mythread(Semaphore sema,String name){
        this.sema = sema;
        this.name = name;
    }
    @Override
    public void run(){
        if(name.equals("A")){
            System.out.println("Starting..."+name);
            try {
                System.out.println(name+" is waiting for permits");
                
                sema.acquire();
                System.out.println(name+" gets a permit");
                for(int i=0;i<5;i++){
                    Shared.count++;
                    System.out.println(name+ " : "+Shared.count);
                    Thread.sleep(100);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Mythread.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(name + " releases the permits");
            sema.release();
        }
        else if (name.equals("B")){
            System.out.println(name +"waiting to permits");
            try {
                System.out.println(name +" gets a permit");
                sema.acquire();
                
                for(int i=0;i<5;i++){
                    Shared.count--;
                    System.out.println(name+" : "+Shared.count);
                    Thread.sleep(100);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Mythread.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(name +"releases the permits");
            sema.release();
        }
    }
    
}
public class Semaphore_Demo {
    public static void main(String[] args) throws InterruptedException {
        Semaphore sem = new Semaphore(1);
        
        Mythread t1 = new Mythread(sem,"A");
        Mythread t2 = new Mythread(sem,"B");
        
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Value of count is : "+Shared.count);
    }
}

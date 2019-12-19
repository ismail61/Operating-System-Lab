/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package two_two_semester;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Reader_Writer {
    static int readcont = 0;
    static Semaphore readsem = new Semaphore(1);
    static Semaphore writesem = new Semaphore(1);
    static class Reader implements Runnable{

        @Override
        public void run() {
            try {
                readsem.acquire();
                readcont++;
                if(readcont==1) writesem.acquire();
                readsem.release();
                
                System.out.println(Thread.currentThread().getName()+" is Reading");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+" has finished Reading");
                
                readsem.acquire();
                readcont--;
                if(readcont ==0){
                    writesem.release();
                }
                readsem.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(Reader_Writer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    static class Writter implements Runnable{

        @Override
        public void run() {
            try {
                writesem.acquire();
                
                System.out.println(Thread.currentThread().getName()+" is writting");
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName()+ " has finised writting");
                
                writesem.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(Reader_Writer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    public static void main(String[] args) {
        Reader read = new Reader();
        Writter write = new Writter();
        Thread t1 = new Thread(read);
        t1.setName("Reader1");
        Thread t2 = new Thread(read);
        t2.setName("Reader2");
        Thread t3 = new Thread(write);
        t3.setName("Writter1");
        Thread t5 = new Thread(write);
        t5.setName("Writter2");
        Thread t4 = new Thread(read);
        t4.setName("Reader3");
        
        t1.start();
        t3.start();
        t2.start();
        t5.start();
        t4.start();
        
    }
    
}

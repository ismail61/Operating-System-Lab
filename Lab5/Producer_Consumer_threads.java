/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package two_two_semester;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer_Consumer_threads {
    
    public static void main(String[] args) throws InterruptedException {
        final PC pc = new PC();
        Thread t1 = new Thread(new Runnable(){

            @Override
            public void run() {
                try {
                    pc.Producer();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Producer_Consumer_threads.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        Thread t2 = new Thread(new Runnable(){

            @Override
            public void run() {
                try {
                    pc.Consumer();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Producer_Consumer_threads.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
    }
    
public static class PC{
    LinkedList<Integer> item = new LinkedList<>();
    int capacity = 2;
    void Producer() throws InterruptedException{
        int value = 0;
        while(true){
            synchronized(this){
            
                while(item.size() == capacity){
                    wait();
                }
                System.out.println("Producer Produced : "+value);
                item.add(value++);
                notify();
                Thread.sleep(1000);
        }
        }
        
    }
    void Consumer() throws InterruptedException{
       
        while(true){
            synchronized(this){
                while(item.size()== 0){
                    wait();
                }
                int val = item.removeFirst();
                System.out.println("Consumer consumed : "+val);
               
                notify();
                
                Thread.sleep(1000);
            }
        }
    }
}

    
}

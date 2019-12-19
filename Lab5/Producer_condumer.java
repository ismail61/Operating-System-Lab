/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package two_two_semester;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

class Q{
    int item;
    Semaphore semcon = new Semaphore(0);
    Semaphore sempro = new Semaphore(1);
    void get(){
        try {
            semcon.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Q.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Consumer gets the item : "+item);
       sempro.release();
    }
    void put(int item){
        try {
            sempro.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Q.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.item= item;
        System.out.println("Producer produces the item : "+item);
        semcon.release();
    }
    
}
class Producer implements Runnable{

    Q q;
    Producer(Q q){
        this.q = q;
        Thread t = new Thread(this);
        t.start();
    }
    @Override
    public void run() {
        for(int i=0;i<5;i++){
            q.put(i);
        }
    }
    
}
class Consumer implements Runnable{

    Q q;
    Consumer(Q q){
        this.q = q;
        Thread t1 = new Thread(this);
        t1.start();
    }
    @Override
    public void run() {
        for(int i=0;i<5;i++){
            q.get();
        }
    }
    
}
public class Producer_condumer {
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
    }
    
}

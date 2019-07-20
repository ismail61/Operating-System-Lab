/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bank;

/**
 *
 * @author user
 */
public class class2 extends Thread {
    class1 cc;
    int amount;
   public class2(class1 cc,int amount)
   {
       this.cc=cc;
       this.amount=amount;
   }
   public void run(){
       cc.credit(amount);
   }
}

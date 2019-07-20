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
public class class1 {   
        int balance = 100000;
    synchronized void withDraw(int amount){        
                 balance -=amount;
          System.out.println("Current balance is "+balance);
       
    }
    
}


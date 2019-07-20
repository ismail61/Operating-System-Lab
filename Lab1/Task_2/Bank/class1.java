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
     private int balance = 100000;
     private boolean lock = false;   
     public void credit(int amount){        
        while(lock){           
                System.out.println(" Wait!! "+Thread.currentThread().getName());       
         }
         lock = true;           
         balance -= amount;        
         System.out.println("Current balance is "+balance+" for "+Thread.currentThread().getName());        
         lock = false;     
    }
    
}


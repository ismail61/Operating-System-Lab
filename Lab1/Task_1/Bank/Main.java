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
public class Main {
    public static int balance = 100000;
    public static void main(String[] args) {
         class1 c1 = new class1();
        class2 t1 = new class2(c1,1000);
        class2 t2 = new class2(c1,500);
        class2 t3 = new class2(c1,300);
        class2 t4 = new class2(c1,800);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
    
}

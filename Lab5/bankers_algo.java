/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package two_two_semester;

import java.util.Scanner;

public class bankers_algo {
        int[][] need;
        int[][] allocation;
        int[][] max;
        int[] available ;
        int np,nr;
    public void input(){
        Scanner sc = new Scanner(System.in);
        
        np = sc.nextInt();
        nr = sc.nextInt();
        allocation = new int[np][nr];
        max = new int[np][nr];
        need = new int[np][nr];
        available = new int[nr];
        //allocation input
        //System.out.println("Allocation : ");
        for(int i=0;i<np;i++){
            for(int j=0;j<nr;j++){
                allocation[i][j] = sc.nextInt();
            }
        }
        //max input
        //System.out.println("Max : ");
        for(int i=0;i<np;i++){
            for(int j=0;j<nr;j++){
                max[i][j] = sc.nextInt();
            }
        }
        //available input
        //System.out.println("Available : ");
           for (int j = 0; j < nr; j++) {
            available[j] = sc.nextInt();
        }
           sc.close();
    }
    public int[][] need_cal(){
        for(int i=0;i<np;i++){
            for(int j=0;j<nr;j++){
                need[i][j] = max[i][j]-allocation[i][j];
            }
        }
        return need;
    }
    public boolean check(int process){
        for(int i=0;i<nr;i++){
            if(available[i]<need[process][i])
                return false;
        }
        return true;
    }
    public void issafe(){
        input();
        need_cal();
        boolean done[]= new boolean[np];
        for(int i=0;i<np;i++){
            done[i]=false;
        }
        int j=0;
        while(j<np){          
            for(int i=0;i<np;i++){
                if(!done[i] && check(i)){
                    for(int k=0;k<nr;k++){
                        available[k]=available[k]+allocation[i][k];
                    }
                    j++;
                    System.out.println("Allocation process is : "+i);
                    done[i]=true;
                }
            } 
         
        }
        if(j==np){
            System.out.println("Safely Allocated.....");
        }
        else{
            System.out.println("ALL process cann't be allocated safely");
        }
    }
    public static void main(String[] args) {
        new bankers_algo().issafe();
    }
    
}

/*
5 3
0 1 0
2 0 0
3 0 2
2 1 1
0 0 2
7 5 3
3 2 2
9 0 2
4 2 2
5 3 3
3 3 2
*/


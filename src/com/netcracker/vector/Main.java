/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.vector;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Main {
  
    public static void main(String[] args) {
       
        Scanner sc = new Scanner (System.in);
        
        System.out.print("Input vector size = ");
        int size = sc.nextInt();
        
        ClassArrayVector av = new ClassArrayVector (size);
        ClassArrayVector bv = new ClassArrayVector (size);
        
      
        double e;
        for (int i=0; i<size; i++) {
        System.out.print("Input vector elemet ["+i+"] = ");
        e = sc.nextDouble();
        bv.a[i]=e;
        }
        
        //set Vector By  another vector (Object)
        av.setVectorByObject(bv);
        
        System.out.println(av.getSize());
        System.out.println();
        
        ClassStaticVector.bubblesort(av);
        
        System.out.println();
        
        System.out.println("Max element = " + av.getMax());
         
        System.out.println("Min element = " + av.getMin());
        
        //Set element by index:
        av.setElementByIndex(3,200);
        
        System.out.println("Get element by index = " + av.getElementByIndex(3));
        
       System.out.println(av.toString());
     
    } 
    
}

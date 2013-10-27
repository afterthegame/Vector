/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.vector;

import java.util.Arrays;
import java.util.Scanner;


/**
 *
 * @author admin
 */
public class ClassArrayVector implements InterfaceVector, Cloneable  {
       
   public  double a[];
   ClassArrayVector cv;

    
     /**
     * Конструктор
     * @param size
     */
    public ClassArrayVector (int size) {
    a = new double [size];
    }
    
     /**
     * Задает все элементы вектора (через другой массив).
     */
    @Override
    public void setVectorByAnother(double []b) throws ArrayIndexOutOfBoundsException{
        for(int i = 0; i < a.length;i++)
            a[i] = b[i];
    };
    
    /**
     * Задает все элементы вектора (через другой вектор).
     */
    @Override
    public void setVectorByObject (InterfaceVector bv) throws ArrayIndexOutOfBoundsException{
        for(int i = 0; i < a.length;i++) {
            a[i]= bv.getElementByIndex(i);
       }
    };
    
    /**
     * Возвращает все элементы вектора. Массив не клонируется.
    */
    @Override
    public double[] get() {
          return a;
    };  
    /**
     * Возвращает копию вектора (такую, изменение элементов 
     *  в которой не приводит к изменению элементов данного вектора).
     */
    @Override
     public InterfaceVector  duplicate() {
        InterfaceVector bv = new ClassArrayVector(getSize());
           for(int i = 0; i < a.length;i++) {
               bv.setElementByIndex(i, a[i]);
           }
        return bv;
    };
    /**
     * Возвращает число элементов вектора.
     */
    @Override
    public int getSize() { 
    return a.length;
    }

    /**
     * Изменяет элемент по индексу. 
     * @param index В случае выхода индекса за пределы массива:
     *  а) если index<0, ничего не происходит;
   */
    @Override 
    public  void setElementByIndex(int index, double value) {
        if (index >= 0) 
            if (index < a.length)
               a[index] = value;
    } 
    /**
     * Возвращает элемент по индексу.
     * @param index В случае выхода индекса за пределы массива 
     *   должно генерироваться ArrayIndexOutOfBoundsException
     */
    @Override
    public double getElementByIndex(int index) throws ArrayIndexOutOfBoundsException {
        return a[index];
    };

    /**
     * Возвращает максимальный элемент вектора.
     */
    @Override
    public double getMax() {
        double max = a[0];
        for(int i=0;i<a.length;i++)
            if(a[i]>max)
                max=a[i];
        return max;
    }
    /**
     * Возвращает минимальный элемент вектора.
     */
    @Override
    public double getMin() {
        double min = a[0];
        for(int i=0;i<a.length;i++)
            if(min>a[i])
                min=a[i];   
        return min;
    }

    /**
     * Умножает вектор на число
     * @param factor 
     */
    @Override
    public void mult(double factor) {
         for(int i=0; i < a.length; i++){
             a[i]*=factor;
         }
    };
    
     /**
     * Складывает вектор с другим вектором, результат запоминает в элементах данного вектора.
     * Если векторы имеют разный размер, последние элементы большего вектора не учитываются.
     * @param bv
     * @return 
     */
    @Override 
    public InterfaceVector sum(InterfaceVector bv) {
        for(int i = 0; i < a.length;i++)
            a[i]+=bv.getElementByIndex(i);
       return bv;
    };
    /**
     * Стравнивает два вектора.
     * Если вектора равны возвращает true, иначе false 

      */
    
    @Override
    public boolean cmp (InterfaceVector bv) {
        if(a.length == bv.getSize()) {
            for(int i = 0; i < a.length;i++)
                if(a[i] != bv.getElementByIndex(i)) {
                    return false;
                } 
        }  else { return false;}
      return true;
    };    
    
    @Override
    public String toString () {
       String s= "";
       for(int i=0;i<a.length;i++) 
           s+=a[i];
        return s;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null) { return false;}
         if(getClass() !=obj.getClass()) { return false;}
         if(!super.equals(obj)) { return false;}
         if(a.length == obj.getClass().getDeclaredFields().length) {
            for(int i = 0; i < a.length;i++)
                if(a[i] != obj.getClass().getDeclaredFields().length) {
                    return false;
                } 
        }  else { return false;}
      return true; 
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Arrays.hashCode(this.a);
        return hash;
    }
    
    
    @Override
     public ClassArrayVector clone() throws CloneNotSupportedException {
            ClassArrayVector newObject = (ClassArrayVector) super.clone();

            // Теперь необходимо также клонировать все ссылочные поля
            newObject.cv = this.cv.clone();
        return cv;
      }
     
     
     
      public static void main(String[] args) {
       
        Scanner sc = new Scanner (System.in);
        
        System.out.print("Input vector size = ");
        int size = sc.nextInt();
        
        InterfaceVector av = new ClassArrayVector (size);
        InterfaceVector bv = new ClassArrayVector (size);
        
      
        double e;
        for (int i=0; i<size; i++) {
        System.out.print("Input vector elemet ["+i+"] = ");
        e = sc.nextDouble();
        bv.setElementByIndex(i, e);
        }
        
        System.out.println(bv.getElementByIndex(3));
        //set Vector By  another vector (Object)
        av.setVectorByObject(bv);
        
        System.out.println(av.getSize());
        System.out.println();
        
      //  ClassStaticVector.bubblesort(av);
        
        System.out.println();
        
        System.out.println("Max element = " + av.getMax());
         
        System.out.println("Min element = " + av.getMin());
        
        //Set element by index:
        av.setElementByIndex(3,200);
        
        System.out.println("Get element by index = " + av.getElementByIndex(3));
        
       System.out.println(av.toString());
     
    } 
}


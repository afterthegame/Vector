/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.netcracker.vector;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class ClassCollectionJArrayListVector implements InterfaceVector{
 ArrayList<Double> arrayListCollection;   
 
  public ClassCollectionJArrayListVector (int size) {
    this.arrayListCollection = new ArrayList<> (size);
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
    public void setVectorByObject(ClassArrayVector bv) throws ArrayIndexOutOfBoundsException {
       for(int i = 0; i < a.length;i++)
            a[i]=bv.a[i];      
   };
    
    /**
     * Возвращает все элементы вектора. Массив не клонируется.
    */
    @Override
    public double[] get() {
          return null;
    };  
    /**
     * Возвращает копию вектора (такую, изменение элементов 
     *  в которой не приводит к изменению элементов данного вектора).
     */
    @Override
     public double[]  duplicate() {
        int size = a.length;
        double []b = new double [size];
        for(int i = 0; i < size;i++)
            b[i] = a[i];
        return b;
    };
    /**
     * Возвращает число элементов вектора.
     */
    @Override
    public int getSize() { 
    return arrayListCollection.size();
    }

    /**
     * Изменяет элемент по индексу. 
     * @param index В случае выхода индекса за пределы массива:
     *  а) если index<0, ничего не происходит;
     *  б) если index>=0, размер массива увеличивается так, чтобы index стал последним.
   */
    @Override 
    public  void setElementByIndex(int index, double value) {
        if (index >= 0) 
            if (index < arrayListCollection.size())
              arrayListCollection.set(index, value);
    } 
    /**
     * Возвращает элемент по индексу.
     * @param index В случае выхода индекса за пределы массива 
     *   должно генерироваться ArrayIndexOutOfBoundsException
     */
    @Override
    public double getElementByIndex(int index) throws ArrayIndexOutOfBoundsException {
        return arrayListCollection.get(index);
    };

    /**
     * Возвращает максимальный элемент вектора.
     */
    @Override
    public double getMax() {
        double max = arrayListCollection.get(0);
        for(int i=0;i<arrayListCollection.size();i++)
            if(arrayListCollection.get(i)>max)
                max=arrayListCollection.get(i);
        return max;
    }
    /**
     * Возвращает минимальный элемент вектора.
     */
    @Override
    public double getMin() {
         double min = arrayListCollection.get(0);
        for(int i=0;i<arrayListCollection.size();i++)
            if(arrayListCollection.get(i)<min)
                min=arrayListCollection.get(i);
        return min;
    }

    /**
     * Умножает вектор на число
     * @param factor
     */
    @Override
    public void mult(double factor) {
         for(int i=0; i < arrayListCollection.size(); i++){
             arrayListCollection.set(i, getElementByIndex(i)*factor);
         }
    };
    
     /**
     * Складывает вектор с другим вектором, результат запоминает в элементах данного вектора.
     * Если векторы имеют разный размер, последние элементы большего вектора не учитываются.
     * @param AnotherArrayListCollection
     */
    @Override 
    public void sum(InterfaceVector AnotherArrayListCollection) {
         AnotherArrayListCollection = new  ClassCollectionJArrayListVector(getSize()) ;
         for(int i=0; i < arrayListCollection.size(); i++){
             arrayListCollection.set(i, getElementByIndex(i) + AnotherArrayListCollection.getElementByIndex(i));
         }
    };
    /**
     * Стравнивает два вектора.
     * Если вектора равны возвращает true, иначе false 
      */
    
    @Override
    public boolean cmp (ClassArrayVector bv) {
        if(a.length == bv.a.length) {
            for(int i = 0; i < a.length;i++)
                if(a[i] != bv.a[i]) {
                    return false;
                } 
        }  else { return false;}
      return true;
    };    

}

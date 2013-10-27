/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.vector;

/**
 *
 * @author admin
 */
public interface InterfaceVector {
    
     /**
     * Задает все элементы вектора (через другой массив).
     * @param b
     */
    public void setVectorByAnother(double []b) throws ArrayIndexOutOfBoundsException;
    
    /**
     * Задает все элементы вектора (через другой вектор).
     * @param bv
     */
    public void setVectorByObject(InterfaceVector bv) throws ArrayIndexOutOfBoundsException;
    
    /**
     * Возвращает все элементы вектора. Массив не клонируется.
     * @return 
    */
    public double[] get();
    /**
     * Возвращает копию вектора (такую, изменение элементов 
     *  в которой не приводит к изменению элементов данного вектора).
     * @return 
     */
     public InterfaceVector  duplicate();
    /**
     * Возвращает число элементов вектора.
     * @return 
     */
    public int getSize();

    /**
     * Изменяет элемент по индексу. 
     * @param index В случае выхода индекса за пределы массива:
     *  а) если index<0, ничего не происходит;
     * @param value
   */
     public  void setElementByIndex(int index, double value);
    /**
     * Возвращает элемент по индексу.
     * @param index В случае выхода индекса за пределы массива 
     *   должно генерироваться ArrayIndexOutOfBoundsException
     * @return 
     */
    public double getElementByIndex(int index) throws ArrayIndexOutOfBoundsException;

    /**
     * Возвращает максимальный элемент вектора.
     * @return 
     */
    public double getMax();
    /**
     * Возвращает минимальный элемент вектора.
     * @return 
     */
    public double getMin();
    
    /**
     * Сортирует элементы вектора в порядке возрастания.
     */
   // public void bubblesort();
    
    /**
     * Умножает вектор на число
     * @param factor 
     */
    public void mult(double factor);
    
     /**
     * Складывает вектор с другим вектором, результат запоминает в элементах данного вектора.
     * Если векторы имеют разный размер, последние элементы большего вектора не учитываются.
     * @param bv Не равен null
     * @return 
     */
     
   public InterfaceVector sum(InterfaceVector bv);
     /**
     * Сравнивает два вектора.
     * Если вектора равны возвращает true, иначе false 
     * @param bv Не равен null
      */

    /**
     * Сравнивает два вектора.Если вектора равны возвращает true, иначе false
     * @param bv Не равен null
     * @return
     */
    public boolean cmp (InterfaceVector bv);

    @Override
    public String toString ();

    @Override
    public boolean equals(Object obj);

    @Override
    public int hashCode();
    
}
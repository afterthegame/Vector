/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.vector;

import java.util.LinkedList;

/**
 *
 * @author admin
 */
public class ClassCollectionJLinkedListVector implements InterfaceVector {

    LinkedList<Double> linkedListCollection;

    public ClassCollectionJLinkedListVector() {
        this.linkedListCollection = new LinkedList<>();
    }

    public void addNodeAfterHead(double value) {
        linkedListCollection.add(value);
    }

    public void addNodeAfterIndex(int index, double value) {
        linkedListCollection.add(index, value);
    }

    /**
     * Задает все элементы вектора (через другой массив).
     */
    @Override
    public void setVectorByAnother(double[] b) throws ArrayIndexOutOfBoundsException {
        int i = 0;
        lvTemp = lvHead;
        while (i != getSize()) {
            lvTemp.value = b[i];
        }
    }

    ; 
    
    /**
     * Задает все элементы вектора (через другой вектор).
     * @param llv
    */    
    @Override
    public void setVectorByObject(InterfaceVector llv) throws ArrayIndexOutOfBoundsException {
        int i = 0;
        lvTemp = lvHead;
        while (i != getSize()) {
            lvTemp.value = llv.getElementByIndex(i);
        }
    }

    ; 
    
    /**
     * Возвращает все элементы вектора. Массив не клонируется.
    */
    @Override
    public double[] get() {
        return null;
    }

    ; 
    
    /**
     * Возвращает копию вектора (такую, изменение элементов 
     *  в которой не приводит к изменению элементов данного вектора).
    */ 
    @Override
    public InterfaceVector duplicate() {
        InterfaceVector blv;
        blv = new ClassLinkedListVector();
        int i = 0;
        lvTemp = lvHead;
        while (i != getSize()) {
            lvTemp.value = blv.getElementByIndex(i);
        }
        return blv;
    }

    ; 
    
    /**
     * Возвращает число элементов вектора.
     */
    @Override
    public int getSize() {
       return linkedListCollection.size();
    }

    /**
     * Изменяет элемент по индексу.
     *
     * @param index В случае выхода индекса за пределы массива: а) если index<0,
     * ничего не происходит;
     */
    @Override
    public void setElementByIndex(int index, double value) {
        linkedListCollection.set(index, value);
    }

    /**
     * Возвращает элемент по индексу.
     *
     * @param index В случае выхода индекса за пределы массива должно
     * генерироваться ArrayIndexOutOfBoundsException
     */
    @Override
    public double getElementByIndex(int index) throws ArrayIndexOutOfBoundsException {
        return linkedListCollection.get(index);
    }

    ;

    /**
     * Возвращает максимальный элемент вектора.
     * @return 
    */     
   
    @Override
    public double getMax() {
        int i = 0;
        lvTemp = lvHead;
        double max = lvTemp.value;
        while (i != getSize()) {
            lvTemp = lvTemp.next;
            i++;

            if (lvTemp.value > max) {
                max = lvTemp.value;
            }
        }
        return max;
    }

    /**
     * Возвращает минимальный элемент вектора.
     */

    /**
     * Возвращает минимальный элемент вектора.
     *
     * @return
     */
    @Override
    public double getMin() {
        int i = 0;
        lvTemp = lvHead;
        double min = lvTemp.value;
        while (i != getSize()) {
            lvTemp = lvTemp.next;
            i++;

            if (min > lvTemp.value) {
                min = lvTemp.value;
            }
        }
        return min;
    }

    /**
     * Умножает вектор на число
     *
     * @param factor
     */
    @Override
    public void mult(double factor) {
        int i = 0;
        lvTemp = lvHead;
        while (i != getSize()) {
            lvTemp.value *= factor;
        }
    }

    ; 
    
     /**
     * Складывает вектор с другим вектором, результат запоминает в элементах данного вектора.
     * Если векторы имеют разный размер, последние элементы большего вектора не учитываются.
     * @param llv
     */
    @Override
    public InterfaceVector sum(InterfaceVector llv) {
        int i = 0;
        lvTemp = lvHead;
        while (i != getSize()) {
            lvTemp.value += llv.getElementByIndex(i);
        }
        return llv;
    }

    ; 
    /**
     * Стравнивает два вектора.
     * Если вектора равны возвращает true, иначе false 
     * @param llv
     * @return 
     */
    
    @Override
    public boolean cmp(InterfaceVector llv) {
        if (getSize() == llv.getSize()) {
            int i = 0;
            lvTemp = lvHead;
            while (i != getSize()) {
                if (lvTemp.value != llv.getElementByIndex(i)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
;

}

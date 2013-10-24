/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.vector;

/**
 *
 * @author admin
 */
public class  ClassLinkedListVector implements InterfaceVector
{
    ClassLinkedListVector cllv;
    /* Объекты этого класса - отдельные элементы списка */ 
    class ListVector
    {
    private double value; //значение элемента списка
           
    public ListVector next; //Ссылка на следующий элемент списка
    public ListVector prev; //Ссылка на предидущий элемент списка
        
    public double getValue() {
        return value;
    }
    
    public void setValue(double value) {
        this.value = value;
    }
    }
 
    private int length;    // Размер списка
    public ListVector lvHead; //Ссылка на первый элемент списка
     // временные ссылки, для построения списка
    public ListVector lvTemp;
    public ListVector lvNext;
    public ListVector lvBox; 
     
     // Конструктор для создания единичного вектора 
    public ClassLinkedListVector(double value) { 
    length = 1;
    lvHead = new ListVector();
    
    lvHead.setValue(value);
    lvHead.next = lvHead;
    lvHead.prev = lvHead;
    }
    
    // Конструктор для создания вектора размерности больше единицы
    public ClassLinkedListVector(double ... value) {
    length = value.length;
    
    lvHead = new ListVector();
    lvHead.setValue(value[0]);
    
       lvTemp = lvHead;
    for (int i=1 ; i < length ; i++) {
        lvTemp.next = new ListVector();
        lvBox = lvTemp;
        lvTemp = lvTemp.next;
        lvTemp.prev = lvBox;  
        lvTemp.setValue(value[i]);
    } 
    //После выполнения последней строчки в последней итерации цикла, 
    //lvTemp ссылается на последний элемент в списке.
    lvTemp.next = lvHead; //Появляется ссылка на первый элемент
    lvHead.prev = lvTemp;
    }
    
    
    public void addNodeAfterHead (double value) {
       
        
        lvTemp = lvHead;
        lvNext = lvTemp.next;
        
        
        lvTemp.next = new ListVector();
        lvBox = lvTemp;
        lvTemp = lvTemp.next;
        lvTemp.prev = lvBox;  
        lvTemp.next = lvNext;
        lvNext.prev = lvTemp;
        lvTemp.setValue(value);
    
     }
   
        public void addNodeAfterIndex (int index, double value) {
            
            if(index == 1) {
                addNodeAfterHead(value); 
            } else {

            
            int i = 0;
            lvTemp = lvHead;
            
            while (i!=index - 1) {
            lvTemp = lvTemp.next;
            i++;
            }
            
            lvNext = lvTemp.next;


            lvTemp.next = new ListVector();
            lvBox = lvTemp;
            lvTemp = lvTemp.next;
            lvTemp.prev = lvBox;  
            lvTemp.next = lvNext;
            lvNext.prev = lvTemp;
            lvTemp.setValue(value);
            }
         }
    
        
        /**
     * Задает все элементы вектора (через другой массив).
     */
        
    @Override
    public void setVectorByAnother(double []b) throws ArrayIndexOutOfBoundsException{
       int i = 0;
       lvTemp = lvHead;
       while (i!= getSize()) 
            lvTemp.value = b[i];
    }; 
    
    /**
     * Задает все элементы вектора (через другой вектор).
     * @param llv
 */    
    //@Override
    public void setVectorByObject(ClassLinkedListVector llv) throws ArrayIndexOutOfBoundsException {
       int i = 0;
       lvTemp = lvHead;
       while (i!= getSize()) 
            lvTemp.value=llv.lvTemp.value;      
   }; 
    
    /**
     * Возвращает все элементы вектора. Массив не клонируется.
    */
  //  @Override
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
        //int size = getSize();
        //double []b = new double [size];
        //for(int i = 0; i < size;i++)
        //    b[i] = lvTemp;
        return null;
    }; 
    
    /**
     * Возвращает число элементов вектора.
     */
    @Override
    public int getSize() { 
        int size = 0;
        lvTemp = lvHead.next;

        while ( lvTemp != lvHead) {
        lvTemp = lvTemp.next;
        size++;
        }
        
    return size;
    }

    /**
     * Изменяет элемент по индексу. 
     * @param index В случае выхода индекса за пределы массива:
     *  а) если index<0, ничего не происходит;
     *  б) если index>=0, размер массива увеличивается так, чтобы index стал последним.
   */
    @Override 
    public  void setElementByIndex(int index, double value) {
        if (index <= getSize()) {
            int i = 0;
            lvTemp = lvHead;
            
            while (i!=index) {
            lvTemp = lvTemp.next;
            i++;
            }
            lvTemp.setValue(value);
            }
    } 
    /**
     * Возвращает элемент по индексу.
     * @param index В случае выхода индекса за пределы массива 
     *   должно генерироваться ArrayIndexOutOfBoundsException
     */
    @Override
    public double getElementByIndex(int index) throws ArrayIndexOutOfBoundsException {
            double value = 0;
            if (index <= getSize()) {
            int i = 0;
            lvTemp = lvHead;
            
            while (i!=index) {
            lvTemp = lvTemp.next;
            i++;
            }
            value = lvTemp.getValue();
            }
   
        return value;
    };

    /**
     * Возвращает максимальный элемент вектора.
     * @return 
    */     
   
    @Override
    public double getMax() {
        int i = 0;
        lvTemp = lvHead;
        double max = lvTemp.value;
        while (i!=getSize()) {
            lvTemp = lvTemp.next;
            i++;
         
            if(lvTemp.value>max)
                max=lvTemp.value;
        }
        return max;
    }
    /**
     * Возвращает минимальный элемент вектора.
     */

    /**
     * Возвращает минимальный элемент вектора.
     * @return
     */
    @Override
    public double getMin() {
        int i = 0;
        lvTemp = lvHead;
        double min = lvTemp.value;
       while (i!=getSize()) {
            lvTemp = lvTemp.next;
            i++;
         
            if(min>lvTemp.value)
                min=lvTemp.value;
       }
        return min;
    } 

    /**
     * Умножает вектор на число
     * @param factor
     * @return Ссылка на себя (результат сложения)
     */
    
    @Override
    public void mult(double factor) {
         int i = 0;
        lvTemp = lvHead;
       while (i!=getSize()) {
             lvTemp.value*=factor;
         }
    }; 
    
     /**
     * Складывает вектор с другим вектором, результат запоминает в элементах данного вектора.
     * Если векторы имеют разный размер, последние элементы большего вектора не учитываются.
     * @param llv
     */
    @Override 
    public void sum(ClassLinkedListVector llv) {
        int i = 0;
        lvTemp = lvHead;
       while (i!=getSize()) 
            lvTemp.value+=llv.lvTemp.value; 
    }; 
    /**
     * Стравнивает два вектора.
     * Если вектора равны возвращает true, иначе false 
     * @param llv
     * @return 
     */
    
   // @Override
    public boolean cmp (ClassLinkedListVector llv) {
        if(getSize() == llv.getSize()) {
        int i = 0;
        lvTemp = lvHead;
       while (i!=getSize()) 
                if(lvTemp.value != llv.lvTemp.value) {
                    return false;
                } 
        }  else { return false;}
      return true;
    };       
        

     public static void main(String[] args) {
        ClassLinkedListVector vector3 = new ClassLinkedListVector(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        vector3.addNodeAfterIndex(10,999);
       //   vector3.addNodeAfterHead(999);
        
        ClassLinkedListVector.ListVector t = vector3.lvHead;
        for (int i = 0; i < 15; i++) {
            System.out.print(t.getValue() + " ");
            t = t.next;
        }
       
      
        System.out.println();
        for (int i = 0; i < 15; i++) {
            System.out.print(t.getValue() + " ");
            t = t.prev;
        }
    } 
} 
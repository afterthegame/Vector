/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.vector;

/**
 *
 * @author admin
 */

public abstract class ClassStaticVector implements InterfaceVector{
    /**
     * Сортирует элементы вектора в порядке возрастания.
     * @param bv
    */
    
    public static  void bubblesort(InterfaceVector bv){
        double t, k;
        for(int i = bv.getSize()-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if( bv.getElementByIndex(j) > bv.getElementByIndex(j+1) ) {
                 t = bv.getElementByIndex(i);
                 k = bv.getElementByIndex(j);
                 bv.setElementByIndex(i, k);
                 bv.setElementByIndex(j, t);
            }
        }
      }
    }  
    
      /**
     * Умножает вектор на число
     * @param bv
     * @param factor
     * @return 
     */

    public static InterfaceVector mult(InterfaceVector bv, double factor) {
         for(int i=0; i < bv.getSize(); i++){
             bv.setElementByIndex(i, factor);
         }
          return bv;
    };
    
     /**
     * Складывает вектор с другим вектором, результат запоминает в элементах данного вектора.
     * Если векторы имеют разный размер, последние элементы большего вектора не учитываются.
     * @param bv
     * @param cv Не равен null
     * @return Ссылка на себя (результат сложения)
     */

    public static InterfaceVector sum(InterfaceVector bv, InterfaceVector cv) {
        double k;
        for(int i = 0; i < bv.getSize();i++) {
        k = cv.getElementByIndex(i);
        bv.setElementByIndex(i, k);
        }
        return bv;
    };
    
    public static InterfaceVector randomSet(InterfaceVector bv) {
         for(int i=0; i < bv.getSize(); i++){
             bv.setElementByIndex(i,Math.random());
           }
          return bv;
    };
}

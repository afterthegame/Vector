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
     * @param av
    */
    
    public static  void bubblesort(ClassArrayVector av){
        for(int i = av.a.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if( av.a[j] > av.a[j+1] ) {
                 double t = av.a[i];
                 av.a[i] = av.a[j];
                 av.a[j] = t;
            }
        }
      }
    }  
    
      /**
     * Умножает вектор на число
     * @param av
     * @param factor
     * @return 
     */

    public static ClassArrayVector mult(ClassArrayVector av, double factor) {
         for(int i=0; i < av.a.length; i++){
             av.a[i]*=factor;
         }
          return av;
    };
    
     /**
     * Складывает вектор с другим вектором, результат запоминает в элементах данного вектора.
     * Если векторы имеют разный размер, последние элементы большего вектора не учитываются.
     * @param av
     * @param bv Не равен null
     * @return Ссылка на себя (результат сложения)
     */

    public static ClassArrayVector sum(ClassArrayVector av, ClassArrayVector bv) {
        for(int i = 0; i < av.a.length;i++)
            av.a[i]+=bv.a[i]; 
        return av;
    };
}

package algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @program: Demo
 * @Date: 2019/3/21 23:44
 * @Author: JcLi
 * @Description: 选择排序
 */
public class SelectionSort {

    @Test
    public void sort1(){
        int[] array = {5,6,4,3,1,9,2,7,8};
        for (int i = 0; i < array.length-1; i++) {
            int k = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[k]>array[j]){
                    k = j;
                }
            }
            if(k!=i){
                int temp = array[i];
                array[i] = array[k];
                array[k] = temp;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}

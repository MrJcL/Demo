package algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @program: Demo
 * @Date: 2019/3/23 13:09
 * @Author: JcLi
 * @Description: 插入排序
 */
public class InsertionSort {

    @Test
    public void sort1(){
        int[] array = {5,6,4,3,1,9,2,7,8};
        System.out.println(Arrays.toString(array));
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if(array[i]<array[j]){
                    int temp = array[i];
//                    for (int k = j; k < i ; k++) {
//                        array[i-k+j] = array[i-k+j-1];
//                    }
                    for (int k = i; k > j ; k--) {
                        array[k] = array[k-1];
                    }
                    array[j] = temp;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void sort2(){
        int[] array = {5,6,4,3,1,9,2,7,8};
        System.out.println(Arrays.toString(array));
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i-1;
            while (j>=0 && temp<array[j]){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = temp;
        }
        System.out.println(Arrays.toString(array));
    }
}

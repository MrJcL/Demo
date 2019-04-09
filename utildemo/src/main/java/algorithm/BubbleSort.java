package algorithm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: Demo
 * @Date: 2019/3/21 21:51
 * @Author: JcLi
 * @Description:
 */
public class BubbleSort {

    @Test
    public void sort1(){
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(2);
        list.add(4);
        list.add(7);
        list.add(5);
        System.out.println(list.toString());
        for (int i = list.size(); i >0; i--) {
            for (int j = 0; j < i-1; j++) {
                if(list.get(j)>list.get(j+1)){
                    int temp = list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,temp);
                }
            }

        }
        System.out.println(list.toString());
    }

    @Test
    public void sort2(){
        int[] list = {5,6,4,3,1,9,2,7,8};
        System.out.println(Arrays.toString(list));
        for (int i = list.length; i >0; i--) {
            for (int j = 0; j < i-1; j++) {
                if(list[j]>list[j+1]){
                    int temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(list));
    }

    @Test
    public void sort3(){
        int[] array = {5,6,4,3,1,9,2,7,8};
        int temp;
        int low = 0;
        int high = array.length-1;
        int counter = 1;
        while(low<high){
            for(int i=low;i<high;++i){   //正向冒泡，确定最大值
                if(array[i]>array[i+1]){  //如果前一位大于后一位，交换位置
                    temp= array[i];
                    array[i]= array[i+1];
                    array[i+1]= temp;
                }
            }
            --high;

            for(int j=high;j>low;--j){   //反向冒泡，确定最小值
                if(array[j]<array[j-1]){  //如果前一位大于后一位，交换位置
                    temp= array[j];
                    array[j]= array[j-1];
                    array[j-1]= temp;
                }
            }
            ++low;

            System.out.print("第"+counter+"轮排序结果：");
            System.out.println(Arrays.toString(array));
            counter++;
        }
    }

    @Test
    public void sort4(){
        int[] array = {5,6,4,3,1,9,2,7,8};
        int len = array.length;
        int temp;
        for(int i=0;i<len-1;i++){
            boolean exchange = false;  //设置交换变量
            for(int j=1;j<len-i;j++){
                if(array[j-1]>array[j]){  //如果前一位大于后一位，交换位置
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;

                    if(!exchange) exchange =true;  //发生了交换操作
                }
            }
            System.out.print("第"+(i+1)+"轮排序结果：");
            System.out.println(Arrays.toString(array));
            if(!exchange) break;  //如果上一轮没有发生交换数据，证明已经是有序的了，结束排序
        }

    }
}

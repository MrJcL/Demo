package common;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Demo
 * @Date: 2019/3/11 22:37
 * @Author: JcLi
 * @Description:
 */
public class Test1 {

    @Test
    public void t1(){
        ok:
        for (int i = 0; i < 10; i++) {
            for(int j=0; j<10; j++){
                System.out.println("j:"+j);
                if(j==5){
                    break ok;
                }
            }
        }
    }

    @Test
    public void t2(){
        String  type = "";
               switch (type) {
                   case "a":
                       break;

               }
    }

    @Test
    public void t3(){
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        List<String> list2 = list1;
        list2.add("b");
        System.out.println(list1.toString());
        System.out.println(list2.toString());
    }

    @Test
    public void t4(){
        int i=0;
        i = i++;
        System.out.println(i);
    }
    @Test
    public void t4_1(){
        int i=0;
        int temp;
        temp = i;
        i=i+1;
        i = temp;
        System.out.println(i);
    }

    @Test
    public void t5(){
        int i=0;
        System.out.println(i++);
        System.out.println(i);
    }

    @Test
    public void t6(){
        int i=0;
        i++;
        System.out.println(i);
        int j=0;
        ++j;
        System.out.println(j);
    }

    @Test
    public void t7(){
        int i=0;
        i = i++;
        System.out.println(i);
        int j=0;
        System.out.println(++j);

    }
}

package practice;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @program: Demo
 * @Date: 2019/3/8 15:12
 * @Author: LiJc
 * @Description:
 */
public class ForDeleteList {

    /**
     * 由于删除元素后list.size()大小发生改变，导致无法完整删除
     */
    @Test
    public void test1(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        for (int i=0; i<list.size(); i++){
            list.remove(i);
        }
        System.out.println(list.toString());
    }

    /**
     * 正常删除
     */
    @Test
    public void test1_1(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        for (int i=0; i<list.size();){
            list.remove(i);
        }
        System.out.println(list.toString());
    }

    /**
     * 由于删除元素后list.size()大小发生改变，导致删除时数组越界
     * java.lang.IndexOutOfBoundsException: Index: 3, Size: 2
     */
    @Test
    public void test2(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        int num = list.size();
        for (int i=0; i<num; i++){
            list.remove(i);
        }
    }

    /**
     * 从后往前遍历删除，可以正常删除
     */
    @Test
    public void test3(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        for (int i=list.size()-1; i>=0; i--){
            list.remove(i);
        }
        System.out.println(list.toString());
    }

    /**
     * 从后往前遍历删除，可以正常删除
     */
    @Test
    public void test4(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        System.out.println(list.toString());
        for (int i=list.size()-1; i>=0; i--){
            // 删除第3个元素
            if(i==2){
                list.remove(i);
            }
        }
        System.out.println(list.toString());
    }
    /**
     * 从后往前遍历删除(补充)
     */
    @Test
    public void test4_1(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        System.out.println(list.toString());
        for (int i=list.size()-1; i>=0; i--){
            list.remove("3");
        }
        System.out.println(list.toString());
    }

    /**
     * 从后往前遍历删除，可以正常删除
     */
    @Test
    public void test5(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        System.out.println(list.toString());//[1, 2, 3, 4, 5]
        for (int i=list.size()-1; i>=0; i--){
            // 删除第3和第4个元素
            if(i==2||i==3){
                list.remove(i);
            }
        }
        System.out.println(list.toString());//[1, 2, 5]
    }

    /**
     * 从后往前遍历删除，同时删除两个元素
     */
    @Test
    public void test6(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        System.out.println(list.toString());//[1, 2, 3, 4, 5]
        for (int i=list.size()-1; i>=0; i--){
            if(i==2){
                list.remove(i);
                list.remove(i+1);
            }
        }
        System.out.println(list.toString());//[1, 2, 4]//实际上删除了第3和第5个元素
    }

    /**
     * 从后往前遍历删除，同时删除两个元素，数组越界
     * java.lang.IndexOutOfBoundsException: Index: 4, Size: 4
     */
    @Test
    public void test7(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        System.out.println(list.toString());//[1, 2, 3, 4, 5]
        for (int i=list.size()-1; i>=0; i--){
            if(i==3){
                list.remove(i);
                list.remove(i+1);
            }
        }
        System.out.println(list.toString());//实际上删除了第4个元素的时候i=3；i+1=4；
                                            // list.size()=4;list.remove(4)发送数组越界异常
    }

    /**
     * foreach遍历删除，同时修改异常
     * java.util.ConcurrentModificationException
     * 因为元素在使用的时候发生了并发的修改，导致异常抛出。但是删除完毕马上使用break跳出，则不会触发报错。
     * 在Java中的foreach循环的工作原理就像一个iterator
     * 首次进入到foreach循环时，ArrayList创建一个内部迭代器类对象，以后循环就不再创建。
     * 每次循环的流程都是先调用迭代器对象的hasNext()方法，返回true，再调用next()方法，而每次调用next()方法时，首先会检测集合修改。
     */
    @Test
    public void test8(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        System.out.println(list.toString());//[1, 2, 3, 4, 5]
        for (String a : list) {
            list.remove(a);
        }
        System.out.println(list.toString());
    }

    /**
     * Iterator遍历，正常删除
     */
    @Test
    public void test9(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        System.out.println(list.toString());//[1, 2, 3, 4, 5]
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String x = it.next();
            it.remove();
        }
        System.out.println(list.toString());
    }

    /**
     * Iterator遍历,删除出错
     * java.util.ConcurrentModificationException
     */
    @Test
    public void test10(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        System.out.println(list.toString());//[1, 2, 3, 4, 5]
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String x = it.next();
            list.remove(x);
        }
        System.out.println(list.toString());
    }

    /**
     * Iterator遍历，正常删除
     */
    @Test
    public void test11(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        System.out.println(list.toString());//[1, 2, 3, 4, 5]
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String x = it.next();
            if(x.equals("2")||x.equals("5")){
                it.remove();
            }
        }
        System.out.println(list.toString());
    }

}

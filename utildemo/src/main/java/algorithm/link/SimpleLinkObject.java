package algorithm.link;

/**
 * @program: Demo
 * @Date: 2019/9/11 23:11
 * @Author: JcLi
 * @Description: 简单的链表对象
 */
public class SimpleLinkObject {

    public String name;
    public SimpleLinkObject next;

    public SimpleLinkObject(String name) {
        this.name = name;
    }

    public void display(){
        System.out.print("name:" + name + "; ");
    }
}

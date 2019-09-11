package algorithm.link;

/**
 * @program: Demo
 * @Date: 2019/9/11 23:15
 * @Author: JcLi
 * @Description: 简单的单链表
 */
public class SimpleSinglyLinkList {

    private SimpleLinkObject first;

    /**
     * 从链表头插入
     * @param name
     */
    public void insertFirst(String name) {
        SimpleLinkObject simpleLinkObject = new SimpleLinkObject(name);
        simpleLinkObject.next = first;
        first = simpleLinkObject;
    }

    /**
     * 从链表头删除并返回元素
     * @return
     */
    public SimpleLinkObject deleteFirst() {
        SimpleLinkObject temp = first;
        first = first.next;
        return temp;
    }

    public boolean isEmpty() {
        return first == null;
    }

    /**
     * 打印链表
     */
    public void displayList() {
        System.out.print("displayList-->: ");
        SimpleLinkObject current = first;
        while (current!=null) {
            current.display();
            current = current.next;
        }
    }
}

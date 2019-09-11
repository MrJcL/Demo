package practice;

import algorithm.link.SimpleSinglyLinkList;
import org.junit.jupiter.api.Test;

/**
 * @program: Demo
 * @Date: 2019/9/11 23:26
 * @Author: JcLi
 * @Description:
 */
public class LinkTest {

    @Test
    public void t1() {
        SimpleSinglyLinkList simpleSinglyLinkList = new SimpleSinglyLinkList();
        simpleSinglyLinkList.insertFirst("张山");
        simpleSinglyLinkList.insertFirst("李斯");
        simpleSinglyLinkList.insertFirst("王武");
        simpleSinglyLinkList.insertFirst("马柳");

        simpleSinglyLinkList.displayList();
        System.out.println();

        while (!simpleSinglyLinkList.isEmpty()) {
            simpleSinglyLinkList.deleteFirst().display();
        }
        System.out.println();
        simpleSinglyLinkList.displayList();
    }
}

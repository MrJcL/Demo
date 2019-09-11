package practice;

import algorithm.queue.PriorityQueueArray;
import algorithm.queue.QueueInt;
import org.junit.jupiter.api.Test;

/**
 * @program: Demo
 * @Date: 2019/9/9 22:29
 * @Author: JcLi
 * @Description:
 */
public class QueueTest {

    @Test
    public void t1() {
        QueueInt queueInt = new QueueInt(10);
        int i = 1;
        while (!queueInt.isFull()) {
            queueInt.insert(i++*10);
        }
        System.out.println("size:"+queueInt.size());
        System.out.println(queueInt.peekFront());
        System.out.println("size:"+queueInt.size());
        while (!queueInt.isEmpty()) {
            System.out.println(queueInt.remove());
        }
        System.out.println("size:"+queueInt.size());
    }

    @Test
    public void t2(){
        PriorityQueueArray priorityQueueArray = new PriorityQueueArray(10);
        priorityQueueArray.insert(3);
        priorityQueueArray.insert(2);
        priorityQueueArray.insert(5);
        priorityQueueArray.insert(1);
        priorityQueueArray.insert(8);
        priorityQueueArray.insert(6);
        priorityQueueArray.insert(2);

        while (!priorityQueueArray.isEmpty()) {
            System.out.println(priorityQueueArray.remove());
        }
    }
}

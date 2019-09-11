package algorithm.queue;

/**
 * @program: Demo
 * @Date: 2019/9/9 23:01
 * @Author: JcLi
 * @Description: 用数组形式实现优先级队列
 */
public class PriorityQueueArray {
    private int maxSize;
    private int[] queueInts;
    // 记录队列元素个数
    private int count;

    public PriorityQueueArray(int maxSize) {
        this.maxSize = maxSize;
        queueInts = new int[this.maxSize];
        count = 0;
    }

    public void insert(int i) {
        if (count == 0) {
            queueInts[count] = i;
        } else {
            for (int j = count - 1; j >= 0; j--) {
                if (i >= queueInts[j]) { // > or >=
                    queueInts[j + 1] = queueInts[j];
                    if(j==0){
                        queueInts[j] = i;
                    }
                } else {
                    queueInts[j+1] = i;
                    break;
                }
            }
//            int j;
//            for (j = count - 1; j >= 0; j--) {
//                if (i > queueInts[j]) {
//                    queueInts[j + 1] = queueInts[j];
//                } else {
//                    break;
//                }
//            }
//            queueInts[j+1] = i;
        }
        count++;
    }

    public int remove() {
        return queueInts[--count];
    }

    public int peek() {
        return queueInts[count - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == maxSize;
    }
}

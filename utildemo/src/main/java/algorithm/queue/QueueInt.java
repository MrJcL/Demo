package algorithm.queue;

/**
 * @program: Demo
 * @Date: 2019/9/9 22:05
 * @Author: JcLi
 * @Description: 简单int数组类型队列
 */
public class QueueInt {

    private int maxSize;
    private int[] queueInts;
    // 记录队列元素个数
    private int count;
    // 队头
    private int front;
    // 队尾
    private int rear;

    public QueueInt(int maxSize) {
        this.maxSize = maxSize;
        queueInts = new int[this.maxSize];
        front = 0;
        rear = -1;
        count = 0;
    }

    /**
     * 插入值到队尾
     *
     * @param i
     */
    public void insert(int i) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queueInts[++rear] = i;
        count++;
    }

    /**
     * 删除队头值
     */
    public int remove() {
        int temp = queueInts[front++];
        if (front == maxSize) {
            front = 0;
        }
        count--;
        return temp;
    }

    /**
     * 查看队头值
     */
    public int peekFront() {
        return queueInts[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == maxSize;
    }

    public int size() {
        return count;
    }
}

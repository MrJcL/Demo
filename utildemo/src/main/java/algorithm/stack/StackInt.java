package algorithm.stack;

/**
 * @program: Demo
 * @Date: 2019/9/7 23:07
 * @Author: JcLi
 * @Description: 栈
 */
public class StackInt {

    // 数组大小
    private int maxSize;
    // int数组
    private int[] arrayInts;
    // 栈顶索引
    private int top;

    public StackInt(int maxSize){
        this.maxSize = maxSize;
        arrayInts = new int[this.maxSize];
        top = -1;
    }

    /**
     * 入栈
     * @param i
     */
    public void push(int i) {
        arrayInts[++top] = i;
    }

    /**
     * 出栈
     */
    public int pop() {
        return arrayInts[top--];
    }

    /**
     * 获取栈顶值
     */
    public int peek() {
        return arrayInts[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize-1;
    }
}

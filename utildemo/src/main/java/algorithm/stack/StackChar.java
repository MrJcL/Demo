package algorithm.stack;

/**
 * @program: Demo
 * @Date: 2019/9/7 23:07
 * @Author: JcLi
 * @Description: 栈
 */
public class StackChar {

    // 数组大小
    private int maxSize;
    // String数组
    private char[] arrayInts;
    // 栈顶索引
    private int top;

    public StackChar(int maxSize){
        this.maxSize = maxSize;
        arrayInts = new char[this.maxSize];
        top = -1;
    }

    /**
     * 入栈
     * @param c
     */
    public void push(char c) {
        arrayInts[++top] = c;
    }

    /**
     * 出栈
     */
    public char pop() {
        return arrayInts[top--];
    }

    /**
     * 获取栈顶值
     */
    public char peek() {
        return arrayInts[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize-1;
    }
}

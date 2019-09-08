package algorithm.stack;

/**
 * @program: Demo
 * @Date: 2019/9/7 23:07
 * @Author: JcLi
 * @Description: 栈
 */
public class StackString {

    // 数组大小
    private int maxSize;
    // String数组
    private String[] arrayInts;
    // 栈顶索引
    private int top;

    public StackString(int maxSize){
        this.maxSize = maxSize;
        arrayInts = new String[this.maxSize];
        top = -1;
    }

    /**
     * 入栈
     * @param s
     */
    public void push(String s) {
        arrayInts[++top] = s;
    }

    /**
     * 出栈
     */
    public String pop() {
        return arrayInts[top--];
    }

    /**
     * 获取栈顶值
     */
    public String peek() {
        return arrayInts[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize-1;
    }
}

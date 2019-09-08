package algorithm.stack;

/**
 * @program: Demo
 * @Date: 2019/9/7 23:38
 * @Author: JcLi
 * @Description: 利用栈进行单词反转
 */
public class Reverser {

    private String input;

    public Reverser(String input) {
        this.input = input;
    }

    public String doRev() {
        StackChar stackChar = new StackChar(input.length());
        char[] inputs = input.toCharArray();
        for (char s : inputs) {
            stackChar.push(s);
        }
        String outPut = "";
        while (!stackChar.isEmpty()) {
            outPut += stackChar.pop();
        }
        return outPut;
    }
}

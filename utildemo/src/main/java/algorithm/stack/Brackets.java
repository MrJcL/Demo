package algorithm.stack;

/**
 * @program: Demo
 * @Date: 2019/9/8 0:05
 * @Author: JcLi
 * @Description: 利用栈实现判断括号是否闭合 （  包括大括号"{}"，中括号"[]"，小括号"()"  ）
 */
public class Brackets {

    private final static char BracesLeft = '{';
    private final static char BracesRight = '}';
    private final static char MiddleLeft = '[';
    private final static char MiddleRight = ']';
    private final static char ParenthesesLeft = '(';
    private final static char ParenthesesRight = ')';

    private String input;

    public Brackets(String input) {
        this.input = input;
    }

    /**
     * 判断字符串包含的括号是否都闭合
     *
     * @return
     */
    public boolean isClosed() {
        StackChar stackChar = new StackChar(input.length());
        char[] inputs = input.toCharArray();
        for (char s : inputs) {
            if (BracesLeft == s || MiddleLeft == s || ParenthesesLeft == s) {
                stackChar.push(s);
            } else if (BracesRight == s || MiddleRight == s || ParenthesesRight == s) {
                if (getLeft(s) == stackChar.peek()) {
                    stackChar.pop();
                } else {
                    return false;
                }
            }
        }
        return stackChar.isEmpty() ? true : false;
    }

    private char getLeft(char s) {
        char left = ' ';
        switch (s) {
            case BracesRight:
                left = BracesLeft;
                break;
            case MiddleRight:
                left = MiddleLeft;
                break;
            case ParenthesesRight:
                left = ParenthesesLeft;
                break;
        }
        return left;
    }
}

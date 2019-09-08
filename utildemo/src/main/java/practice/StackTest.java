package practice;

import algorithm.stack.Brackets;
import algorithm.stack.Reverser;
import algorithm.stack.StackInt;
import org.junit.jupiter.api.Test;

/**
 * @program: Demo
 * @Date: 2019/9/7 23:24
 * @Author: JcLi
 * @Description:
 */
public class StackTest {

    @Test
    public void t1() {
        StackInt stackInt = new StackInt(10);
        for (int i = 0; i < 10; i++) {
            stackInt.push(i*10);
        }
        while (!stackInt.isEmpty()){
            System.out.println(stackInt.pop());
        }
    }

    @Test
    public void t2() {
        String s = "hello word";
        Reverser reverser = new Reverser(s);
        System.out.println(reverser.doRev());
    }

    @Test
    public void t3() {
        String s = "{hello word}";
        Brackets brackets = new Brackets(s);
        System.out.println(brackets.isClosed());
        String s1 = "{hello word";
        Brackets brackets1 = new Brackets(s1);
        System.out.println(brackets1.isClosed());
        String s2 = "{hello [(word)]}";
        Brackets brackets2 = new Brackets(s2);
        System.out.println(brackets2.isClosed());
        String s3 = "{hello [word)]}";
        Brackets brackets3 = new Brackets(s3);
        System.out.println(brackets3.isClosed());
        String s4 = "{hello [(word)}";
        Brackets brackets4 = new Brackets(s4);
        System.out.println(brackets4.isClosed());
    }
}

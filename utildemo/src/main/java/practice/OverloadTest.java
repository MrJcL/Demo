package practice;

/**
 * @program: Demo
 * @Date: 2019/3/7 19:47
 * @Author: LiJc
 * @Description:
 *        重载规则:
 *              被重载的方法必须改变参数列表(参数个数或类型不一样)；
 *              被重载的方法可以改变返回类型；
 *              被重载的方法可以改变访问修饰符；
 *              被重载的方法可以声明新的或更广的检查异常；
 *              方法能够在同一个类中或者在一个子类中被重载。
 *              无法以返回值类型作为重载函数的区分标准。
 */
public class OverloadTest {

    public void say(){

    }

//    public String say(){//无法以返回值类型作为重载函数的区分标准。
//        return "hello";
//    }

    public void say(long i){//被重载的方法必须改变参数列表(参数个数或类型不一样)；

    }

    private void say(int i){//被重载的方法可以改变访问修饰符；

    }

    public String say(double i){//被重载的方法可以改变返回类型；
        return "hello";
    }

    public String say(double i, int j){//被重载的方法必须改变参数列表(参数个数或类型不一样)；
        return "hello";
    }
}

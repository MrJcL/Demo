package practice;

/**
 * @program: Demo
 * @Date: 2019/3/7 20:00
 * @Author: LiJc
 * @Description:
    参数列表必须完全与被重写方法的相同；
    返回类型必须完全与被重写方法的返回类型相同；
    访问权限不能比父类中被重写的方法的访问权限更低。例如：如果父类的一个方法被声明为public，那么在子类中重写该方法就不能声明为protected。
    父类的成员方法只能被它的子类重写。
    声明为final的方法不能被重写。
    声明为static的方法不能被重写，但是能够被再次声明。
    子类和父类在同一个包中，那么子类可以重写父类所有方法，除了声明为private和final的方法。
    子类和父类不在同一个包中，那么子类只能够重写父类的声明为public和protected的非final方法。
    重写的方法能够抛出任何非强制异常，无论被重写的方法是否抛出异常。但是，重写的方法不能抛出新的强制性异常，或者比被重写方法声明的更广泛的强制性异常，反之则可以。
    构造方法不能被重写。
    如果不能继承一个方法，则不能重写这个方法。
 */
public class OverrideTest {

    public static void main(String [] args) {
        Father father = new Father();
        Father son = new Son();
        Son son1 = new Son();
        System.out.println("father:"+father.painting());
        System.out.println("father:"+father.programBug());
        System.out.println("father:"+father.programJava());
//        System.out.println("father:"+father.programJava("这是骗人的"));//编译不通过

        System.out.println("son:"+son.painting());
        System.out.println("son:"+son.programBug());
        System.out.println("son:"+son.programJava());
//        System.out.println("son:"+son.programJava("这是骗人的"));//编译不通过

        System.out.println("son1:"+son1.painting());
        System.out.println("son1:"+son1.programBug());
        System.out.println("son1:"+son1.programJava());
        System.out.println("son1:"+son1.programJava("这是骗人的"));

    }

}

/**
 * 爸爸类
 */
class Father {

    /**
     * 技能1（画画）
     */
    protected String painting(){
        String a = "我会画大虾";
        return a;
    }

    /**
     * 技能2（写bug）
     */
    public final String programBug(){
        String a = "我会写BUG";
        return a;
    }

    /**
     * 技能3（写java）
     */
    public static String programJava(){
        String a = "我会JAVA";
        return a;
    }

    /**
     * 技能4（game）
     */
     private String game(){
        String a = "我还会玩游戏";
        return a;
    }
}

/**
 * 儿子类
 */
class Son extends Father{

    //重写技能1
    //编译不通过
    //访问权限不能比父类中被重写的方法的访问权限更低
//    private String painting(){
//        String a = "我会画大虾";
//        return a;
//    }

    //重写技能1
    //编译不通过
    //返回类型必须完全与被重写方法的返回类型相同；
//    public void painting(){
//    }

    //重写技能1
    public String painting(){
//        super.painting();//可以调用父类的能重写的方法
        String a = "我会画虾米";
        return a;
    }

    //重写技能2
    //编译不通过
    //声明为final的方法不能被重写。
//    public final String programBug(){
//        String a = "我会写BUG,我还会写PHP";
//        return a;
//    }

    //重写技能3
    //编译不通过
    //声明为static的方法不能被重写
//    public String programJava(){
//        String a = "我会JAVA";
//        return a;
//    }

    //重写技能3
    //声明为static的方法不能被重写，但是能够被再次声明。
    public static String programJava(){
        String a = "我会C++";
        return a;
    }

    //重载技能3
    //声明为static的方法不能被重写，可以重载
    public String programJava(String s){
        return s;
    }

    //在Java中，所有的private方法默认是final的，即不可继承的
    //所以这里的game属于一个新的方法，不是重写
    private String game(){
        String a = "游戏我贼6";
//        super.game();//无法调用父类的私有方法
        return a;
    }
}
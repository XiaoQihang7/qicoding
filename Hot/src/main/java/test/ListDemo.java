package test;

import java.util.ArrayList;

public class ListDemo {

    static{
        System.out.println("1111111");
    }

    class list{
        {//Static declarations in inner classes are not supported at language level '8'
            //内部类中的静态声明在语言级别“8”不受支持 ,所以不论是类下的内部类还是方法中的内部类都不能使用静态代码块

        }
    }

    static float a;
    static byte c;

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        try {
            strings.add("A");
//            strings.set(1,"B"); //.IndexOutOfBoundsException
            strings.set(0,"B"); //正常
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(strings.toString());
            System.out.println(a); //float自动向上转型Double
            System.out.println(c); //int
        }

        class aaa{
            {
                System.out.println();
            }
        }
    }
}



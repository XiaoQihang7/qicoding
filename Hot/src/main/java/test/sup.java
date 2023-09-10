package test;

import java.util.Date;

public class sup {
    public Integer getLenght(){
        return new Integer(4);
    }
}

class sub extends sup{
    //    public Long getLenght(){ //'getLenght()' in 'test.sub' clashes with 'getLenght()' in 'test.sup';
    //    attempting to use incompatible return type
//    public Long getLenght(){ //test.sub中的getLenght()无法覆盖test.sup中的getLenght()
//        //返回类型java.lang.Long与java.lang.Integer不兼容
//        return new Long(5);
//    }
    public static void main (String[] args){
        sup sup = new sup();
        sub sub = new sub();
        System.out.println(sup.getLenght() + "," + sub.getLenght());
        int i = 1;
        long u = 10;
        u=i;
        i = (int) u;
        sup s = sub; //子类可以直接赋值给父类
        Date d = new java.sql.Date(2023); //子类可以直接赋值给父类

    }
}

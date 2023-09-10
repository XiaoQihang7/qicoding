package easy;

public class TestDemo {
    public static int a =1;
    public void getA(){
        System.out.println(a);
    }
    public static int aMethod(int i) throws Exception{
        System.out.println(a);
        try{
            return 10/i;
        }catch (Exception e){
            throw new Exception("exception in a aMed");
        }finally {
            System.out.println("finally");
        }
    }

    public static void main(String[] args){
        //面向对象，值传递问题
        int m=10,n=20;
        TestDemo testDemo = new TestDemo();
        testDemo.swap(n,m);
        System.out.println(m+"  "+n);

        //输出啥？
        System.out.println("is "+ 100 + 5);
        System.out.println(100 + 5 +" is");
        System.out.println("is "+ (100 + 5));

        //异常处理问题
        try {
            aMethod(0); //必须抛出异常
        } catch (Exception e) {
            System.out.println("exception in main ");
        }
        System.out.println("finished");
    }

    private void swap(int n, int m) {
        int temp = n;
        n=m;
        m=temp;
        System.out.println(m + " " + n);
    }


}

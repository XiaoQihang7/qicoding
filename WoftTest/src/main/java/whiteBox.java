public class whiteBox {
    /** javadoc。。。。。。
     *
     * @param x
     * @param y
     * @return
     */
    public static int getNmb(int x, int y) {
        int z;
        int ret;
        if (x < 0) { //判定覆盖1：x=-1
            z = y - x;
        } else { //判2：x=1 //条件1，x=12
            z = y + x;
        }
        if (z < 10 && y > 0) { //判1：z=2.y=1 （T,T）//条件1.z=11,y=-1 (F,F),ret=11*12
            ret = z * y;
        } else { //判2、z=0，y=-1(T,F) //条件组合.x=10,z=11,y=1(F,T)
            ret = z * x;
        }
        return ret;
    }
}
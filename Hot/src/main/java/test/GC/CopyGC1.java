package test.GC;


  /**
   * @author qi_coding
   * @version 1.00
   * @time 2023/10/12 10:45
   * 垃圾回收算法_标记清除
   * 该算法的优点是简单快速，并且不会产生内存碎片。但缺点是只能使用堆内存的一半，导致空间利用率较低。
   */
public class CopyGC1 {
    private Object[] space1;
    private Object[] space2;
    private int currentSpaceCapacity; //记录当前堆空间的容量
    private Object[] toSpace; //当前分配对象的空间.分配的对象存储在toSpace中
    private int toSpaceIndex;

    public CopyGC1(int capacity) {
        this.currentSpaceCapacity = capacity;
        this.space1 = new Object[capacity];
        this.space2 = new Object[capacity];
        this.toSpace = space2;
    }

    public void allocate(Object obj) {
        if (toSpaceIndex >= currentSpaceCapacity) { //如果当前空间已满，则调用gc方法进行垃圾回收
            gc();
        }
        toSpace[toSpaceIndex++] = obj; //分配的对象存储在toSpace中
    }

    public void gc() {
        Object[] fromSpace = (toSpace == space1) ? space2 : space1;
        int fromSpaceIndex = 0;
        for (int i = 0; i < toSpaceIndex; i++) {
            Object obj = toSpace[i];
            //对象是GCObject类型且未被标记，则将其标记为已标记，并将其引用的对象拷贝到另一个堆空间的对应位置
            if (obj instanceof GCObject) {
                GCObject gcObj = (GCObject) obj;
                if (!gcObj.marked) {
                    gcObj.marked = true;
                    fromSpace[fromSpaceIndex++] = gcObj.ref;
                }
            }
        }
        // 将未被标记的对象进行回收
        int toSpaceIndex = 0;
        for (int i = 0; i < toSpaceIndex; i++) {
            Object obj = toSpace[i];
            if (obj instanceof GCObject) {
                GCObject gcObj = (GCObject) obj;
                if (!gcObj.marked) {
                    continue;
                }
                gcObj.marked = false;
            }
            toSpace[toSpaceIndex++] = obj;
        }
        toSpace = (toSpace == space1) ? space2 : space1;
        toSpaceIndex = fromSpaceIndex;
    }

    // 测试代码
    public static void main(String[] args) {
        CopyGC1 gc = new CopyGC1(3);
        Object obj1 = new Object();
        Object obj2 = new GCObject(obj1);
        Object obj3 = new GCObject(obj2);
        gc.allocate(obj1);
        gc.allocate(obj2);
        gc.allocate(obj3);
        gc.gc();
    }
}


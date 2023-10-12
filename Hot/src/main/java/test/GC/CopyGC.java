package test.GC;

/**
 * @author qi_coding
 * @version 1.00
 * @time 2023/10/12 10:45
 * 垃圾回收算法_标记清除
 */
public class CopyGC {
    private GCObject[] space1; // 堆空间1
    private GCObject[] space2; // 堆空间2
    private int currentSpaceCapacity; // 当前堆空间容量
    private GCObject[] toSpace; // 当前分配对象的空间
    private int toSpaceIndex = 0; // 当前空间已使用大小
    private GCObject root; // 根节点

    public CopyGC(int capacity) {
        currentSpaceCapacity = capacity;
        space1 = new GCObject[capacity];
        space2 = new GCObject[capacity];
        toSpace = space1;
    }

    public void allocate(GCObject obj) {
        if (toSpaceIndex == currentSpaceCapacity) {
            gc();
        }
        toSpace[toSpaceIndex++] = obj;
    }

    public void gc() {
        // 标记阶段
        mark(root);

        // 复制阶段
        GCObject[] fromSpace = toSpace == space1 ? space1 : space2;
        toSpace = toSpace == space1 ? space2 : space1;
        int toSpaceIndex = 0;

        for (int i = 0; i < fromSpace.length; i++) {
            GCObject obj = fromSpace[i];
            if (obj != null && obj.marked) {
                GCObject copy = obj.copy(); // 复制对象
                toSpace[toSpaceIndex++] = copy;
                obj.marked = false; // 重置对象标记
            }
        }

        // 更新根节点指向的对象
        root = root.getForwardedObject();

        this.toSpace = toSpace;
        this.toSpaceIndex = toSpaceIndex;
    }

    private void mark(GCObject obj) {
        if (obj == null || obj.marked) {
            return;
        }
        obj.marked = true;

        // 遍历对象引用的其他对象
        mark((GCObject) obj.getRef());
//        mark(obj.getField2());
    }
}
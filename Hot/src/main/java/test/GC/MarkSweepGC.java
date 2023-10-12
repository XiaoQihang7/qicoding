package test.GC;

import java.util.*;

/**
 * @author qi_coding
 * @version 1.00
 * @time 2023/10/12 10:45
 * 垃圾回收算法_标记清除
 * 该算法的优点是不需要对对象进行移动操作，能够处理任意性的数据结构。但缺点是在清除阶段会产生内存碎片，影响之后的内存分配效率。
 */
public class MarkSweepGC {
    private List<Object> heap;

    public MarkSweepGC() {
        this.heap = new ArrayList<>();
    }

    public void allocate(Object obj) {
        heap.add(obj);
    }

    public void gc() {
        Set<Object> marked = new HashSet<>();
        mark(marked);
        sweep(marked);
    }

    private void mark(Set<Object> marked) {
        for (Object obj : heap) {
            if (obj instanceof GCObject && !marked.contains(obj)) {
                marked.add(obj);
                mark(((GCObject) obj).getRef(),marked);
                // 遍历当前对象引用的其他对象，并进行递归标记
                // 这里需要根据实际对象结构进行遍历操作
                // 例如，对于一个类的成员变量，可以通过反射获取其引用的对象并进行标记
                // 对于一个容器类对象，可以遍历其元素，并对每个元素进行标记
            }
        }
    }

    private void mark(Object obj , Set<Object> marked){
        if (obj instanceof GCObject && !marked.contains(obj)) {
            marked.add(obj);
        }
    }

    private void sweep(Set<Object> marked) {
        Iterator<Object> iterator = heap.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if (!marked.contains(obj)) {
                iterator.remove();
            }
        }
    }

    // 测试代码
    public static void main(String[] args) {
        MarkSweepGC gc = new MarkSweepGC();
        Object obj1 = new Object();
        Object obj2 = new GCObject(obj1);
        Object obj3 = new GCObject(obj2);
        gc.allocate(obj1);
        gc.allocate(obj2);
        gc.allocate(obj3);
        gc.gc();
    }
}


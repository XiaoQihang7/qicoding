package test.GC;

import java.util.HashSet;
import java.util.Set;

    /**
     * @author qi_coding
     * @version 1.00
     * @time 2023/10/12 10:45
     * 标记整理算法
     * 该算法能够处理任意性的数据结构，并且不会产生内存碎片。但缺点是需要移动存活对象，导致效率较低。
     */
    public class MarkCompactGC {
        private Object[] heap;

        public MarkCompactGC(int capacity) {
            this.heap = new Object[capacity];
        }

        public void allocate(Object obj) {
            for (int i = 0; i < heap.length; i++) {
                if (heap[i] == null) {
                    heap[i] = obj;
                    return;
                }
            }
            gc();
            allocate(obj);
        }

        public void gc() {
            Set<Object> marked = new HashSet<>();
            mark(marked);
            compact(marked);
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

        private void compact(Set<Object> marked) {
            int newIndex = 0;
            Object[] newHeap = new Object[heap.length];
            // 移动存活对象到新堆
            for (Object obj : heap) {
                if (marked.contains(obj)) {
                    newHeap[newIndex++] = obj;
                }
            }
            // 移动未被标记的对象到堆的另一端
            for (int i = 0; i < heap.length; i++) {
                if (!marked.contains(heap[i])) {
                    newHeap[newHeap.length - i - 1] = heap[i];
                }
            }
            heap = newHeap;
        }

        // 测试代码
        public static void main(String[] args) {
            MarkCompactGC gc = new MarkCompactGC(3);
            Object obj1 = new Object();
            Object obj2 = new GCObject(obj1);
            Object obj3 = new GCObject(obj2);
            gc.allocate(obj1);
            gc.allocate(obj2);
            gc.allocate(obj3);
            gc.gc();
        }
    }

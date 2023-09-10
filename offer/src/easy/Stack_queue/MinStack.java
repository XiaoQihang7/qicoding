package easy.Stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;

//offer30、包含min函数的栈
class MinStack {

    Deque<Integer> inDeque;
    Deque<Integer> outDeque;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        inDeque = new ArrayDeque<>();
        outDeque = new ArrayDeque<>();
    }

    public void push(int x) {
        inDeque.push(x);
        if (outDeque.isEmpty()||outDeque.peek()>=x){
            outDeque.push(x);
        }
    }

    public void pop() {
        if (inDeque.pop().equals(outDeque.peek()))
            outDeque.pop();
    }

    public int top() {
        if (!inDeque.isEmpty())
        return inDeque.peek();
        return -1;
    }

    public int min() {
        if (!outDeque.isEmpty())
        return outDeque.peek();
        return -1;
    }

}
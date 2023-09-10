package easy.Stack_queue;

import java.util.Stack;

//offer09、两个栈实现队列尾插、头删的功能
public class Stack_Queue {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public Stack_Queue() {
    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()){
            if(stack1.isEmpty()){
                return -1;
            }
            in2out();
        }
        return stack2.pop();
    }
    private void in2out() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
}

package prog_232_implementQueueUsingStack;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> in = new Stack();
    Stack<Integer> out = new Stack();
    //In this program we are maintaining two stacks one for in function and other for out function
//In is for pushing and out for poping. whenever out is empty and we want to perform pop then we push all items from in
// and put it into out in reverse manner. so whever pop happens, it will be top element of out stack.
// here the complexity will be O(1)
    public MyQueue() {

    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop()) ;
            }
        }
        return out.pop();
    }

    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop()) ;
            }
        }
        return out.peek();
    }

    public boolean empty() {
        if(in.isEmpty() & out.isEmpty()){
            return true ;
        }
        return false ;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */


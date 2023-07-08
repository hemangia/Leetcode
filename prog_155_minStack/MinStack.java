package prog_155_minStack;

import java.util.Stack;

public class MinStack {
    //In this program we are maintaining 2 stacks one for maintaining values and other for maintaining minimum wrt that value
// Which means whenever we are pushing any value, we wil compare with existing minstack top element. If value is less
//then new value is inserted into the stack
//Time Complexity ==> O(1)
    public MinStack() {

    }
    Stack<Integer> valueStack = new Stack();
    Stack<Integer> minst = new Stack();
    int min ;
    int compare(int num1, int num2){
        if(num1>=num2){
            return num2 ;
        }
        return num1 ;
    }


    public void push(int val) {
        if(valueStack.isEmpty() && minst.isEmpty()){
            min = val ;
            valueStack.push(val);
            minst.push(val);
        }
        else{
            int minval = compare(minst.peek(), val);
            valueStack.push(val);
            minst.push(minval);
        }
    }

    public void pop() {
        if(!valueStack.isEmpty() && !minst.isEmpty()){
            valueStack.pop();
            minst.pop();
        }
    }

    public int top() {
        if(!valueStack.isEmpty()){
            return valueStack.peek();
        }
        return -1 ;
    }

    public int getMin() {
        if(minst.isEmpty()){
            return -1 ;
        }
        return minst.peek();

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
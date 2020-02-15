package leetcode.stack;

import java.util.Stack;

/**
 * @program: DataStrucerAndAlgorithm
 * @description:
 * @author: csc
 * @create: 2020-02-10 22:23
 *  232、栈实现队列
 **/

public class StackToQueue {

    public static void main(String[] args) {
        StackToQueue stackToQueue = new StackToQueue();
        stackToQueue.push(1);
        stackToQueue.push(2);
        stackToQueue.push(3);
        stackToQueue.push(4);

        System.out.println(stackToQueue.pop());
        System.out.println(stackToQueue.pop());
        System.out.println(stackToQueue.pop());
//        System.out.println(stackToQueue.pop());
        System.out.println(stackToQueue.isEmpty());
    }
    private Stack<Integer> in=new Stack();
    private Stack<Integer> out=new Stack();

    public StackToQueue(){

    }

    //入队
    public void push(int x){
        in.push(x);
    }

    //出队
    public int pop(){
        if (!out.isEmpty()){
            return out.pop();
        }else {
            while (!in.isEmpty()){
                out.push(in.pop());
            }
            return out.pop();
        }
    }

    //查看队列首个元素
    public int peek(){
        if (!out.isEmpty()){
            return out.peek();
        }else {
            while (!in.isEmpty()){
                out.push(in.pop());
            }
            return out.peek();
        }
    }

    public boolean isEmpty(){
        return (in.isEmpty() && out.isEmpty());
    }
}

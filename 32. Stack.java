package com.company;

public class Stack {
    Node top;
    int size;
    Stack(){
        top = new Node();
        size = 0;
    }
    void push(int val){
        Node temporary = new Node(val,null);
        if(isEmpty()){
            top = temporary;
        }
        else{
            temporary.next = top;
            top = temporary;
        }
        size++;
    }
    void pop(){
        if(isEmpty()){
            System.out.println("UNDERFLOW");
        }
        else {
            top = top.next;
        }
        size--;
    }
    boolean isEmpty(){
        return top==null;
    }
    Object peek(){
        return top.val;
    }
    void display(){
        for(Node current = top;current.next!=null;current=current.next){
            System.out.println(current.val+" "+current.next);
        }
        System.out.println();
    }
}

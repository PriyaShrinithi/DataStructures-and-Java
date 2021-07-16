package com.company;

public class StackWithSLL extends SinglyLinkedList
{
    Node top;
    StackWithSLL(){
        top = new Node();//stack.head;
    }
    void push(int val){
        addAtHead(val);
    }
    void pop(){
        if (isEmpty()) {
            System.out.println("UNDERFLOW");
        }
        else {
            deleteAtHead();
        }
    }
    boolean isEmpty(){
        return top==null;
    }
    Object peek() {
        return peekAtPosition(1);
    }
}

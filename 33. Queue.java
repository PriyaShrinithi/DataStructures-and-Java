package com.company;

public class Queue {
    Node front;
    Node rear;
    int size;
    Queue(){
        front = null;
        rear = null;
        size = 0;
    }
    void enqueue(int val){
        Node temporary = new Node(val, null);
        if(!isEmpty()){
            rear.next = temporary;
            rear = rear.next;
        }
        else{
            front = rear = temporary;
        }
        size++;
    }
    void dequeue(){
        if(isEmpty()){
            System.out.println("UNDERFLOW");
        }
        else{
            if(front == rear){
                rear = null;
            }
            front = front.next;
            size--;
        }
    }
    boolean isEmpty(){
        return front == null && rear == null;
    }
    Object peekFront(){
        return front.val;
    }
    Object peekRear(){
        return rear.val;
    }
    int size(){
        return size;
    }
    void display(){
        for(Node current = front;current!=rear.next;current=current.next){
            System.out.println(current.val+" "+current.next);
        }
        System.out.println();
    }
}

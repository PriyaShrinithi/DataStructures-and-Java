package com.company;

class Node <T>{
    T val;
    Node next;
    Node(){}
    Node(T val, Node next){
        this.val = val;
        this.next = next;
    }
}

package com.company;
class SinglyLinkedList {
    Node <Integer> head;
    int size;
    SinglyLinkedList(){
        head = new Node();
        size = 0;
    }
    void add(int val, int position){
        position--;
        if(position<0||position>size){
            return;
        }
        if(position==0){
            addAtHead(val);
        }
        else if(position==size){
            addAtTail(val);
        }
        else{
            Node<Integer> temporary = new Node<>(val, null);
            int i = 0;
            Node current = head;
            Node previous = null;
            for(;i<position;i++, previous=current, current=current.next);
            temporary.next = current.next;
            previous.next = temporary;
            size++;
            System.out.println(size);
        }
    }
    void addAtHead(int val){
        Node<Integer> temporary = new Node<>(val, null);
        if(head==null){
            head = temporary;
        }
        else {
            temporary.next = head;
            head = temporary;
        }
        size++;
    }
    void addAtTail(int val){
        if(head==null){
            addAtHead(val);
        }
        else {
            Node<Integer> temporary = new Node<>(val, null);
            Node current = head;
            for (; current.next != null; current = current.next) ;
            current.next = temporary;
            size++;
        }
    }
    Object peekAtPosition(int position){
        position--;
        Node current = head;
        for(int i =0;i<position;i++, current = current.next);
        return current.val;
    }
    void display(){
        Node<Integer> current = head;
        for(int i = 0;i<size;i++){
            System.out.println(current.val+" "+current.next);
            current=current.next;
        }
        System.out.println();
    }
    void iterReverse(){
        Node previous = null, current = null;
        for(Node next = head;next!=null;){
            current = next;
            next = next.next;
            current.next = previous;
            previous = current;
            head = current;
        }
    }
    void recurseReverse(Node previous, Node current, Node next){
        if(next==null){
            return;
        }
        current = next;
        next = next.next;
        current.next = previous;
        head = current;
        recurseReverse(current, current, next);
    }
    void remove(int position){
        position--;
        if(position<0|position>size-1){
            return;
        }
        if(position==0){
            deleteAtHead();
        }
        else if(position==size-1){
            deleteAtTail(null, head);
        }
        else{
            Node previous = null;
            Node current = head;
            for (int i = 0; i < position; i++, previous = current, current = current.next) ;
            previous.next = current.next;
            size--;
        }
    }
    void deleteAtHead(){
        head = head.next;
        size--;
    }
    void deleteAtTail(Node previous, Node current){
        if(current.next==null){
            previous.next = null;
            size--;
            return;
        }
        deleteAtTail(current, current.next);
    }
    void update(int val, int position){
        position--;
        if(position<-1||position>size){
            return;
        }
        if(position==-1){
            addAtHead(val);
        }
        else if(position==size){
            addAtTail(val);
        }
        else if(position==0){
            head.val = val;
        }
        else{
            Node current = head;
            for(int i = 0;i<position;i++, current = current.next);
            current.val = val;
        }
    }
    int size(){
        return size;
    }
}

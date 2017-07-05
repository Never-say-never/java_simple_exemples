/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nextclick.spring.franework;


/**
 *
 * @author Fokin Valerii <fokin051990@gmail.com>
 */
public class AppBootstrap {

    public static void main(String[] args) {
        
        KillMePleaseList list = new KillMePleaseList();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
 
        System.out.println(list);
    }

}

class KillMePleaseList {
    
    private Node head;
    
    public void add(Object obj) {
        if(head == null) {
            head = new Node(obj);
        }
        
        Node node = new Node(obj);
        Node currentHead = head;
        
        while(currentHead.getNext() != null) {
            currentHead = currentHead.getNext();
        }
        
        currentHead.setNext(node);
    }
    
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        
        if(head == null) {
            return stringBuilder.toString();
        }
        
        Node currentHead = head.getNext();
        while(currentHead != null) {
            stringBuilder.append("[")
                    .append(currentHead.getData())
                    .append("]");
            
            currentHead = currentHead.getNext();
        }
        
        return stringBuilder.toString();
    }
    
    private class Node {
        
        private Object data;
        
        private Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}

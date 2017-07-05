/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nextclick.testcollection;

/**
 *
 * @author Fokin Valerii <fokin051990@gmail.com>
 */
public class TestCollection {
    public static void main(String[] args) {
        KillMePleaseList list = new KillMePleaseList();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        System.out.println(list.size());
        System.out.println(list);
        
        list.removeElement("two");
        System.out.println(list);
        System.out.println(list.size());
        
        Object o = list.get(2);
        System.out.println(o);
    }
}

class KillMePleaseList {
    
    private Node head;
    
    private long size;
    
    /**
     * 
     * @param obj 
     */
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
        incSize();
    }
    
    /**
     * Remove all objects o from list
     * @param o
     * @return integer count of elements that were deleted
     */
    public long removeElement(Object o) {
        long deletedElements = 0;
        if(head == null || size == 0) {
            return deletedElements;
        }
        
        Node currentHead = head;
        Node previewHead = currentHead;
        while(currentHead.getNext() != null) {
            if(currentHead.getData().equals(o)){
                previewHead.setNext(currentHead.getNext());
                
                decSize();
                ++deletedElements;
            }
            previewHead = currentHead;
            currentHead = currentHead.getNext();
        }
        
        return deletedElements; 
    }
    
    public Object get(int index) {
        if(head == null) {
            return head;
        }
        
        if(index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        
        Node currentHead = head;
        
        long ix = 0;
        while (currentHead.getNext() != null) {
            if(index == ix) {
                break;
            }
            
            currentHead = currentHead.getNext();
        }
        
        return currentHead.getData();
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
    
    private void incSize() {
        size++;
    }
    
    private void decSize() {
        size--;
    }
    
    public long size() {
        return size;
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

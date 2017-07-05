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
        KillMePleaseList<Integer> list = new KillMePleaseList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.size());
        System.out.println(list);
        
        list.removeElement(3);
        System.out.println(list);
        System.out.println(list.size());
        
        Object o = list.get(2);
        System.out.println(o);
    }
}

class KillMePleaseList<T> {
    
    private Node<T> head;
    
    private long size;
    
    /**
     * 
     * @param obj 
     */
    public void add(T obj) {
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
    public long removeElement(T o) {
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
    
    public T get(int index) {
        if(head == null) {
            return null;
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
        
        return (T) currentHead.getData();
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
    
    private class Node<T> {
        
        private T data;
        
        private Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
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

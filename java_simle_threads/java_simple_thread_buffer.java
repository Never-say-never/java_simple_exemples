/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdecode;

import java.util.ArrayList;
import java.util.List;

public class testDecode{
    private static final SynchBuffer buff = new SynchBuffer();
    
    public final static void main(String[] args) {
        List<Thread> members = new ArrayList<>();
                
        members.add(new Thread(new Producer(100, buff)));
        members.add(new Thread(new Producer(100, buff)));
        members.add(new Thread(new Producer(100, buff)));
        
        members.add(new Thread(new Consumer(500, buff)));
        members.add(new Thread(new Consumer(5000, buff)));
        
        members.stream().forEach((t) -> {
            t.start();
        });
    }
}

class SynchBuffer{
    
    private static final int BYFF_SYZE = 100;
    
    private final List<Integer> storage;
    
    SynchBuffer(){
        this.storage = new ArrayList(BYFF_SYZE);
    }
    
    public synchronized int get() throws InterruptedException{
        if(this.storage.isEmpty()){
            this.wait();
        }
        
        int top = this.storage.size() - 1;
        int el  = this.storage.remove(top);
        
        this.notify();
        
        return el;
    }
    
    public synchronized void put(int el) throws InterruptedException{
        while(this.storage.size() >= BYFF_SYZE){
            this.wait();
        }
        
        this.storage.add(el);
        this.notify();
    }
    
    public int getSize(){
        return this.storage.size();
    }
}

class Producer extends Worker implements Runnable{

    private static int product = 0;
    
    public Producer(int workSpeed, SynchBuffer buff){
        super(workSpeed, buff);
    }
    
    @Override
    public void run() {
        while(true){
            try {
                this.buff.put(product++);
                System.out.println(Thread.currentThread()
                        .getName() + " Put:" + product + " -> "
                        + this.buff.getSize());
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
            
            try {
                Thread.sleep(this.workSpeed);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }
    
}

class Consumer extends Worker implements Runnable{

    public Consumer(int workSpeed, SynchBuffer buff){
        super(workSpeed, buff);
    }
    
    @Override
    public void run() {
         while(true){
            try {
                int product = this.buff.get();
                System.out.println(Thread.currentThread()
                        .getName() + " Get:" + product + " -> "
                        + this.buff.getSize());
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
            
            try {
                Thread.sleep(this.workSpeed);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }
    
}

abstract class Worker{
    
    protected int workSpeed;
    
    protected SynchBuffer buff;
    
    public Worker(int workSpeed, SynchBuffer buff) {
        this.workSpeed  = workSpeed;
        this.buff       = buff;
    }
    
}

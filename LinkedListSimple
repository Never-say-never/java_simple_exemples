public class SomeTest {
    
    public static void main(String args[]){
        LinkedList node = new LinkedList();
        
        for(int ix = 0; ix < 10; ++ix){
            node.add(ix);
        }
        
        while(node.hasNext()){
            System.out.println("get :" + node.get());
            node = node.next();
        }
        
        System.out.println("end");
    }
}

class LinkedList{
    
    private LinkedList next;
    private int obj;
    
    LinkedList(){
        
    }
    
    LinkedList(int t, LinkedList next){
        this.obj  = t;
        this.next = next;
    }
    
    public void add(int t){
        this.obj  = t;
        this.next = new LinkedList(t, this.next);
    }
    
    public int get(){
        return next.obj;
    }
    
    public boolean hasNext(){
        if(this.next != null)
            return true;
        
        return false;
    }
    
    public LinkedList next(){
        return this.next;
    }
}

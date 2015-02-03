/*
  Abstract class:
  1. The class must also be declared abstract. If a 
  class contains an abstract method, the class must be abstract as well.

  2. Any child class must either override the abstract 
  method or declare itself abstract.
*/

public class tesAbstract {
    
    public static void main(String args[]){
        SuperClass supperClass = new SuperClass();
        supperClass.publicSecond();
        
        FierstAbstract first   = new SuperClass();
        first.fierst();
    }
}

abstract class FierstAbstract /* extends OnlyOneExtention implements Inr1, Inr2 ... */{
    
    FierstAbstract(){
        /* default constructor */
    }
    
    protected void fierst(){
        System.out.println("fierst");
    }
    
    /* can not be private */
    abstract protected void publicFierst();
    
}

abstract class Second extends FierstAbstract{
    
    /**
     * deful constructer Second(){}
     */
    
    public int counter;
    
    abstract public void publicSecond();
    
}

class SuperClass extends Second{

    @Override
    public void publicSecond() {
        System.out.println("SuperClass :publicSecond");
    }

    @Override
    protected void publicFierst() {
        System.out.println("SuperClass :publicFierst");
    }
    
}

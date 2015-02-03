/*
  Abstract class:
  1. The class must also be declared abstract. If a 
  class contains an abstract method, the class must be abstract as well.

  2. Any child class must either override the abstract 
  method or declare itself abstract.
*/
class NeedAbstract{
    
    private String msg;
    
    NeedAbstract(FierstAbstract f){
        this.msg = f.publicFierst();
        System.out.println(this.msg);
    }
}

public class testDecode {
    
    public static void main(String args[]){
        SuperClass supperClass = new SuperClass();
        supperClass.publicSecond();
        
        FierstAbstract first   = new SuperClass();
        first.fierst();
        
        /* annonim inner class */
        new NeedAbstract(new FierstAbstract(){

            @Override
            protected String publicFierst() {
                return "from override";
            }
            
        });
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
    abstract protected String publicFierst();
    
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
    protected String publicFierst() {
        System.out.println("SuperClass :publicFierst");
        return null;
    }
    
}

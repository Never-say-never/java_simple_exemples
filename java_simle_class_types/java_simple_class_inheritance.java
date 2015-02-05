public class testDecode extends BaseClass{
    
    //9
    public testDecode() {
        super();
        System.out.println("3");
    }
    
    //3
    static {
        System.out.println("1");
    }

    //7
    {
        System.out.println("2 :up");
    }

    //8
    {
        System.out.println("2 :under");
    }
    
    public final static void main(String[] args) {
        //4
        System.out.println("4"); 
        
        testDecode main = new testDecode();
        
        //10
        System.out.println("5");
    }
}

class BaseClass {

    //6
    public BaseClass() {
        System.out.println("8");
    }
    
    /**
     * 1 Fierst method wich will be loaded when class 
     * BaseClass appeare in the context of programm
     * and ClassLoader load it.
     */
    static {
        System.out.println("6 :up");
    }
    
    //2
    static {
        System.out.println("6 :under");
    }

    //5
    {
        System.out.println("7");
    }
}

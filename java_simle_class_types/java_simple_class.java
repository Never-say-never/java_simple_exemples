 /**
 * result of programm:
 * 
 *  BaseClass int t
 *  SubClass int t
 *  SubClass baseMethod: 10
 *  baseMethod
 *  0
 *  10
 * 
 */
 
 public class testDecode{

    public final static void main(String[] args) {
        SubClass b = new SubClass(10);
        b.baseMethod();
        
        System.out.println(b.baseT);
        System.out.println(((BaseClass)b).baseT);
    }
}

class BaseClass {

    public int baseT;
    
    private final int baseF;
    
    BaseClass(){
        System.out.println("BaseClass");
        baseF = 0;
    }
   
    BaseClass(int t){
        System.out.println("BaseClass int t");
        baseF = 0;
        
        this.baseT = t;
    }
    
    public void baseMethod(){
        System.out.println("baseMethod");
    }
}

class SubClass extends BaseClass{
    
    public int baseT;
    
    SubClass(int t){
        super(t);
        System.out.println("SubClass int t");
    }
    
    @Override
    public void baseMethod(){
        System.out.println("SubClass baseMethod: " + super.baseT);
        super.baseMethod();
    }
}

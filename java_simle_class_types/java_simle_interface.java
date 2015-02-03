/*
    Interface:
    1. You cannot instantiate an interface
    2. An interface does not contain any constructors.
    3. All of the methods in an interface are abstract.
    4. An interface cannot contain instance fields. The 
       only fields that can appear in an interface must be declared both static and final.
       
    5. An interface is not extended by a class; it is implemented by a class.
    6. An interface can extend multiple interfaces.
*/

interface InterfaceExample3{
    
    /* all field implicitly are static and final */
    /* static final */    String field3 = "InterfaceExample3";
    
    /* all methods implicitly are  public and abstract */
    /* public abstract */ void method();
    
}

interface InterfaceExample1{
    
    public static /* final */ Demo demo = new Demo();
    public static /* final */ int field = 0xA10F;
    
    /*public*/ abstract void method();
    
}

interface InterfaceExample2 extends InterfaceExample3 /* ,InterfaceExample2 ... */{
    
    public /* static */ final int finalField = 1000;
    
    public /* abstract */ void method();
    
    default void defaultMethod(String msg){
        System.out.println(msg);
    }
}

class SimpleClass implements InterfaceExample1, InterfaceExample2{
    
    @Override
    public void method() {
        
    }
}

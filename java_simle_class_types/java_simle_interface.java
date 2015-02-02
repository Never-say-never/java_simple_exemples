interface InterfaceExample1{
    
    public static int field = 0xA10F;
    
    public abstract void method();
    
}

interface InterfaceExample3{
    
    String field3 = "InterfaceExample3";
    
    void method();
    
}

interface InterfaceExample2{
    
    public final int finalField = 1000;
    
    public abstract void method();
    
    default void defaultMethod(String msg){
        System.out.println(msg);
    }
}

class SimpleClass implements InterfaceExample1, InterfaceExample2{
    
}

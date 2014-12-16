public class StringTester {
    
    public static void main(String args[]){
        boolean result = acronims1("result is:", " isresult:");
        System.out.println("result is:" + result);
    }
    
    private static boolean acronims1(String arg1, String arg2){
        if(arg1.length() != arg2.length())
            return false;
            
        if(arg1.equals(arg2))
            return true;
        
        StringBuilder str1 = new StringBuilder(arg1);
        StringBuilder str2 = new StringBuilder(arg2);
        
        for(int ix = 0; ix < str1.length(); ++ix){
            for(int iy = 0; iy < str2.length(); ++iy){
                if(str1.charAt(ix) == str2.charAt(iy)){
                    str1.deleteCharAt(ix--);
                    str2.deleteCharAt(iy--);
                    
                    break;
                }
            }
        }
        
        return str2.length() == 0 && str1.length() == 0;
    }
    
  }

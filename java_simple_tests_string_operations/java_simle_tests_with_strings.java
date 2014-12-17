 public class StringTester {
    
    public static void main(String args[]){
        boolean result = acronims1("result is:", " isresult:");
        System.out.println("result is:" + result);
    }
    
    // "apple" and "plaep" return true
    private static boolean acronims1(String arg1, String arg2){
        if(arg1 == null || arg2 == null)
            return false;
            
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
    
    // "apple" return "elppa"
    private static String strrev(String arg1){
        if(arg1 == null)
            return "undefined string";
        
        if(arg1.length() < 0)
            return "undefined string";
        
        StringBuilder str1 = new StringBuilder(arg1);
        
        for(int ix = 0; ix < str1.length() / 2; ++ix){
            char tmp = str1.charAt(ix);
            str1.setCharAt(ix, str1.charAt(str1.length() - ix - 1));
            str1.setCharAt(str1.length() - ix - 1, tmp);
        }
        
        return str1.toString();
    }
    
    private static String strrev1(String arg1){
        if(arg1 == null)
            return "undefined string";

        return new StringBuilder(arg1).reverse().toString();
    }
    
    private static String strrev2(String arg1){
        if(arg1 == null)
            return "undefined string";
        
        char[] rev = arg1.toCharArray();
        for(int ix = 0; ix < rev.length / 2; ++ix){
            int in = rev.length - ix - 1;
            char f = rev[ix];
            char l = rev[in];
            rev[ix] = l;
            rev[in] = f;
        }
        
        return new String(rev);
    }
    
  }

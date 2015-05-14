/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author java_monkey
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     * given A=8,675 and B=8,689
     */
    public static void main(String[] args) {
       JavaApplication1 tmp = new JavaApplication1();
       long start  = System.currentTimeMillis();
       int rez = tmp.heavy_decimal_count(0, 20000000);
       System.out.println("time :" + (System.currentTimeMillis() - start));
       System.out.println(rez);
    }
    
    public int heavy_decimal_count(int A, int B){
        if(A > B){
            throw new IllegalArgumentException();
        }
        
        int hevyCounter = 0;
        StringBuilder tmp = new StringBuilder();
        
        while(A <= B){
            tmp.append(A);
            
            if(this.checkValue(tmp)){  
                float t = this.getAverage(tmp);
                if(t > 7){
                    System.out.println(A +  " heavy : " + t );
                    ++hevyCounter;
                }
            }
            ++A;
            
            tmp.delete(0, tmp.length() - 1);
        }
        
        return hevyCounter;
    }
    
    //57 56 55
    private boolean checkValue(StringBuilder val){
        int omg = 0;
        int size = val.length();
        for(int ix = 0; ix < size; ++ix){
            if((int) val.charAt(ix) == 55 || (int) val.charAt(ix) == 56
                    || (int) val.charAt(ix) == 57){
                omg++;
            }
        }
        
        return omg == 0 || size / 3 < omg;
    }
    
    private float getAverage(StringBuilder curentValue){
        float size = curentValue.length();
        float sum  = 0f;
        for(int ix = 0; ix < size; ++ix){
            sum += Character.getNumericValue(curentValue.charAt(ix));
        }

        return sum / size;
    } 
}

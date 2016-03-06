/*
 * RSQ - range summ query
 */
 
package testapp;
      
/**
 *
 * @author java_monkey
 */
public class TestApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int min = 0;
        int max = 1000;
        int arr[] = new int[1000000];
        for(int ix = 0; ix < arr.length; ++ix){
            arr[ix] = min + (int)(Math.random() * ((max - min) + 1));
        }
        
        TestApp T = new TestApp();
        int tArr[] = T.calculateSumm(arr);
        
        long t = System.currentTimeMillis();
        System.out.println(T.rsq(678677, 678678, tArr));
        System.out.println(" - work time is: " + (System.currentTimeMillis() - t)); 
    }
    
    public int rsq(int start, int end, int[] arr){
        arr = this.calculateSumm(arr);
        
        if(start == 0)
            return arr[end];
        
        return arr[end] - arr[start - 1];
    }
    
    private int[] calculateSumm(int[] arr){
        int resultArr[] = new int[arr.length];
        int currentSumm = 0;
        for(int ix = 0; ix < arr.length; ++ix){
            currentSumm += arr[ix];
            resultArr[ix] = currentSumm;
        }
        
        return resultArr;
    }
}

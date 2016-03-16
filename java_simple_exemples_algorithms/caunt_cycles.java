/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapp;
      
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author java_monkey
 */

class TestModel{
    
    private int t1;
    
    private String s1;
    
    public TestModel(){
        System.out.println(t1);
        System.out.println(s1);
    }
}

public class TestApp {

    //static private int[] a = {1,2,4,3,6,1};
    //static private int[] b = {5,2,3,2,2,6,1,4};
    
    static private int[] a = {7,0,2,6,4,1,3,2};
    static private int[] b = {6,5,5,3,0,1,3,4};
    
    //static private int[] a;
    //static private int[] b;
            
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*GraphDancer gd = new GraphDancer(
                GraphDancer.graphGenerator(23),
                GraphDancer.graphGenerator(45));*/
        GraphDancer gd = new GraphDancer(a,b);
        
        //while(true){
            //long t = System.currentTimeMillis();
            gd.findCycleLight();
            //System.out.println(" - work time is: " + (System.currentTimeMillis() - t)); 
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(TestApp.class.getName()).log(Level.SEVERE, null, ex);
//            }
        //}
        
    }
    
}

class GraphDancer{
    
    private int[] A;
    private int[] B;
    
    public GraphDancer(int[] A, int[] B){
        this.A = A;
        this.B = B;
    }

    /**
     * important function
     * 
     * @return 
     */
    private int[][] createMap(){
        int[][] map = new int[8][8];
        
        for(int ix = 0; ix < 7; ++ix){
            map[ A[ix] ][ A[ix++ + 1] ] = 1;
        }
        
        for(int ix = 0; ix < 7; ++ix){
            map[ B[ix] ][ B[ix++ + 1] ] = 1;
        }
        
        return map;
    }
    
    private int[] quikSort(int[] arr){
        int max = arr[arr.length - 1];
        System.out.println("QuikSort max:" + max);
        
        int[] sortedArray = new int[arr.length - 1];
        int index = 0;
        
        int test = 0;
        for(int ix = max; ix > 1; --ix){
            System.out.println("QuikSort serching for:" + ix);
            for(int iy = 0; iy < arr.length - 1; ++iy){
                if(arr[iy] == ix){
                    // for excepting unprocessed elements
                    sortedArray[index] = iy + 1;
                    index++;   
                }
  
                System.out.println("QuikSort iteration[" + ix + "," + iy + "]" + " = " + arr[iy]);
                ++test;
            }
        }
        System.out.println("QuikSort iterations:" + test);
        return sortedArray;
    }
    
    /**
     * Array contains width of nodes
     * and last element - max width 
     * 
     * @param map
     * @return 
     */
    private int[] findeRavels(int[][] map){
        int[] ravels = new int[map.length + 1];
        for(int ix = 0; ix < map.length; ++ix){
            int income = 0;
            int outgoing = 0;
            for(int iy = 0; iy < map[ix].length; ++iy){
                income   += map[ix][iy];
                outgoing += map[iy][ix];
            }
            
            if(outgoing > 0 && income > 0){
                ravels[ix] = outgoing + income;
            }
            
            if(ravels[ix] > ravels[ravels.length - 1]){
                ravels[ravels.length - 1] = ravels[ix];
            }
        }
        
        return ravels;
    }
    
    /**
     * Important function
     */
    public void findCycleLight(){
        int[][] map  = this.createMap();
        int[] nodeArray = this.findeRavels(map);
        System.out.println(Arrays.toString(nodeArray));
        
        nodeArray = this.quikSort(nodeArray);
        
        System.out.println(Arrays.toString(nodeArray));
        
        int[] result = null;
        
        this.show(map);
        
        //for(int ix = 0; ix < map.length; ++ix){
        for(int ix = 0; ix < nodeArray.length; ++ix){
            if(nodeArray[ix] == 0){
                continue;
            }
            int current = nodeArray[ix] - 1;
            System.out.println("Start searching for node: " + current);
            //int[] rez = this.searchLight(result, map, ix, ix);
            int[] rez = this.searchLight(result, map, current, current);
            if(rez != null){
                this.show(rez);
                
                int[] fArray = this.formatArray(rez);
                
                System.out.println(Arrays.toString(fArray));
                
                return;
            }
        }
    }
    
    /**
     * Important function 
     * 
     * @param result
     * @param map
     * @param current
     * @param target
     * @return 
     */
    private int[] searchLight(int[] result, int[][] map, int current, int target){
        for(int ix = 0; ix < map[current].length; ++ix){

            // finish
            if(ix == target && map[current][ix] == 1){
                //System.out.println("Get cycle: " + ix + " -> " + current);
                result = new int[map[current].length];
                result[ix] = 1;
                
                return result;
            }
            
            if(map[current][ix] == 1){
                //System.out.println("Recurs call: " + ix);
                
                int[] tmp = this.searchLight(result, map, ix, target);
                if(tmp != null){ 
                    tmp[ix] = 1;
                    
                    return tmp;
                }
            }
        }
        
        return null;
    }
    
    
    /**
     * Important function
     * 
     * @param arr
     * @return 
     */
    private int[] formatArray(int[] arr){
        int size = 0;
        for(int t : arr){
            if(t == 1)
                ++size;
        }
        
        int[] rez = new int[size];
        int index = 0;
        for(int ix = 0; ix < arr.length; ++ix){
            if(arr[ix] == 1){
                rez[index++] = ix;
            }
        }
        
        return rez;
    }
    
    
    public static int[] graphGenerator(int max){
        int MAX_ELEMENT = max;
        //int SIZE = (int) (Math.random() * MAX_ELEMENT) + 10;
        
        int SIZE = max;
        int[] tmp = new int[SIZE];
        for(int ix = 0; ix < SIZE - 1; ++ix){
            tmp[ix] = ix;
            tmp[ix++ + 1] = (int) (Math.random() * SIZE);
        }
        
        return tmp;
    }
    
    public void show(int[][] arr){
        for(int ix = 0; ix < arr.length; ++ix){
            System.out.print( ix + "| ");
            for(int iy = 0; iy < arr[ix].length; ++iy){
                System.out.print( arr[ix][iy] + "; ");
            }
            
            System.out.println();
        }
    }
           
    public void show(int[] arr){
        for(int ix = 0; ix < arr.length; ++ix){
            System.out.print( " [" + ix + "]");
        }
        System.out.println();
        
        for(int ix = 0; ix < arr.length; ++ix){
            System.out.print( " " + arr[ix] + "; ");
        }
        System.out.println();
    }
    
}

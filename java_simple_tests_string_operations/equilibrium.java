public class testDecode{
    
    private static int equilibrium(int[] A){
        if(A == null || A.length <= 1){
            return -1;
        }
        
        long generallSumm = 0;
        int length = A.length;
        for(int ix = 0; ix < length; ++ix){
            generallSumm += A[ix];
        }
        
        long left = 0;
        for(int ix = 0; ix < length; ++ix){
            long localRight = generallSumm - left - A[ix];
            if(localRight == left){
                return ix;
            }
            
            left += A[ix];
        }
        
        return -1;
    }
    
    public final static void main(String[] args) {
        int[] A = new int[100000000];
        for(int ix = 0; ix < A.length; ++ix){
            Random r = new Random();
            A[ix] = r.nextInt();
        }
        
        long time = System.currentTimeMillis();
        System.out.println(equilibrium(A));
        System.out.println(System.currentTimeMillis() - time);

    }
}

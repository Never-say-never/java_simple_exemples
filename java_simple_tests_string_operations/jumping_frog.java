/*
A small frog wants to get to the other side of the road. The frog is 
currently located at position X and wants to get to a position great
er than or equal to Y. The small frog always jumps a fixed distance,
D.
*/

class Solution {
    public int solution(int X, int Y, int D) {
        int length = Y - X;
        
        if(X >= Y){
            return 0;
        }
        
        if(D <= 0){
            return 0;
        }
        
        if(D == 1){
            return length; 
        }
        
        int jumps  = length / D;
        
        if((length % D) == 0){
            return jumps;
        }
        
        return jumps + 1;
    }
}

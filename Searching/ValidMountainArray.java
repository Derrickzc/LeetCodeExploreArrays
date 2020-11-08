
/* Given an array of integers arr, return true if and only if it is a valid mountain array. 

Example 1:

Input: arr = [2,1]
Output: false
Example 2:

Input: arr = [3,5,5]
Output: false
Example 3:

Input: arr = [0,3,2,1]
Output: true


*/


public class ValidMountainArray {
    public boolean validMountainArray_my(int[] A) {
        
        int flagup=0;
        int flagdown=0;
        int flagpeak=0;
        if(A.length<3) 
                return false;
        
        
        for(int i=1;i<A.length-1;i++){
            
            if(A[i]==A[i-1])
                return false;
                        
            if( A[i]>A[i-1]&&A[i]>A[i+1] ){
                flagpeak++;
                continue;
                
            }
                
            else if(A[i-1]<A[i]&&A[i]<A[i+1]){
                flagup++;
                continue;
                
            }
            else if(A[i-1]>A[i]&&A[i]>A[i+1]){
                flagdown++;
                continue;
            }
            else
            { return false;}           
        }
        
        int sum=flagpeak+flagup+flagdown;
        
        
        if( (sum>=2 && sum*flagpeak!=0 )   || (flagpeak==1&& flagup==0 && flagdown==0) )
            return true;
        else{
            return false;
        }
        
    }

/* 
    Have two pointers: a start and end pointer.
Check to see if next element is valid to increment/decrement.
Ensure that the start and end pointers moved. */
//这个方法贼简单，就是利用了 在山顶之前，前面是单调递增的，后面是单调递减的，同时在判断时候不能加等号，！！！
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;
        int start = 0;
        int end = A.length-1;
        while (start < end) {
          if (A[start+1] > A[start]) {
            start++;
          } else if (A[end-1] > A[end]) { 
            end--;
          } else {
            break;
          }
        }


        return start != 0 && end != A.length-1 && start == end;
      }



}
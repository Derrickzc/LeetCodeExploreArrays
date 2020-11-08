/* Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition. 

Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

*/

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int writeindex=0;
        for(int readindex=0;readindex<A.length;readindex++){
            
            if(A[readindex]%2==0&&A[writeindex]%2!=0){
                int temp=A[writeindex];
                A[writeindex++]=A[readindex];
                A[readindex]=temp;
                
            }else if(A[writeindex]%2==0){
                writeindex++;
            }
            
            
            
        }
        return A;
        
        
    }
}
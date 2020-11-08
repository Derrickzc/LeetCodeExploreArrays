/*

Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.

Note that elements beyond the length of the original array are not written.

Do the above modifications to the input array in place, do not return anything from your function.

 

Example 1:

Input: [1,0,2,3,0,4,5,0]
Output: null
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
Example 2:

Input: [1,2,3]
Output: null
Explanation: After calling your function, the input array is modified to: [1,2,3]

*/

class Solution {
    public void duplicateZerosmy(int[] arr) {
        for(int i=0;i<arr.length;i++){
            
            if(i+1==arr.length)
                break;
            
            
            
            if (arr[i]==0){
                
                for(int j=arr.length-1;j>i+1;j--){  //change position, which is not good enough
                    
                    arr[j]=arr[j-1];                       
                }
                
            arr[i+1]=0;
            i++;
            }
            
            
            
        }
        
    }

    /*
        We can improve it to O(N) time and O(1) space.
    Basically, we apply two pointers.
    i is the position in the original array,
    j is the position in the new array.
    (the original and the new are actually the same array.)

    The first we pass forward and count the zeros.
    The second we pass backward and assign the value from original input to the new array.
    so that the original value won't be overridden too early.
    */


    public void duplicateZeros1(int[] arr) {
        int countZero = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) countZero++;
        }
        int len = arr.length + countZero;
        //We just need O(1) space if we scan from back
        //i point to the original array, j point to the new location
        for (int i = arr.length - 1, j = len - 1; i < j; i--, j--) {
            if (arr[i] != 0) {
                if (j < arr.length) arr[j] = arr[i];
            } else {
                if (j < arr.length) arr[j] = arr[i];
                j--;
                if (j < arr.length) arr[j] = arr[i]; //copy twice when hit '0'
            }
        }
    }



    /*
        First, go left to right and count how many shifts (sh) we can fit in our array.
        Then, go right to left and move items; if it's zero - duplicate it and decrement the shift.

        Note: i + sh can exceed the array size. We need a check for this case.
    
    */
    public void duplicateZeros2(int[] a) {
        int i = 0, sh = 0;
        for (i = 0; sh + i < a.length; ++i) sh += a[i] == 0 ? 1 : 0;
        for (i = i - 1; sh > 0; --i) {
          if (i + sh < a.length) a[i + sh] = a[i];
          if (a[i] == 0) a[i + --sh] = a[i];
        }
      }


}



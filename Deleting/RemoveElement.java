/**
 * RemoveElement
 * 
 Given an array nums and a value val, remove all instances of that value in-place and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 

Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2]
Explanation: Your function should return length = 2, with the first two elements of nums being 2.
It doesn't matter what you leave beyond the returned length. For example if you return 2 with nums = [2,2,3,3] or nums = [2,3,0,0], your answer will be accepted.

Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3]
Explanation: Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4. Note that the order of those five elements can be arbitrary. It doesn't matter what values are set beyond the returned length.

大概意思是删除2，但是也不要求数组的顺序一致
*/


public class RemoveElement {
    
    //两个index i,j；
    //i是慢的，j是快的
    //如果读取到相等，那么就跳过不理他 
    public int removeElementmy(int[] nums, int val) {
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=val){
                nums[i++]=nums[j];
            }
        }
        
    return i;
    }

    //
    public int removeElement(int[] A, int elem) {
        int m = 0;    
        for(int i = 0; i < A.length; i++){
            
            if(A[i] != elem){
                A[m] = A[i];
                m++;
            }
        }
        
        return m;
     }


    
}
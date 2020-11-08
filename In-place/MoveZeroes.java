/**
 * MoveZeroes
 * 
 * 
 * 
 * 
 Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 */
public class MoveZeroes {

    //两个index，一个进行writeindex跑的慢
    //另一个是跑的快的readindex
    public void moveZeroes(int[] nums) {
        if(nums==null) return;        
        int writeindex=0;
        
        for(int readindex=0;readindex<nums.length;readindex++){
            if(nums[readindex]!=0 && nums[writeindex]==0){
                nums[writeindex++]=nums[readindex];
                nums[readindex]=0;
            }
            else if(nums[writeindex]!=0){
                writeindex++;
            }
        }
        
        

        
        
    }
    
}
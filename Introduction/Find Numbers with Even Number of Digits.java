

/*
    Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]

*/




class Solution {
    public int findNumbers(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if ( (calculdigits(nums[i],0)) %2 ==0  ){
                sum++;
                
            }
        }
        return sum;
    }
    public int calculdigits(int num,int flag){
        if (num/10==0){
            return ++flag;
        }
        else{
            return calculdigits(num/10,++flag);
        }
    }
}






class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if((10 <= nums[i] && nums[i] < 100) || (1000 <= nums[i] && nums[i] < 10000) || (100000 <= nums[i])){
                count++;
            }
        }
        return count;
    }
}
/* Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
    Alt+shift+A
Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6] */

/**
 * Merge
 */
public class Merge {
    public void merge_my(int[] nums1, int m, int[] nums2, int n) {
        int FlagFor1=m-1;
        int FlagFor2=n-1;
        int FinalFlag=m+n-1;
        for (;FinalFlag>=0;FinalFlag--){
            
            if(FlagFor1<0||FlagFor2<0){
                break;
            }
            
            else{
                
                if(nums1[FlagFor1]>nums2[FlagFor2]){
                    nums1[FinalFlag]=nums1[FlagFor1--];
                }else{
                    nums1[FinalFlag]=nums2[FlagFor2--];
                }
                    
                
                
            }    
        }
        
        if(FlagFor1<0){
            for(int i=FlagFor2;i>=0;i--){
                nums1[FinalFlag--]=nums2[i];
            }
        }
        if(FlagFor2<0){
            for(int i=FlagFor1;i>=0;i--){
                nums1[FinalFlag--]=nums1[i];
            }
        }
             
        
        
    }

    public void merge(int A[], int m, int B[], int n) {
        int i=m-1;
		int j=n-1;
		int k = m+n-1;
		while(i >=0 && j>=0)
		{
			if(A[i] > B[j])
				A[k--] = A[i--];
			else
				A[k--] = B[j--];
		}
		while(j>=0)
			A[k--] = B[j--];    //only consider array B, because take array B as main array insert to array A
    }

    
}
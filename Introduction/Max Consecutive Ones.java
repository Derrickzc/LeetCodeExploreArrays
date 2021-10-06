class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        for (int i=0;i<nums.length;i++)
        {
            if(i+1==nums.length)
                break;
            
            if(nums[i+1]!=0)
            {
                nums[i+1]=nums[i]+nums[i+1];
            }
            else{
                continue;
            }
        }
        
        int result=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>result){
                result=nums[i];
            }
            else{
                continue;
            }
        }
        return result;
        
        
        
        
    }
}

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currentResult=0,previousResult=0;
        for(int i:nums){
            if(i==1){
                currentResult++;
                previousResult=Math.max(currentResult,previousResult);//这个要 实时更新，避免[1]情况
            }
            else{
                currentResult=0;
            }
        }
        return previousResult;
    }
}



//最短的时间
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int prevCount = 0,count =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
            }else {
                if(count != 0 && prevCount<count){
                    prevCount=count;
                }
                count = 0;
                continue;
            }
        }
        if(count<prevCount){
            return prevCount;    
        }else{
            return count;
        }
        
    }
}
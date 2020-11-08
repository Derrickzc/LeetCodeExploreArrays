
/* Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1. */

/* Example 1:

Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]
 
 */
public class ReplaceElementwithGreat {
    
    //我的方法太慢了，
    public int[] replaceElementsmy(int[] arr) {
        
        for(int i=0;i<arr.length-1;i++){
        
            int Temp=arr[i+1];
            
            for(int j=i+1;j<arr.length;j++){
                if(Temp<arr[j]){
                    Temp=arr[j];
                }
                
            }
            arr[i]=Temp;
            
            
            
            
        }
        arr[arr.length-1]=-1;
    
        return arr;
    }


    //直接从后面开始遍历，找最大的然后赋值过去
    public int[] replaceElements(int[] arr) {
        for (int i = arr.length - 1, max = -1; i >= 0; --i) {
            int tmp = arr[i];
            arr[i] = max;
            max = Math.max(max, tmp);
        }
        return arr;
    }


}
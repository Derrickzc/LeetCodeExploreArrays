/* Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).

More formally check if there exists two indices i and j such that : 

Example 1:

Input: arr = [10,2,5,3]
Output: true
Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.
Example 2:

Input: arr = [7,1,14,11]
Output: true
Explanation: N = 14 is the double of M = 7,that is, 14 = 2 * 7.
Example 3:

Input: arr = [3,1,7,11]
Output: false
Explanation: In this case does not exist N and M, such that N = 2 * M.


*/
import java.util.HashSet;
public class CheckIfNandItsDoubleElement {
    public boolean checkIfExistmy(int[] arr) {
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]==arr[j]*2 || arr[j]==arr[i]*2 ){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int a : arr) {
            if(set.contains(a*2) || (a%2 == 0 && set.contains(a/2))) return true;
            set.add(a);
        }
        return false;
    }

}
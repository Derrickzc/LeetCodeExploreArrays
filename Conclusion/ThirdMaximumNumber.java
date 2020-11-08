package Conclusion;


/* Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum. */

public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        if (nums.length==1) return nums[0];
        else if(nums.length==2) return Math.max(nums[0], nums[1]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            if (pq.size() < 3 && !pq.contains(num)) {
                pq.add(num);
                continue;
            } else if (num > pq.peek() && !pq.contains(num)) {
                pq.poll();
                pq.add(num);
            }
        }
        
        if(pq.size() < 3) {
            while(pq.size() != 1) pq.poll();
        }
        
        return pq.peek();
    }
}
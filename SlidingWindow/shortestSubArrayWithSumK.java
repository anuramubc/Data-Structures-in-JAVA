import java.util.HashMap;

public class shortestSubArrayWithSumK {
    public static void main(String[] args) {
        /*int nums[] = {1, 4, 45, 6, 0, 19};
        int k =51;
        int n = nums.length;
        int res = smallestSubWithSumSubOptimal(nums, n, k);
        System.out.println(res);*/

        /*String s= "zvvo";
        String out = removeDups(s);
        System.out.println(out.toCharArray());*/
       // s.replace("v", "0");
        //System.out.println(s.toCharArray());
        String s = 
        "amanaplanacanalpanama";
        int[] nums2 = {7,2,5,10,8};
        int out = splitArray(nums2, 2);
        System.out.println(out);
        System.out.println(1%24);
        System.out.println(4%3);

    }
    //Problem : Smallest subarray with sum greater than x where the array has only positive values
    //https://practice.geeksforgeeks.org/problems/smallest-subarray-with-sum-greater-than-x5651/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab
    //If the given array has only positive values then two pointer sliding method will work. But this method is suboptimal
    public static int smallestSubWithSumSubOptimal(int a[], int n, int x) {
        // Your code goes here 
                
        int left = 0;
        int right = 0;
        
        int result = Integer.MAX_VALUE;
        while(left <= right && right <n){
            int sum = 0;
            int minlen = 0;
            while(sum<=x && right<n){
                sum += a[right];
                minlen +=1;
                right++;
            }
            if(sum >x && result > minlen){
                result = minlen;
            }
            left++;
            right=left;
            }
        if(result == Integer.MAX_VALUE){
            return 0;
        }
        return result;
    }

    //Two pointer sliding window method: More optimized. Complexity is O(n)
    public static int smallestSubWithSum(int a[], int n, int x) {
        // Your code goes here 
                
        int left = 0;
        int right = 0;
        int sum = 0;
        int minlen = Integer.MAX_VALUE;
        while(left <= right && right <n){
            //If the sum<=x and right <n
            //Then keep adding current right elements and incrementing right pointer, until we reach a sum >target x
            while(sum<=x && right<n){
                sum += a[right];
                right++;
            }
            //If we reached a sum > target, then subtract the left most element from sum and increment left pointer until
            //we sum<=x. 
            //While decreasing the pointer. check the len of the current subarray under consideration given by right-left
            //If that len < minlen, then replace minlen
            while(sum >x && left <=right){
                if(minlen > right - left){
                    minlen = right - left;
                }
                sum -=a[left];
                left++;
            }
            
            }
        if(minlen == Integer.MAX_VALUE){
            return 0;
        }
        return minlen;
    }

    //Problem: https://practice.geeksforgeeks.org/problems/remove-duplicates3034/1
    static String removeDups(String S) {
        // code here
        HashMap<Integer, Character> hm = new HashMap<Integer, Character>();
        int j =0;
        for(int i =0;i<S.length(); i++){
            char ch = S.charAt(i);
            if(!hm.containsValue(ch)){
                hm.put(j, ch);
                j++;
            }
        }

        String out = "";
        for(int i =0; i<j; i++){

            out+=hm.get(i);
        }
        
        return out;
    }

    public static int splitArray(int[] nums, int k) {
        int x = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 1; i<=nums.length-k+1; i++){
            int sum = 0;
            int j = x;
            while(j<i+k-1 && j<nums.length){
                sum += nums[j];
                j++;
            }
            if(max < sum){
                max = sum;
            }
            x++;
        }
        return max;
    }
}

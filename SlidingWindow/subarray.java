import java.util.ArrayList;

public class subarray {
    public static void main(String[] args) {
        int[] nums = {135, 101, 170, 125, 79 ,159, 163, 65 ,106, 146, 82 ,28, 162,
             92, 196, 143, 28, 37, 192, 5, 103, 154, 93, 183, 22, 117, 119, 96, 48, 127, 172, 139, 70, 113, 68, 100, 36, 95, 104, 12, 123, 134};
        int n =42;
        int s =468;
        ArrayList<Integer> result = subarraySum(nums, n, s);
        for(int i =0; i<result.size(); i++){
            System.out.println(result.get(i));
        }
    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        //Solution uses two pointer sliding method. Left and right pointer
        //Right poiinter is to increase the sum and left pointer is to decrease the sum
        int sumcalc = 0;
        int left = 0;
        int right = 0;
        ArrayList<Integer> out = new ArrayList<Integer>();
        while(right <n && left <=right){
            //Add the current right to the sum
            sumcalc += arr[right];
            //If the sum we calcualted was > target sum , then keep subtracting the previous elements we added until it 
            //becomes smaller or equal to the target sum
            //While decreasing the sum calculated, make sure to increment left pointer to reduce the seach space as 
            // the previous left element was not a good candidate 
            while(left < right && sumcalc>s){
                sumcalc -= arr[left];
                left++;
            }
            if(sumcalc == s){
                out.add(left+1);
                out.add(right+1);
                return out;
            }
            //Increment right until we reach the desired summ
            right++;
        }
        //If we don't find the target sum in the subarray , return -1
        out.add(-1);
        return out;
    }
}


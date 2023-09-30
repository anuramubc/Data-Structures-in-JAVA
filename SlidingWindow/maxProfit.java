import java.util.Arrays;
class maxProfit {
    public static void main(String[] args){
        int[] nums = {7,1,5,3,6,4};
        System.out.println(maxProfitStocks(nums));
    }

    public static int maxProfitStocks(int[] nums){
        //Initialize Left and right pointers
        int left = 0;
        int right = left+1;
        int maxiProfit = 0;
        while(right<nums.length){
            if(nums[left]> nums[right]){
                left = right;
            }
            else{
                int profit = nums[right] - nums[left];
                if(profit>maxiProfit){
                    maxiProfit = profit;
                }
            }
            right++;
        }
        return maxiProfit;
    }

    
}

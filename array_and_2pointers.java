import java.util.Arrays;
import java.util.HashMap;
class array_funcs_with2pointers{
//main method

public static void main(String[] args){

    //Testing Two sum 2: Problem 167
    //Test 1
    int[] nums = {1, 3, 4, 5, 7, 11};
    int target = 9;
    System.out.println("The indices of the elements who's sum equal to the target is"+Arrays.toString(twoSum2(nums, target)));

    //Test 2
    int[] nums2 = {2,3,4};
    int target2 = 6;
    System.out.println("The indices of the elements who's sum equal to the target is"+Arrays.toString(twoSum2(nums2, target2)));

    //Test 3
    int[] nums3 = {-1,0};
    int target3 = -1;
    System.out.println("The indices of the elements who's sum equal to the target is"+Arrays.toString(twoSum2(nums3, target3)));

    int[] nums4 = {0,2,1,0,2,1};
    System.out.println(Arrays.toString(dutchflagprob(nums4)));



}
//Leetcode 167: Two Sum 2: where the input array is sorted
//Problem statement: Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 < numbers.length.
//Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
//The tests are generated such that there is exactly one solution. You may not use the same element twice. Your solution must use only constant extra space.

//Logic: Note the fact that the input array is sorted in ascending order. So we can use two pointers one starting at the 0th index and one starting at n-1 index and compare the sum of elements in that index in the input array
//If the sum of these two numbers are less than the target we need to increase the sum. So we can increase the left pointer by one to get to a bigger number (since the arrays are sorted, always nums[n+1] > nums[n] ) to increase the overall sum.
//Similarly If the sum of these two numbers are greater than the target we need to decrease the sum. So we can decrease the right pointer by one to get to a smaller number (since the arrays are sorted, always nums[n-1] < nums[n] ) to decrease the overall sum.
//If the sum of these two numbers are equal to the target then return their respective indices added by 1.
// Continue this until left pointer < right pointer
public static int[] twoSum2(int[] nums, int target){
    //Initialize the left and right pointers. left is at 0 index and right is at last index
    int left = 0;
    int right = nums.length -1;

    while(left < right){
        //check the conditions.
        //If nums[left] + nums[right] < target then increase left by 1 since we want to increase the sum to meet the target
        if(nums[left] + nums[right] < target){
            left++;
        }
        //If nums[left] + nums[right] > target then decrease right by 1 since we want to decrease the sum to meet the target
        else if(nums[left] + nums[right] > target){
            right--;
        }
        else{
            int[] output = {left+1, right+1};
            return output;
        }
    }

    return null;
}

public static int[] dutchflagprob(int[] nums){
    int i = 0;
    int j = nums.length-1;
    while(i<j){
        while(nums[i] == 0 || nums[i] == 1){i++; }
        while(nums[j] == 2){j--;}
        if(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

    }
    i = 0;
    j = nums.length-1;
    while(i<j){
        while(nums[i] == 0){i++; }
        while(nums[j] == 2){j--;}
        if(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

    }

    return nums;
}

}
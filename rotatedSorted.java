public class rotatedSorted {
    public static void main(String[] args) {
        int[] nums = {1};
        int  out = findPeakElement(nums);
        System.out.println(out);
    }
    public static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length -1;
        // We modify the binary search to find the peak of the rotated array . The next element to the peak will be the minimum element
        while(start<=end){
            //First check if the array is rotated or not
            //Since the array is sorted if the start <= end, we know that the array is not rotated and we can return the element at first index
            if(nums[start] <= nums[end]){return nums[0];}
            //If the array is rotated then, There will be four cases
            int mid = start + (end - start)/2;

            //Case 1: if nums[mid] >= nums[mid+1], then nums[mid+1] is the minimum value since it in the decreasing section of the array
            if(nums[mid] > nums[mid+1]){return nums[mid+1];}

            //Case 2: if nums[mid-1] > nums[mid], then nums[mid] is the minimum value since it in the decreasing section of the array
            if(nums[mid-1] > nums[mid]){return nums[mid];}

            //Cae 3: if nums[start] > nums[mid], then we know that the peak will be somewhere from the start element to the mid+1th element
            if(nums[start] > nums[mid]){end = mid-1;}
            else{
            //Case 4: if nums[start] < nums[mid], then make start to mid-1
            start = mid+1;
            }

        }
        return -1;
}

public int search(int[] nums, int target) {
    //First find the peak element
    int peak = findPeak(nums);
    //Now run binary search from start to peak
    int start = 0;
    int result = binarySearchWithIdx(nums, start, peak, target);
    //If we did not find the target in this seaction of the array then we need to move to the search to the next section of the array
    if(result == -1){
        result = binarySearchWithIdx(nums, peak+1, nums.length-1, target);
    }
    return result;
    
}

//Helper function to find the peak element in the rotated sorted array
public static int findPeak(int[] nums){
    int start = 0;
    int end = nums.length-1;
    while(start <= end){
    //check if nums[start] <= nums[end] then array is not rotated
    if(nums[start] < nums[end]){return end;}
    //Else the array is rotated and run four cases to find the peak
    int mid = start +(end- start)/2;
    //case 1: condition to find the peak 
    if(nums[mid] > nums[mid+1]){return mid;}
    //Case 2: condition to find the peak 
    if(nums[mid-1] > nums[mid]){return mid-1;}
    //Case3: shift end ptr to search the space from start to mid-1 to find the peak
    if(nums[start] > nums[mid]){end = mid-1;}
    //Case4: shift start ptr to search the space from mid+1 to end to find the peak
    else{
        start = mid+1;
    }
    }
    return -1;
}

//Helper method to perform binary search from start to end indexx
public static int binarySearchWithIdx(int[] nums, int start, int end, int target){
    
    while(start <= end){
    int mid = start +(end- start)/2;
    if(nums[mid] ==target){
        return mid;
    }
    if(nums[mid] > target){
        end = mid-1;
    }else{
        start = mid+1;
    }
    }
    return -1;
}

public static int findPeakElement(int[] nums) {
    int start = 0;
    int end = nums.length-1;
    while(start <= end){
        int mid = start + (end - start)/2;
        if(mid < end && nums[mid] > nums[mid+1]){return mid;}
        if(mid > start && nums[mid-1] > nums[mid]){return mid-1;}
        if(nums[start] > nums[mid]){
            end = mid-1;
        }else{
            start = mid+1;
        }
    }
    return nums[end];
}
}

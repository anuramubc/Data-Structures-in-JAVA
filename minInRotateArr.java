class minInRotateArr{
    public static void main(String[] args){
        //Test 1
        int[] nums = {3,4,5,1,2};
        System.out.println(findMin(nums));

        //Test 2
        int[] nums2 = {4,5,6,7,8,0,1,2};
        System.out.println(findMin(nums2));

        //Test 3
        int[] nums3 = {11,15,16,17};
        System.out.println(findMin(nums3));
    }
    public static int findMin(int[] nums){
        //First find the peak of the rotated sorted array
        int start = 0;
        int end = nums.length -1;
        while(start <=end){
            int mid = start + (end - start)/2;
            //First check if the array is sorted and unrotated
            if(nums[start] <= nums[end]){return nums[0];}
            //Case1: if mid<end and we know that mid>mid+1 then we have found the peak at mid. Then mid+1 will be the min element
            //Since in rotated array only descending order would exist between the peak and its neighbour on the right side
            if(mid < end && nums[mid] > nums[mid+1]){return nums[mid+1];}
            //Case2: if mid>start and we know that mid-1>mid then we have found the peak at mid-1. Then mid will be the min element
            //Since in rotated array only descending order would exist between the peak and its neighbour on the right side
            if(mid > start && nums[mid-1] > nums[mid]){return nums[mid];}
            //Case3: If start element is >= mid, then we can ignore all the elements from mid to end since they will all be less than start. So make end = mid-1
            if(nums[start] >= nums[mid]){end = mid-1;}
            //Case4: If start element is < mid, then we can ignore all the elements from start to mid since they will all be less than mid+1. So make start = mid+1
            else{start = mid+1;}
        }
        return -1;
    }
    
}

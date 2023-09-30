class rotationcount {
    public static void main(String[] args){
        //Test 1
        int[] nums = {15,18,2,3,6,12};
        System.out.println(rotationCountInRotSortArr(nums));

        //Test 2
        int[] nums2 =  {7, 9, 11, 12, 5};
        System.out.println(rotationCountInRotSortArr(nums2));

        //Test 3
        int[] nums3 = {1};
        System.out.println(rotationCountInRotSortArr(nums3));

        //Test 4
        int[] nums4 = {11,12,13,14};
        System.out.println(rotationCountInRotSortArr(nums4));

    }

    public static int rotationCountInRotSortArr(int[] nums){
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            //Check if the array is rotated or not
            if(nums[start] <= nums[end]){return 0;}
            //Else the array is rotated and continue to find the peak of the array
            int mid = start +(end - start)/2;
            if(nums[mid] >= nums[mid+1]){//We have found the peak, so return peak index +1 as the number of rotations
            return mid+1;}
            if(nums[mid-1] >= nums[mid]){//We have found the peak, so return peak index-1+1 as the number of rotations
            return mid;}
            if(nums[start]<nums[mid]){start = mid+1;}
            else{end = mid-1;}
        }
        return -1;
    }
    
}

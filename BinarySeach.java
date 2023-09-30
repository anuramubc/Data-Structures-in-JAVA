import java.util.Arrays;
class BinarySearch {

    public static void main(String[] args){
        //Testing first and last position of element in a sorted array
        //Test 1
        int[] nums = {5,7,7,7,8,8,10};
        int target = 7;
        //Testing using Brute force method 
        System.out.println(Arrays.toString(searchRangeBrute(nums, target)));
        //Testing using two binary search
        System.out.println(Arrays.toString(searchRange(nums, target)));

        //Testing Find position of an element in a sorted array of infinite numbers
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        target = 8;
        System.out.println(SearchInfiteArray(arr, target));

        //Testing peak index in mountain array
        //Test1
        int[] nums2 = {0,1,0};
        System.out.println(peakIndexInMountainArray(nums2));
        //Test2
        int[] nums3 = {0,2,1,0};
        System.out.println(peakIndexInMountainArray(nums3));
        //Test2
        int[] nums4 = {0,10,5,2};
        System.out.println(peakIndexInMountainArray(nums4));

        //Testing find target in mountain array
        int[] arr2 = {1,2,3,4,5,3,1};
        int target2 = 2;
        //System.out.println(findInMountainArray(target2, arr2));
        //System.out.println(orderAgnosticBinarySearch(arr2, target2, 0,4, true));

        //Testing
        //Test 1
        int[] arr3 = {4,5,6,7,0,1,2};
        int target3 = 0;
        System.out.println(searchInRotatedSortedArr(arr3, target3));
        //Test 3
        target3 = 3;
        System.out.println(searchInRotatedSortedArr(arr3, target3));
        //Test2
        int[] arr4 = {1};
        int target4 = 0;
        System.out.println(searchInRotatedSortedArr(arr4, target4));
        


    }

    //Leetcode 34: Find First and Last Position of Element in Sorted Array
    //Problem statement: Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value. If target is not found in the array, return [-1, -1]. You must write an algorithm with O(log n) runtime complexity.
    // Logic 1: Using Brute force Time complexity O(n)
    // Logic 2: Using two binary search operations to find the starting and the ending index: Time complexity O(logn)
    public static int[] searchRangeBrute(int[] nums, int target){
        int l_result = -1;
        int r_result = -1;

        for(int i = 0; i<nums.length; i++){
            if(nums[i] == target && l_result == -1){
                l_result = i;
                r_result = i;
            }
            else if(nums[i] == target){r_result = i;}
        }
        return new int[]{l_result, r_result};
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        //Here searchWithBS is a helper function to run binary search
        int start_index = searchWithBS(nums, target, true);
        int end_index = searchWithBS(nums, target, false);
        ans[0] = start_index;
        ans[1] = end_index;
        return ans;
    }
    
    public static int searchWithBS(int[] nums, int target, boolean findStartIndex){
        int l = 0;
        int h = nums.length-1;
        int ans = -1;
        while(l <=h){
        int mid = l + (h-l)/2;
        if(nums[mid] < target){l = mid +1;}
        else if(nums[mid] > target){h = mid -1;}
        else{
            //Here nums[mid == target], so we have found a potential answer. Store it in ans
            ans = mid;
            //Now to look for the starting index of target in the array, lower the search space from l to mid-1
            if(findStartIndex){h = mid -1;}
            //Now to look for the ending index of target in the array, lower the search space from mid+1 to h
            else{l = mid +1;}
        }
        }
        return ans;
    }

    /*Problem: Find position of an element in a sorted array of infinite numbers GeekforGeeks: 
    Problem Statement: Suppose you have a sorted ascending array of infinite numbers, how would you search an element in the array? Note: this problem assumes no "out of bound index error" since it is an infinite array
    Logic: Since the array is sorted use Binary Search. But the catch is we cannot find the length of the array since it is infinte. 
    To address this issue: Expand the search space in chunks to identify the chunk where the target might be located. Once that is identified perform binary search in that chunk */

    public static int SearchInfiteArray(int[] nums, int target){
        //Initially the search space is just the first two elements, so
        int start = 0;
        int end = start+1;

        //Now identify the chunk within which the target might be located. To do that optimally double the seach space in each iteration 
        //Also note that the array is sorted in asc order: so if we know that the element at the end of the chunk is less than the target, we can say for sure that target will not be in that range and move onto the next chunk
        while(nums[end] < target){
            //To move to the next chunk
            int newStart = end+1;
            //To double the search space every iteration: formula is newEnd = end+size_of_currentchunk *2 = end+(end-start+1)*2
            end = end+2*(end-start+1);
            start = newStart;
        }
        //While loop is exited once we have found a chunk that could contain the target value
        //So run Binary search within this chunk to see if we have found the target value and return its index. If not found return -1;
        return binarySearchModified(nums,target, start, end);
    }
    //Helper function binarySearchModified: it runs binary search within the start and enf index mentioned
    public static int binarySearchModified(int[] nums, int target, int start, int end){
        int l = start;
        int h = end;
        
        while(l<= h){
            int mid = l+(h-l)/2;
            if(nums[mid]<target){l = mid+1;}
            else if(nums[mid] > target){h = mid-1;}
            else {return mid;}
        }
        return -1;
    }

    /*Leetcode 852: Find peak index in a mountain array
    Mountain array has ascending and desc part in the same array.
    Problem statement: Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1]. Solve it in O(logN) complexity
     Logic: Use Binary Search and compare mid element with mid+1 neighbour to detect if we are in the asc part of the array or in the desc part of the array. and reduce the search space according until both start and end pointer point at the same index.
    That would give the peak of the mountain array.
    Since we are using binary search time complexity is still O(logN) */
    public static int peakIndexInMountainArray(int[] arr){
        int start = 0;
        int end = arr.length -1;
        while(start < end){
            //calculate mid
            int mid = start + (end - start)/2;
            // if nums[mid] < nums[mid+1] : it is in ascending order. So reduce the search space from mid+1 to end
            if(arr[mid] < arr[mid+1]){start = mid+1;}
            //else if nums[mid] > nums[mid+1]: it is descending order. So reduce the search space from start to mid
            else{end = mid;}
        }
        //While loop is exited when start = end. This means we have found the peak of the array
        return start;
    }

    /*Leetcode 1095: Find in Mountain Array
    Problem Statement: Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such an index does not exist, return -1.
    Logic: Use the function written above to find the peak element of the mountain array. Once we figure out the peak element we know the array is asc sorted from start to peak and desc sorted from peak+1 to end
    Then we can use binary seach on the asc part to search for the target and if not found then we can use binary search again to search for target in desc sorted part of the array.
    Since we are using binary search 3 times, time complexity is still O(logN)
     */

     public static int findInMountainArray(int target, int[] arr){
        //Find the peak first using peakIndexInMountainArray() function
        int peak = peakIndexInMountainArray(arr);
        //Run binary search in the asc part of the array ie from start to peak
        int start = 0;
        int end = arr.length-1;

        int target_in_asc = orderAgnosticBinarySearch(arr,target, start, peak, true);
        //If the element is not found in the asc part then search for target in desc part of the array. else return what we found 
        if(target_in_asc != -1){return target_in_asc;}
        else{return orderAgnosticBinarySearch(arr, target, peak+1, end, false);}
     }
     

     //Helper method: orderAgnosticBinarySearch()
     public static int orderAgnosticBinarySearch(int[] arr, int target, int start_index, int end_index, boolean findInAsc){
        //This performs binary search for asc order or desc order
        while(start_index <= end_index){
            int mid = start_index + (end_index - start_index)/2;
            //if arr[mid] is the target return mid
            if(arr[mid] == target){return mid;}
            //Binary search step updates for asc sorted array
            if(findInAsc){
                if(arr[mid] < target){start_index = mid+1;}
                else{end_index = mid-1;}
            }//Binary search step updates for asc sorted array
            else{
                if(arr[mid] < target){end_index = mid-1;}
                else{start_index = mid+1;}
            }
        }
        return -1;
     }

     /*Leetcode 33. Search in Rotated Sorted Array
      Problem statement: Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
      You must write an algorithm with O(log n) runtime complexity.
      Logic: Step 1: Find the pivot or pivot element of the array. Once we have found that since the array was initially sorted in asc order, we can conlude that start to peak is in asc order and peak+1 to end 
      //is in asc order
      Step2: Now use binary search on each section to find the target element.
      This logic will work only if we don't have duplicate elements.
      */
      
      public static int searchInRotatedSortedArr(int[] nums, int target){
        //First let's find the peak using peakInRotatedSortedArray
        int peak = peakInRotatedSortedArray(nums);
        //If peak is -1 means there is no rotation of the element. Then it's just a normal binary search for asc sorted array
        //Then we can use binary search to find the target to the first section of the array from start to peak since they are sorted in ascending order. For this use the helper method defined already binarySearchModified
        int start = 0;
        int end = nums.length-1;
        int target_idx;
         //If peak is not equal to -1 means it is a rotated sorted array. Then implement the logic specified above
        if(peak != -1 ){
        target_idx= binarySearchModified(nums, target, start,peak);
        if(target_idx != -1){//If we have found the target element in the first section of the array return target idx
        return target_idx;
        }
        else{
            return binarySearchModified(nums, target, peak+1, end);
        }
        }
        //If peak is -1 means there is no rotation of the element. Then it's just a normal binary search for asc sorted array
        else{ 
            return binarySearchModified(nums, target, start, end);
        }
      }
      //Helper method to find peak in the rotated sorted array
      public static int peakInRotatedSortedArray(int[] nums){
        //Let the start index be 0 and end index be nums.length-1
        int start = 0;
        int end = nums.length -1;
        while(start<=end){
            int mid = start + (end - start)/2;
            //Case1: if mid<end and we know that mid>mid+1 then we have found the peak at mid. Since in rotated array only descending order would exist between the peak and its neighbour on the right side
            if(mid < end && nums[mid] > nums[mid+1]){return mid;}
            //Case2: if mid>start and we know that mid-1>mid then we have found the peak at mid-1. Since in rotated array only descending order would exist between the peak and its neighbour on the right side
            if(mid > start && nums[mid-1] > nums[mid]){return mid-1;}
            //Case3: If start element is >= mid, then we can ignore all the elements from mid to end since they will all be less than start. So make end = mid-1
            if(nums[start] >= nums[mid]){end = mid-1;}
            //Case4: If start element is < mid, then we can ignore all the elements from start to mid since they will all be less than mid+1. So make start = mid+1
            else{start = mid+1;}
        }
        return -1;
      }



}


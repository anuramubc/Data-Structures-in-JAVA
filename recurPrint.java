import java.util.ArrayList;
import java.util.Arrays;

class recurPrint {
    /* Program to print n elements recursively */

    public static void main(String[] args){
        int n = 10;
        printNto1(n);
        print1toN(n);
        System.out.println(factorial(10));
        System.out.println(sumofN(1));
        System.out.println(sumofDigits(1342));
        reversen(12345);
        int[] nums = {1,2,4,3,5,6};
        System.out.println(isSortedArray(nums, 0));
        int target = 3;
        System.out.println(linearSearch(nums, target, 0));
        System.out.println(linearSearchIndex(nums, target, 0));
        int[] nums2 = {5,2,2,2,3,4};
        target = 2;
        ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.println(linearSearchAllIdx(nums2, target, 0, list));
        System.out.println(linearSearchAllIdx2(nums2, target, 0));   
        System.out.println(binarySearchRecur(nums, target, 0, 5));
    
    
    }


    public static void printNto1(int n){
        //First check if n is <1. If so then return nothing. This is the base case
        if(n <1){return ;}
        //Else print the n and then give a recursive call to printN function itself
        System.out.println(n);
        //Recursive call to printN to print the next element
        printNto1(n-1);
    } 

    public static void print1toN(int n){
        //First check if n is <1. If so then return nothing. This is the base case
        if(n <1){return ;}
        //Else do the recursice call to n-1 element and after executing that print n 
        //Recursive call to printN to print the next element
        print1toN(n-1);
        System.out.println(n);

    }

    public static int factorial(int n){
        //Base case:
        if(n==1){return 1;}
        return n * factorial(n-1);
    }

    public static int sumofN(int n){
        //Base case:
        if(n==1){return 1;}
        return n+sumofN(n-1);
    }
    public static int sumofDigits(int n){
        //base case
        if(n == 0){return 0;}
        int reminder = n%10;
        return reminder + sumofDigits(n/10);
    }
    public static void reversen(int n){
        if(n == 0){return ;}
        //int remain = n%10;
        System.out.println(n%10);
        reversen(n/10);
    }
    public static boolean isSortedArray(int[] nums, int index){
        //Base case: 
        if(index == nums.length -1){return true;}
        return nums[index] < nums[index+1] && isSortedArray(nums, index+1);
    }

    public static boolean linearSearch(int[] nums, int target, int index){
        //base case
        if(index > nums.length-1){return false;}
        return nums[index] == target || linearSearch(nums, target, index+1);
    }
    public static int linearSearchIndex(int[] nums, int target, int index){
        //base case
        if(index>nums.length-1){return -1;}
        if(nums[index] == target){return index;}
        else{return linearSearchIndex(nums, target, index+1);}
    }
    public static ArrayList<Integer> linearSearchAllIdx(int[] nums, int target, int index, ArrayList<Integer> list){
        //Base case
        if(index == nums.length){return list;}
        if(nums[index] == target){list.add(index);}
        return linearSearchAllIdx(nums, target, index+1, list);

    }
    public static ArrayList<Integer> linearSearchAllIdx2(int[] nums, int target, int index){
         ArrayList<Integer> list = new ArrayList<>();
        //Base case
        if(index == nums.length){return list;}
        //This will constain answer for that function call only
        if(nums[index] == target){list.add(index);}
        ArrayList<Integer> answerFromBelowCells = linearSearchAllIdx2(nums, target, index+1);
        list.addAll(answerFromBelowCells);
        return list;

    }
    public static int binarySearchRecur(int[] nums, int target, int start_idx, int end_idx){
        //Base case
        if(start_idx>end_idx){return -1;}
        //If we encounter the target at mid return mid index
        int mid = start_idx +(end_idx - start_idx)/2;
        if(nums[mid] == target){return mid;}
        //Update rule
        //If nums[mid] > target then search space is start to mid-1. Do recursive call from start to mid-1
        if(nums[mid] > target){return binarySearchRecur(nums, target, start_idx, mid-1);}
        else{return binarySearchRecur(nums, target, mid+1, end_idx);}
    }
}

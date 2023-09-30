import java.io.*;
import java.util.*;

public class spiralmatrix {
    

//{ Driver Code Starts
    public static void main(String args[])throws IOException
    {

            //int matrix[][] = new int[r][c];
            
            /*int matrix[][] = {{1, 1,1, 2, 3, 3, 5, 18, 18, 25},
             {1, 6, 6, 7, 10, 10, 11, 22, 26, 36},
             {14, 14, 19, 20, 22, 26, 31, 39, 39, 44},
             { 15, 19, 21, 23, 26, 33, 34, 43, 48, 63},
              {15, 25, 25, 26, 37, 42, 45, 46, 66, 78},
              { 27, 32, 41, 44, 51, 51, 56, 60, 77, 87},
              { 28, 44, 51, 55, 59, 70, 78, 81, 86, 96},
              { 44, 52, 55 ,64, 77, 80, 83, 83, 97, 98},
               {63, 71, 73, 80, 81, 85, 88, 90, 97, 99},
               { 67, 74, 78, 82, 93, 96, 98, 99, 100, 100}}; */

            int matrix[][] = {{2,2},{1,0},{0,0}};

            int r = matrix.length;
            int c = matrix[0].length;
            
            //ArrayList<Integer> ans = spirallyTraverse(matrix, r, c);
            //for (Integer val: ans) 
            //    System.out.print(val+" "); 
            //System.out.println();
            //interchange(matrix, r, c);
            //for(int i =0; i<r; i++){
            //    for(int j = 0 ; j<c; j++){
            //        System.out.println(matrix[i][j]);
            //    } 
            //}
            //boolean out = search(matrix, r,c, 101);
            //System.out.println(out);
            booleanMatrix(matrix);
            /*for(int i =0; i<r; i++){
                for(int j = 0 ; j<c; j++){
                    System.out.println(matrix[i][j]);
                } 
            } */
        
    }

// } Driver Code Ends

    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        // code here 
        //ArrayList to store the output
        ArrayList<Integer> output = new ArrayList<Integer>();
        
        //Initialize four pointers
        //top is at the first row
        int top = 0;
        //Bottom is at the last row
        int bottom = matrix.length-1;
        //left is at the first column
        int left = 0;
        //right is at the last column
        int right = matrix[0].length-1;
        
        //As long as left <= right and top <= bottom, we need to implement four for loops for spiral traversal
        while(left <= right && top <= bottom){
            //Loop 1: Traverse from left to right in the top row
            for(int i = left; i<=right; i++){
                output.add(matrix[top][i]);
            }
            //By the end of this loop we would have traversed the entire top row. So move the top row to the next row
            top++;
            
            //Loop 2: Traverse from top to bottom in the right most column
            for(int i = top; i<= bottom; i++){
                output.add(matrix[i][right]);
            }
            //By the end of this loop we would have traversed the entire right column. So move the right column to the 
            // previous column
            right--;
            
            //Since we changed the values of right and top make sure that they are still within limits
            if (!(left<= right && top<=bottom)){
                break;
            }
            
            //Loop 3: Traverse from right to left in the bottom row
            for(int i =right; i>=left; i--){
                output.add(matrix[bottom][i]);
            }
            //By the end of this loop we would have traversed the entire bottom row. So move the bottom row to 
            //the previous row
            bottom--;
            
            //Loop 4: Traverse from bottom to top in the left column
            for(int i = bottom; i>=top; i--){
                output.add(matrix[i][left]);
            }
            //By the end of this loop we would have traversed the entire left column. So move the left column to the 
            // next column
            left++;
        }
        
        return output;
        
    }

    static void interchange(int a[][],int r, int c){
        
        // Your code here
       for(int i =0; i<r; i++){
           int temp = a[i][0];
           a[i][0] = a[i][c-1];
           a[i][c-1] = temp;
       }
    }

    //Function to search a given number in row-column sorted matrix.
	static boolean search(int matrix[][], int n, int m, int x) 
	{  
	    // code here 
	    int ptr1 = m-1;
	    int ptr2 = 0;
	    
	    while(ptr2 < n){
	        if(matrix[ptr2][ptr1] < x){
	            ptr2++;
	        }else if(matrix[ptr2][ptr1] > x){
                ptr1--;
            }
            else{
                return true;
            }
            }
	  
	   return false;
	} 

    static void booleanMatrix(int matrix[][]){
        //Step1: get the index of elements that are one
        ArrayList<Integer> row_idx = new ArrayList<Integer>();
        ArrayList<Integer> col_idx = new ArrayList<Integer>();
        for(int i =0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                if(matrix[i][j] == 1){
                    row_idx.add(i);
                    col_idx.add(j);
                }
            }
        }

        //Step2: Run through each row and col in the row_idx and col_idx and replace 0's by 1
        for(int i =0; i<matrix.length; i++){
            if(row_idx.contains(i)){
                for(int j = 0; j<matrix[0].length; j++){
                if(matrix[i][j] != 1){
                    matrix[i][j] = 1;
                }
            }
        }
    }
        for(int j =0; j<matrix[0].length; j++){
            if(col_idx.contains(j)){
                for(int r = 0; r<matrix.length; r++){
                if(matrix[r][j] != 1){
                    matrix[r][j] = 1;
                }
            }
            }
        }

    }
}


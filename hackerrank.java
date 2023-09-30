import java.util.ArrayList;
import java.util.List;
class hackerrank {
    public static void main(String[] args) {
        int[] arr = {7, 69, 2, 221, 8974};
        //{-4,3,-9,0,4,1};
       miniMaxSum(arr);
    }
    

    public static void miniMaxSum(int[] arr) {
    // Write your code here
    
    int pre = 0;
    int post = 0;
    int[] result = new int[arr.length];
    int n = arr.length;
    for(int i=0; i<n; i++)
    {
        result[i] = pre;
        pre += arr[i];
    }
    for(int j = n-1; j>=0; j--){
        result[j] += post;
        post+= arr[j];
    }
    System.out.println(result[0] + " " + result[n-1]);

}

    
}

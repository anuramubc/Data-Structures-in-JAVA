import java.util.List;

public class min_loss {

    public static void main(String[] args){
        List<Long> price = 
    }

    public static int minimumLoss(List<Long> price) {
    // Write your code here
    //Output is set to maximum value
    int min_loss = Integer. MAX_VALUE;
    //use sliding window technique
    int left = 0;
    int right = left+1;
    while(right < price.size()){
        if (price.get(right) > price.get(left)){
            right+=1;
        } 
        else{
        int diff = (int) Math.abs(price.get(left) - price.get(right));
        if(diff <= min_loss){
            min_loss = diff;
            right+=1;
        }else{
            left+=1;
        }
        }
    }
    return min_loss;

    }
    
}

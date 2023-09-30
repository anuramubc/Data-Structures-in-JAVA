package StackQueue;
import java.util.Arrays;
import java.util.Stack;
class Duplicates_stack {
    public static void main(String[] args){
        String s = "))())(";
        int out = minInsertions(s);
        System.out.println(out);
    }


    public static String removeDuplicates(String s) {
        //Create an empty stack to store the non duplicate adjacent characters
        Stack<Character> new_stack = new Stack<Character>();
        //Iterate through the string s
        for(int i =0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(new_stack.empty() || new_stack.peek() != ch){
                new_stack.push(ch);
            }else{
                char removed_ch = (char) new_stack.pop();
            }   
        }
        String output = "";
        Object[] arr = new_stack.toArray();
        for(Object obj : arr){
            output += (char) obj;
        }
        return output;
    
    }
    public String removeDuplicates2(String s, int k){
        //Logic: Use two stacks namely character stack for storing the characters in the string and frequency stack for storing the number of occurences of that character in the string so far
        Stack<Character> char_stack = new Stack<Character>();
        Stack<Integer> freq_stack = new Stack<Integer>();

        for(int i =0; i<s.length(); i++){
            char ch = s.charAt(i);
            //Step 1: Check if the element we are going to push is already in the stack or not. If it is already in the stack then add +1 to the frequency stack  
            if(!char_stack.empty() && char_stack.peek() == ch){
                freq_stack.push(freq_stack.peek()+1);
            }else{
                freq_stack.push(1);
            }
            //push the character in the stack
            char_stack.push(ch);
            
            //Step2: Check if the frequency of each character is == given k. If it is equal then remove both the char and frequency from the stack "k" times
            if(freq_stack.peek() == k){
                for(int j =0; j<k; j++){
                    char_stack.pop();
                    freq_stack.pop();
                }
            }

        }

        String output = "";
        Object[] arr = char_stack.toArray();
        for(Object obj : arr){
            output += (char) obj;
        }
        return output;

    }

    public boolean isValid(String s){
        //Step1: Create a stack to store the paranthesis value
        Stack<Character> char_stack = new Stack<Character>();

       
        for(char ch : s.toCharArray()){
            if(char_stack.empty())
                char_stack.push(ch);
            else if(char_stack.peek() == '(' && ch == ')')
                char_stack.pop();
            else if(char_stack.peek() == '{' && ch == '}')
                char_stack.pop();
            else if(char_stack.peek() == '[' && ch == ']')
                char_stack.pop();
            else   
                char_stack.push(ch);
        }
        if(char_stack.empty())
            return true;
        return false;

    }

    public static int minInsertions(String s) {
        //Step1: Create a stack to store the paranthesis value
        Stack<Character> char_stack = new Stack<Character>();
        int i =0;
        while(i < s.length()){
            if(char_stack.empty()){
                char_stack.push(s.charAt(i));
                i+=1;}
            else if(char_stack.peek() == '(' && i+1 < s.length() && s.charAt(i) == ')' && s.charAt(i+1) == ')'){
                char_stack.pop();
                i +=2;}
            else{   
                char_stack.push(s.charAt(i));
                i+=1;}
        }
        //Step2: Return the size of the stack. This will contain the unclosed brackets
        int out = 0;
        float double_para = 0;
        float single_para =0;
        while(!char_stack.empty()){
        char removed = char_stack.pop();

        if(removed == ')'){
            double_para +=0.5;
        }
        if(removed == '('){
            single_para += 2; 
        }
        }
        out = (int) (single_para*double_para);
        return out;
    
    }
}

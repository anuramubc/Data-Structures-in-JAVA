package Trees;

import java.util.Scanner;

import javax.swing.tree.TreeNode;

public class binaryTree {
    

    //Create a class for creating a node to store the value, left pointer and right pointer
    private class Node{
        private int data;
        private Node left;
        private Node right;

        //Constructor
        public  Node(int data){
            this.data = data;
        }
    }

    //Also declare the root Node . since we need that to reference and traverse the tree in memory
    public Node root;

    //Method to create  a BinaryTree
    //Use recursion to create a binary tree
    public void populate(Scanner scanner){
        System.out.println("Enter the root node: ");
        //Read the input from the user
        int value = scanner.nextInt();
        //Create a node and assign it to be the root node
        root = new Node(value);
        //Now recursively call the populate() function to fill in the left and right subtrees of the root node
        populate(scanner, root);
    }
    private void populate(Scanner scanner, Node node){
        //First populate the left subtree
        //Ask the user if they want to enter the left side
        System.out.println("Do you want to enter left of"+ node.data);
        //Read the value entered by the user
        boolean left = scanner.nextBoolean();
        if(left){
            //Ask the user what value do they want to be the left node of the current node
            System.out.println("Enter the value of the left node of: " +node.data);
            int value = scanner.nextInt();
            //Create a new node with the value and assign it to the left node of the current node
            node.left = new Node(value);
            //Recursively call populate() with the node.left to enter the left node of node.left
            populate(scanner, node.left);
        }

        //Repeat the same for right subtree
        //Ask the user if they want to enter the right side
        System.out.println("Do you want to enter right of"+ node.data);
        //Read the value entered by the user
        boolean right = scanner.nextBoolean();
        if(right){
            //Ask the user what value do they want to be the right node of the current node
            System.out.println("Enter the value of the right node of: " +node.data);
            int value = scanner.nextInt();
            //Create a new node with the value and assign it to the right node of the current node
            node.right = new Node(value);
            //Recursively call populate() with the node.right to enter the right node of node.right
            populate(scanner, node.right);
        }
    }

    //display function
    public void display(){
        display(root, "");
    }
    private void display(Node node, String indent){
        if(node == null){return ;}
        System.out.println(indent + node.data);
        display(node.left, indent+"\t");
        display(node.right, indent+"\t");

    }

    //MAIN METHOD
    public boolean isSameTree(Node p, Node q) {
        if(p != null && q!= null){
            if(p.data == q.data){ return true;}
        }
        else if(p == null && q== null){return true;}
        else{return false;}
        //else if(p.val != q.val){return false;}
        return isSameTree(p.left, q.left) && isSameTree(p.right , q.right);
    }
}

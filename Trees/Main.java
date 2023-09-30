package Trees;

import java.util.Scanner;

public class Main {
        //Creating a binary tree
      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        binaryTree tree1 = new binaryTree();
        tree1.populate(scanner);
        tree1.display(); 
        /*Scanner scanner2 = new Scanner(System.in);
        binaryTree tree2 = new binaryTree();
        tree2.populate(scanner2);
        tree2.display(); 

        boolean out = tree1.isSameTree(tree1.root, tree2.root);
        System.out.println(out);*/

        //Creating a Binary Search Tree
        /*BST tr = new BST();
        //If this array is sorted this insert method will create a skewed tree not a balanced BST
        int[] nums = {5,2,7,1,4,6,9,8,3,10};
        tr.populateTr(nums);
        tr.display();*/

        /*BST tr2 = new BST();
        int[] nums2 = {1,2,3,4,5,6,7,8,9,10};
        tr2.populateTrSorted(nums2);
        tr2.display();*/




    }
}

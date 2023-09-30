package Trees;

public class BST {
    public class Node{
        private int value;
        private int height;
        private Node left;
        private Node right;
        
        public Node(int value){
            this.value = value;
        }
    

        //get method
        public int getValue(){
            return value;
        }
    }

        //root node
        private Node root;
    

        //constructor
        public void BST(){

        }
        //Get height of the tree
        public int height(Node node){
            if(node == null){return -1;}
            return node.height;
        }

        //Check if the tree is empty or not
        public boolean isEmpty(){
            return root == null;
        }

        //Method to insert an element in the tree
        private void insert(int value){
            root = insert(value,root);
        }
        private Node insert(int value, Node node){
            if(node == null){
                //If we reached a leaf node , create a new node and return that node
                node = new Node(value);
                return node;
            }
            if(value < node.value){
                node.left = insert(value, node.left);
            }
            if(value > node.value){
                node.right = insert(value, node.right);
            }
            //Updating the height since we added a new node
            node.height = Math.max(height(node.left), height(node.right)) +1;

            return node;
        }


        //Check if a tree is balanced or not
        public boolean balanced(){
            return balanced(root);
        }
        private boolean balanced(Node node){
            if(node == null){return true;}
            return Math.abs(height(node.left) - height(node.right)) <=1 && balanced(node.left) && balanced(node.right);
        }
        //Method to display the tree
        public void display(){
            display(this.root, "Root Node: ");
        }
        private void display(Node node, String details){
            if(node == null){
                return;
            }
            System.out.println(details + node.value);
            display(node.left, "Left child of " + node.getValue() + " : ");
            display(node.right, "Right child of " + node.getValue() + " : ");
        }

        //Given an array, convert that to a tree
        ////If this array is sorted this insert method will create a skewed tree not a balanced BST
        public void populateTr(int[] nums){
            for(int i = 0; i<nums.length; i++){
                this.insert(nums[i]);
            }
        }

        public void populateTrSorted(int[] nums){
            populateTrSorted(nums, 0, nums.length-1);
        }
        private void populateTrSorted(int[] nums, int start, int end){
            if(start > end){return ;}
            int mid = (start + end)/2;
            this.insert(nums[mid]);
            //Now populate with left and right sub trees
            populateTrSorted(nums, start, mid-1);
            populateTrSorted(nums, mid+1, end);
        }

        //Preorder Traversal: N -> L -> R
        public void preOrder(){
            preOrder(root);
        }
        private void preOrder(Node node){
            if(node == null){
                return ;
            }
            //Print current Node first
            System.out.println(node.value + " ");
            //Then print the left and then the right
            preOrder(node.left);
            preOrder(node.right);
        }

        //In order Traversal : Left -> Node -> Right
        public void inOrder(){
            inOrder(root);
        }
        private void inOrder(Node node){
            if(node == null){
                return ;
            }
            //Print left of the current Node first
            inOrder(node.left);
            //Then print the node itself
            System.out.println(node.value + " ");
            //Then print the right node 
            inOrder(node.right);
        }


        //Post order Traversal : Left -> Right -> Node
        public void postOrder(){
            postOrder(root);
        }
        private void postOrder(Node node){
            if(node == null){
                return ;
            }
            //Print left of the current Node first
            postOrder(node.left);
            //Then print the right node 
            postOrder(node.right);
            //Then print the node itself
            System.out.println(node.value + " ");

        }


}

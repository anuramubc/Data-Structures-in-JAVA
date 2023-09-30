
//Custom class structure for linkedlist
public class LL {
    //Initialize head and tail nodes
    public Node head;
    private Node tail;
    //Initialize size of the linkedlist
    private int size;
    public LL(){
        this.size = 0;
    }

    private class Node{
        //Store value of the node in value and next pointer in next of Node object
        private int value;
        private Node next;

        //Use condtructors 
        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    //Inserting node to the beginning of the linked list
    public void insertFirst(int val){
        //Create a new node with value = val and next pointer = null
        //The constructor will assign the val to the value of the node_new
        Node node_new = new Node(val);
        node_new.next = head;
        head = node_new;
        //If tail is null then it is the first element we are inserting in the linked list
        if(tail == null){
            tail = head;
        }
        //Increment size of the linkedlist by 1
        size+=1;

    }
    

    //Displaying linkedlist
    public void displayLL(Node node){
        //Since we cannot alter or increment the reference variable head as we will end up losing the access to the linkedlist
        //We need to use a temp reference variable to traverse the Linkedlist till the tail and display its elements
        Node temp = node;
        while(temp!=null){
            System.out.print(temp.value+"-->");
            //Increment the temp to the next node in the linkedlist
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void create(int[] arr){
        //LL list = new LL();
        for(int i = 0; i<arr.length;i++){
            insertAtLast(arr[i]);
        }
        //return list;
    }

    public void printSize(){
        System.out.println(size);
    }

    //Inserting element at the last of the linkedlist
    public void insertAtLast(int val){
        //If tail is null then we know that the linkedlist is empty so use insertFirst() to insert the first element of the linkedlist
        if(tail == null){insertFirst(val);}
        else{
        //Create a node with value = val 
        Node node_new = new Node(val);
        node_new.next = null;
        tail.next = node_new;
        tail = node_new;;
        size+=1;
        }
    }

    //Inserting a new node at a particular index of the linkedlist
    //If index is zero then  use insertFirst() as we want to insert the new node to the first of the linkedlist
    //If index = size of the linkedlist then ise insertAtLast() as we want to insert the new node to the last of the linkedlist
    public void insert(int value, int index){
        if(index == 0){
        insertFirst(value);
        return;}
        else if(index == size){
            insertAtLast(value);
            return;
        }
        //If we want to insert a new node inbetween two existing nodes then use temp variable to traverse through the linkedlist
        //Since we don't want to lose the head pointer location
        Node temp = head;
        //Now use a loop to reach the node before the our desired index location
        //We can start the loop from 1 till index -1
        for(int i = 1; i<index; i++){
            temp = temp.next;
        }
        //Now create a new node to hold the int value we want to insert
        Node new_node = new Node(value);
        new_node.next = temp.next;
        temp.next = new_node;
        size+=1;
    }

    //Delete the head node
    public void deleteFirst(){
        head = head.next;
        if(head == null){tail = null;}
        size -=1;
    }
    //Delete the tail node
    public void deleteLast(){
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        tail = temp;
        size-=1;
    }
    public int countLL(){
        int count = 0;
        //If the list is empty return 0
        if(head == null){return count;}
        //Else start from the head, add one to count and then move temp to the next node
        // Do that until temp is not null
        Node temp = head;
        while(temp != null){
            count+=1;
            temp = temp.next;
        }
        return count;

    }
    //Recursive function to count the number of nodes
    public int countLLRecursive(Node temp){
        //Base condition
        if(temp == null){return 0;}
        else{return countLLRecursive(temp.next)+1;}
    }

    public Node reverseLL(Node node){
        Node r = null;
        Node q = null;
        Node p = node;
        while(p!=null){
            r = q;
            q = p;
            p = p.next;
            q.next = r;
        }
        node = q;
        return node;
    }

    public void removeDuplicates(){
        Node p = head;
        if(p.next == null){System.out.println("Array has only one element. No duplicates found"); return;}
        else{
            Node q = p.next;
            while(q != null){
                if(p.value != q.value){
                    p = q;
                }else{
                    p.next = q.next;
                }
                q = q.next;
            }

        }

    }

    // Leetcode 19. Remove Nth Node From End of List
    //Given the head of a linked list, remove the nth node from the end of the list and return its head.
    public Node removeNthFromEnd(Node head, int n) {
        //If the head is null then return null
        if(head == null){return head;}
        //Assign a temp node for head
        Node temp = head;
        int count = 0;
        //Step 1: FInd the total number of nodes in the linkedlist
        while(temp != null){
            count+=1;
            temp = temp.next;
        }
        //Step 2: Use another pointer to move up to the element before the node we want to remove
        //Eg: Linkedlist = {1,2,3,4,5} and n = 2 to remove from the last then bring pointer p to node 3
        Node p = head;
        //Edge cases
        //1. if there is only node in the linkedlist and we want to remove it, just return null as head
        if(count == 1 && n ==1)
        {
            head = null; 
            return head;
        }
        //2. if there are only 2 nodes in the linkedlist and we want to remove the last node, just return head.next = null 
        else if(count == 2 && n == 1)
        {
            head.next = null; 
            return head;
        }
        //3. If we want to remove the head then just make head = head.next
        else if(n == count)
        {
            head = head.next;
            return head;
        }
        //4. If the node to remove is more than the number of elements in the linkedlist, throw an error and return the original array
        else if (n>count){System.out.println("The element to remove is out of range");return head;}
        //5. Implement step 2 as mentioned above in this case
        else{
            for(int i = 1; i<count-n; i++){
                //Bring p to the node just before the node we want to remove
                p = p.next;
            }
            //Then change the connections betweem the node
            p.next = p.next.next;
            return head;
        }  
    }

    //Leetcode Reverse sublist in linked list
    public Node reverseSublist(Node head, int left, int right){
        //Step 1: Initialize a dummy node before the head node so that we don't run into null pointer exception error if leftprev is null
        Node dummy = new Node(0, head);
        //Step 2: Bring leftprev to left-1 node and curr to left node
        Node leftprev = dummy;
        Node curr = head;
        for(int i = 0; i < left-1; i++){
            leftprev = curr;
            curr = curr.next;
        }

        //Step 3: Start reversing all elements from curr to right index. Node curr is currently pointing to the node at left index
        Node prev = null;
        for(int i = 0; i<right-left+1; i++){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        //By the end of this loop: curr is pointing to the right+1 element and prev is pointing at the right element

        //Step 4: Connect leftprev.next.next to curr and leftprev.next = prev
        leftprev.next.next = curr;
        leftprev.next = prev;

        return dummy.next;
    }

    //Finding middle element in the linkedlist
    //Logic: Use slow and fast pointer. Initially slow and fast pointer is at head node. Increment slow pointer by one and fast pointer by two nodes
    //If fast pointer reached the end of the linkedlist then we know that the slow pointer would reach half of the linkedlist
    public Node middleNode(Node head){
        Node slow = head;
        Node fast = head;
        while(fast !=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //Finding if a linkedlist is palindrome or not
    public boolean palindromeList(Node head){
        //Step 1: Find the middle element
        Node middle = middleNode(head);
        //Step 2: Reverse the second half of the linkedlist from mid till tail and store its head in the secondHead Node
        Node secondHead = reverseLL(middle);
        //Store the location of the secondHead to re-reverse this section at the end of the funciton
        Node rereverseHead = secondHead;
        //Step 3: Check each element in the first half and the second half. If they are the same element then increment if not then break from the loop
        while(head != null && secondHead !=null){
            if(head.value != secondHead.value){break;}
            head = head.next;
            secondHead = secondHead.next;
        }
        //Step 4: Undo the reversal of the second half to its orginal form
        reverseLL(rereverseHead);
        //Step 6: If the list is palindrome then head or secondHead would be null since it would have run through the entire list
        if(head == null || secondHead ==null){return true;}
        else{return false;}
    }

    public Node reverseKGroups(Node head, int k){
        //Step 1: Find the number of nodes in the linkedlist
        Node temp = head;
        int count = 0;
        while(temp != null){
            count +=1;
            temp = temp.next;
        }
        int left = 1;
        Node dummy_next = null;
        while(count >=k){
            int right = k+left-1;
            dummy_next= reverseSublist(head, left, right);
            count -=k;
            left = right+1;
        }
        return dummy_next;
    }



    
}

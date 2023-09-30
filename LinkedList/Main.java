public class Main {
    public static void main(String[] args){
        //Create a new linkedlist object
        LL list = new LL();
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(17);
        list.insertFirst(18);
        list.insertFirst(15);
        //list.displayLL();
        list.insertAtLast(20);
        //list.displayLL();
        //list.printSize();
        list.insert(30,5);
        list.displayLL(list.head);
        list.deleteFirst();
        list.displayLL(list.head);
        //list.deleteLast();
        //list.displayLL();
        int count = list.countLL();
        System.out.println("Number of nodes in the linkedlist is "+count);
        int count2 = list.countLLRecursive(list.head);
        System.out.println("Number of nodes in the linkedlist using recursion is "+count2);
        int[] arr = {1,2,3,4};
        LL list2 = new LL();
        for(int i = 0; i<arr.length;i++){
            list2.insertAtLast(arr[i]);
        }
        list2.displayLL(list2.head);
        list2.displayLL( list2.reverseLL(list2.head));
        int[] arr2 = {1,2,2,2,3,3,4,4,4,4};
        LL list3 = new LL();
        list3.create(arr2);
        list3.displayLL(list3.head);
        list3.removeDuplicates();
        list3.displayLL(list3.head);
        //Test 1
        int[] newarr = {1,2,3,4,5};
        LL list4 = new LL();
        list4.create(newarr);
        list4.displayLL(list4.head);
        list4.displayLL(list4.removeNthFromEnd(list4.head, 2));

        //Test 2
       int[] newarr2 = {1,2};
        LL list5 = new LL();
        list5.create(newarr2);
        list5.displayLL(list5.head);
        list5.displayLL(list5.removeNthFromEnd(list5.head, 2));

        //Testing reversing linkedlist sublist
        int[] arr3 = {1,2,3,4,5};
        int left = 2;
        int right = 4;
        LL listnew = new LL();
        listnew.create(arr3);
        listnew.displayLL(listnew.head);
        listnew.reverseSublist(listnew.head, left, right);
        listnew.displayLL(listnew.head);

        //Test 2
        int[] arr4 = {1,2,3,4,5,6,7,8};
        left = 1;
        right = 4;
        LL listnew2 = new LL();
        listnew2.create(arr4);
        listnew2.displayLL(listnew2.head);
        listnew2.displayLL(listnew2.reverseSublist(listnew2.head, left, right));

        //Testing middle node function
        listnew.displayLL(listnew.middleNode(listnew.head));
        //Testing palindrom of a linkedlist function
        int[] newarr3 = {1,3,3,2,1};
        LL newlist = new LL();
        newlist.create(newarr3);
        newlist.displayLL(newlist.head);
        System.out.println(newlist.palindromeList(newlist.head));

        int[] newarr4 = {1,2,3,4,5,6,7,8};
        LL newlist3 = new LL();
        newlist3.create(newarr4);
        newlist3.displayLL(newlist3.head);
        newlist3.displayLL(newlist3.reverseKGroups(newlist3.head, 3));

        





    }
}

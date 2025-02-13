package DSA.LinkedLists;

class ListNode4 {
    int val;
    ListNode4 next;
    ListNode4 prev;

    public ListNode4() {
        val = 0;
        next = null;
        prev = null;
    }

    public ListNode4(int val1) {
        val = val1;
        next = null;
        // prev = null;
    }

    public ListNode4(int val1, ListNode4 next1, ListNode4 prev1) {
        val = val1;
        next = next1;
        prev = prev1;
    }
}

class Solution4 {
    public ListNode4 insertBeforeHead(ListNode4 head, int X) {
        ListNode4 newNode = new ListNode4(X, head, null);
        head.prev = newNode;

        return newNode;
    }

    public ListNode4 insertBeforeTail(ListNode4 head, int X) {
        ListNode4 temp = head;
        while (head.next != null) {
            head = head.next;
        }
        ListNode4 newNode = new ListNode4(X, head, head.prev);
        head.prev.next = newNode;
        head.prev = newNode;

        return temp;
    }

    public void printingWholeList(ListNode4 head) {
        int i = 1;
        if (head == null) {
            System.out.println("List is empty : ");
            return;
        }
        while (head.next != null) {
            System.out.println("Node number : " + i + " : " + head.val);
            head = head.next;
        }
        System.out.println("Node number : " + i + " : " + head.val);

    }

//    public ListNode4 addTwoNumbers(ListNode4 l1, ListNode4 l2) {
//        int [] arrayOfAddition = new int[100];
//        int index = 0, sum = 0;
//
//        while(l1 != null && l2 != null){
//            sum = l1.val + l2.val;
//            System.out.println("Printing both l1 node and l2 node : "+ l1.val + " " + l2.val);
//            if(sum >= 10){
//                arrayOfAddition[index++] += sum%10;
//                arrayOfAddition[index++] += sum/10;
//                index--;
//            }
//            else{
//                arrayOfAddition[index++] += sum;
//            }
//            l1 = l1.next;
//            l2 = l2.next;
//        }
//        if(l2 == null){
//            while(l1 != null){
//                System.out.println("Only l1 nodes remaining now : "+ l1.val);
//                arrayOfAddition[index++] += l1.val;
//                l1 = l1.next;
//            }
//        }
//        if(l1 == null){
//            while(l2 != null){
//                System.out.println("Only l2 nodes remaining now : "+ l2.val);
//                arrayOfAddition[index++] += l2.val;
//                l2 = l2.next;
//            }
//        }
//
//        ListNode4 result = convertArraytoDLL(arrayOfAddition);
//        printingWholeList(result);
//
//        return l1;
//    }

    public ListNode4 convertArraytoDLL(int[] nums) {
        int n = nums.length;
        if (n == 0) return null;

        ListNode4[] nodeList = new ListNode4[n];
        for (int i = 0; i < n; i++) {
            nodeList[i] = new ListNode4(nums[i]);
        }

        for (int j = 0; j < n; j++) {
            if (j == 0) {
                nodeList[j].prev = null;

                nodeList[j].next = nodeList[j + 1];

            } else if (j == n - 1) {

                nodeList[j].prev = nodeList[j - 1];

                nodeList[j].next = null;

            } else {

                nodeList[j].prev = nodeList[j - 1];

                nodeList[j].next = nodeList[j + 1];

            }
        }

        return nodeList[0];

    }

    public ListNode4 oddEvenList(ListNode4 head) {
        // make two linkedlist for even and odd numbers
        // join both the lists at the end;

        ListNode4 oddDummy = new ListNode4(0);
        ListNode4 evenDummy = new ListNode4(0);

        ListNode4 evenNode = evenDummy;
        ListNode4 oddNode = oddDummy;
        ListNode4 temp = head;

        if (head == null || head.next == null) {
            return head;
        }

        while (head != null) {
            if (head.val % 2 == 0) {
                evenNode.next = new ListNode4(head.val);
                evenNode = evenNode.next;
            } else {
                oddNode.next = new ListNode4(head.val);
                oddNode = oddNode.next;
            }
            head = head.next;
        }

        if (temp.val % 2 == 0) {
            evenNode.next = oddDummy.next;
            return evenDummy.next;
        } else {
            oddNode.next = evenDummy.next;
            return oddDummy.next;
        }
    }

    public ListNode4 sortList(ListNode4 head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode4 zeroNode = new ListNode4(0);
        ListNode4 oneNode = new ListNode4(1);
        ListNode4 twoNode = new ListNode4(2);

        ListNode4 zeroDummy = zeroNode;
        ListNode4 oneDummy = oneNode;
        ListNode4 twoDummy = twoNode;


        while (head != null) {
            if (head.val == 0) {
                zeroNode.next = head;
                zeroNode = zeroNode.next;
            }

            if (head.val == 1) {
                oneNode.next = head;
                oneNode = oneNode.next;
            }

            if (head.val == 2) {
                twoNode.next = head;
                twoNode = twoNode.next;
            }

            head = head.next;
        }
        twoNode.next = null;

        // Connect the three lists properly
        if (oneDummy.next != null) {
            zeroNode.next = oneDummy.next; // Connect 0s to 1s
        } else {
            zeroNode.next = twoDummy.next; // If no 1s, connect 0s directly to 2s
        }

        oneNode.next = twoDummy.next; // Connect 1s to 2s

// Return the appropriate starting node
        if (zeroDummy.next != null) return zeroDummy.next;
        if (oneDummy.next != null) return oneDummy.next;
        return twoDummy.next;



    }
}

public class DLLInsertionNode {
    public static void main(String[] args) {
        ListNode4 node1 = new ListNode4(1);
        ListNode4 node2 = new ListNode4(0);
        ListNode4 node3 = new ListNode4(1);
        ListNode4 node4 = new ListNode4(2);

        node1.next = node2;
        node2.next = node3;
        node2.prev = node1;
        node3.next = node4;
        node3.prev = node2;
        node4.prev = node3;

        // System.out.println("Printing the whole linked list : node1 : " + node1.val + " ,node2 : " + node1.next.val + " ,node3 : " + node1.next.next.val + " ,node4 : " + node1.next.next.next.val);

        Solution4 obj = new Solution4();

        //ListNode4 headd = obj.oddEvenList();

        ListNode4 sortedHead = obj.sortList(node1);

        System.out.println("Joint list :");
        obj.printingWholeList(sortedHead);

        // obj.printingWholeList(headd);

        // System.out.println("Kya aya hai head : " + obj.insertBeforeHead(node1, 25).next.val);

//        System.out.println("Printing the whole linked list after inserting 25 before head : node1 : " + node1.val + " ,node2 : "+ node1.next.val + " ,node3 : "+ node1.next.next.val + " ,node4 : "+ node1.next.next.next.val );

//        Input: head -> 1 <-> 2 <-> 4, X = 3
//        Output: head -> 1 <-> 2 <-> 3 <-> 4
//        Explanation: 3 was added before the last node.

//        System.out.println("Inserting before last node : " + obj.insertBeforeTail(node1, 55));
////        obj.printingWholeList(node1);
//
//        int[] nums = new int[]{8, 3, 4, 5, 6, 7};
//        int[] nums1 = new int[]{2,3,1};
//
//        ListNode4 l1 = obj.convertArraytoDLL(nums);
//        ListNode4 l2  = obj.convertArraytoDLL(nums1);
//        obj.printingWholeList(l1);

        //obj.addTwoNumbers(l1,l2);

    }
}

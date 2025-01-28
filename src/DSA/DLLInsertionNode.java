package DSA;

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
        prev = null;
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
        while (head.next != null) {
            System.out.println("Node number : " + i + " : " + head.val);
            head = head.next;
        }
        System.out.println("Node number : " + i + " : " + head.val);

    }

    public ListNode4 convertArraytoDLL(int[] nums) {
        int n = nums.length;
        if (n == 0) return null;

        ListNode4[] nodeList = new ListNode4[n];
        for(int i=0; i<n; i++){
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
}

public class DLLInsertionNode {
    public static void main(String[] args) {
        ListNode4 node1 = new ListNode4(1);
        ListNode4 node2 = new ListNode4(2);
        ListNode4 node3 = new ListNode4(3);
        ListNode4 node4 = new ListNode4(4);

        node1.next = node2;
        node2.next = node3;
        node2.prev = node1;
        node3.next = node4;
        node3.prev = node2;
        node4.prev = node3;

        System.out.println("Printing the whole linked list : node1 : " + node1.val + " ,node2 : " + node1.next.val + " ,node3 : " + node1.next.next.val + " ,node4 : " + node1.next.next.next.val);

        Solution4 obj = new Solution4();

        System.out.println("Kya aya hai head : " + obj.insertBeforeHead(node1, 25).next.val);

//        System.out.println("Printing the whole linked list after inserting 25 before head : node1 : " + node1.val + " ,node2 : "+ node1.next.val + " ,node3 : "+ node1.next.next.val + " ,node4 : "+ node1.next.next.next.val );

//        Input: head -> 1 <-> 2 <-> 4, X = 3
//        Output: head -> 1 <-> 2 <-> 3 <-> 4
//        Explanation: 3 was added before the last node.

        System.out.println("Inserting before last node : " + obj.insertBeforeTail(node1, 55));
//        obj.printingWholeList(node1);

        int[] nums = new int[]{8, 3, 4, 5, 6, 7};

        ListNode4 head4 = obj.convertArraytoDLL(nums);
        obj.printingWholeList(head4);

    }
}

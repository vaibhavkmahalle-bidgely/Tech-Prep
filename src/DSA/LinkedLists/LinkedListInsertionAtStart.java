package DSA.LinkedLists;

class ListNode1 {
    int val;
    ListNode next;

    ListNode1() {
        val = 0;
        next = null;
    }

    ListNode1(int data1) {
        val = data1;
        next = null;
    }

    ListNode1(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}

class Solutions1 {
    public ListNode insertAtStart(ListNode head, int X, int K) {
        if (head == null) {
            return new ListNode(X);
        }
        ListNode temp = head;
        if (K == 1) {
            temp = new ListNode(X, head);
            return temp;
        }

        while (K > 2) {
            head = head.next;
            K--;
        }
        head.next = new ListNode(X,head.next);

        return temp;
    }
}

public class LinkedListInsertionAtStart {

    public static void main(String[] args) {
        Solutions1 obj = new Solutions1();

        ListNode1 node1 = new ListNode1(3, null);

        System.out.println("new Node is value and next " + node1.val + node1.next);

        System.out.println("Insert node at start : ");
        ListNode head = obj.insertAtStart(null, 44, 1);

        System.out.println("Printing head : and next : " + head.val + " " + head.next);

        System.out.println("Insert node at start : ");
        ListNode head1 = obj.insertAtStart(head, 45, 1);
        ListNode head2 = obj.insertAtStart(head1, 46, 2);

        System.out.println("Printing head : and next : " + head2.val + " " + head2.next.val + " " + head2.next.next.val);


    }
}

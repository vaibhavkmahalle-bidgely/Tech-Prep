package DSA;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
        val = 0;
        next = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}

class Solutions {
    public ListNode insertAtTail(ListNode head, int X) {
        if (head == null) {
            return new ListNode(X);
        }
        ListNode temp = head;

        while (head.next != null) {
            head = head.next;
        }

        head.next = new ListNode(X, null);
        head = head.next;
        System.out.println("Inserted at the end: " + head.val);


        return temp;
    }
}

public class LinkedListInsertionAtEnd {

    public static void main(String[] args) {
        Solutions obj = new Solutions();
        System.out.println("Inserting at the end of empty node   " + obj.insertAtTail(null, 0).val);
        // creating linkedList of 5 nodes;
        ListNode node3 = new ListNode(3, null);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        System.out.println("Inserting at the end of 3 node linked List " + obj.insertAtTail(node1, 4).val);

    }

}

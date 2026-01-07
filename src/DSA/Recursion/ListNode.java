package dsa.recursion;

public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    public ListNode removeElements(ListNode head, int val) {
        // recursive solution using IBH

        // Hypothesis :  removeElements(head, val) will remove all the nodes which has matching values with val
        // removeElements(head.next, val) : will do the same for smaller input

        // base condition : if(head == null ) return ;

        ListNode dummy = new ListNode();

        if (head == null) {
            return head;
        }
        if(head.next != null) {
            System.out.println("recursion stack : "+ head.next.val);
        }
        dummy = removeElements(head.next, val);
        head.next = dummy;
        if (head.val == val) {
            head = head.next;
        }

        return head;

    }

    public static void main(String[] args) {
         ListNode obj = new ListNode();
        //[1,2,6,3,4,5,6]
         ListNode node7 = new ListNode(6,null);
         ListNode node6 = new ListNode(5,node7);
        ListNode node5 = new ListNode(4,node6);
        ListNode node4 = new ListNode(3,node5);
        ListNode node3 = new ListNode(6,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);


        ListNode result = obj.removeElements(node1, 6);

        while(result != null){
            System.out.println("val : " + result.val);
            result = result.next;
        }
    }


}

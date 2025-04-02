package DSA.Recursion;

public class LinkedListPalindrome {
    int val;
    LinkedListPalindrome next;

    LinkedListPalindrome() {
    }

    LinkedListPalindrome(int val) {
        this.val = val;
    }

    LinkedListPalindrome(int val, LinkedListPalindrome next) {
        this.val = val;
        this.next = next;
    }

    public LinkedListPalindrome reversedList(LinkedListPalindrome head) {
        // IBH
        // base condition

        if (head == null)
            return head;

        LinkedListPalindrome head2 = new LinkedListPalindrome();
        //head2 = head;

        head2.next = null;
        head2.val = head.val;

        // hypothesis
        // reversedList(1->2->3) will return (3->2->1)
        // reversedList(2->3) will return (3->2)

        LinkedListPalindrome result =reversedList(head.next) ;
        LinkedListPalindrome result2 = result;


        if (result == null) {
            return head2;
        }
        while (result.next != null) {
            result = result.next;
        }
        result.next = head2;
        return result2;

    }

    public boolean isListEqual(LinkedListPalindrome head, LinkedListPalindrome head2) {
        // IBH 
        // BASE condition 

        // Hypothesis isListEqual(head, head2) -> this will give me if the lists are equal or not for the whole lists
        // isListEqual(head.next, head2.next) -> this will give me for smaller i/p

        if ((head == null && head2 != null) || (head != null && head2 == null)) {
            return false;
        }
        if (head == null && head2 == null) {
            return true;
        }

        boolean ans = true;

        ans = isListEqual(head.next, head2.next);
        if (head.val == head2.val) {
            return ans;
        }
        return false;
    }

    public boolean isPalindrome(LinkedListPalindrome head) {
        LinkedListPalindrome head2 = reversedList(head);

        while(head2 != null){
            System.out.println("head2 val : "+head2.val);
            head2 = head2.next;
        }

        while(head != null){
            System.out.println("head val : "+head.val);
            head = head.next;
        }

        return isListEqual(head, head2);
    }


    public static void main(String[] args) {
        LinkedListPalindrome obj = new LinkedListPalindrome();
        //[1,2,6,3,4,5,6]
        LinkedListPalindrome node7 = new LinkedListPalindrome(1, null);
        LinkedListPalindrome node6 = new LinkedListPalindrome(2, node7);
        LinkedListPalindrome node5 = new LinkedListPalindrome(2, node6);
        LinkedListPalindrome node4 = new LinkedListPalindrome(1, node5);
        LinkedListPalindrome node3 = new LinkedListPalindrome(6, node4);
        LinkedListPalindrome node2 = new LinkedListPalindrome(2, node3);
        LinkedListPalindrome node1 = new LinkedListPalindrome(1, node2);

        boolean ans = obj.isPalindrome(node1);
        System.out.println("ans : " + ans);
    }
}

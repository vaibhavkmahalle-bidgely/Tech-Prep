package DSA.Recursion;

public class swapNodesInPairs {

    // Definition for singly-linked list.
    public static class ListNode8 {
        int val;
        ListNode8 next;

        ListNode8() {
        }

        ListNode8(int val) {
            this.val = val;
        }

        ListNode8(int val, ListNode8 next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {

        public ListNode8 swapPairs(ListNode8 head) {
            // base condition
            // smallest valid input

            if (head == null) {
                return null;
            }
            if (head.next == null) {
                return head;
            }


            ListNode8 temp;

                temp = swapPairs(head.next.next);

            ListNode8 temp2 = head;
            head = head.next;
            if (head != null)
                head.next = temp2;
            temp2.next = temp;
            return head;

        }

        public void printNodes(ListNode8 head){
            while(head != null ){
                System.out.println(head.val);
                head = head.next;
            }
        }
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        // [1,2,3,4]
        ListNode8 node1 = new ListNode8(1, new ListNode8(2,new ListNode8(3,new ListNode8(4))));

        System.out.println(obj.swapPairs(node1));

        obj.printNodes(node1);

    }
}

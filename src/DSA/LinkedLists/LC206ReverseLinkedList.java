package DSA.LinkedLists;

/**
 * LeetCode Problem 206: Reverse Linked List
 *
 * Problem Statement:
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * Example:
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 *
 * Constraints:
 * - The number of nodes in the list is the range [0, 5000].
 * - -5000 <= Node.val <= 5000
 *
 * Time Complexity: O(n) where n is the number of nodes
 * Space Complexity: O(1) - iterative approach uses constant extra space
 */
public class LC206ReverseLinkedList {

    /**
     * Definition for singly-linked list node
     *
     * CODING STANDARDS IMPROVEMENTS NEEDED:
     * 1. This class should be defined here or imported properly
     * 2. Should have proper encapsulation with private fields
     * 3. Should include constructors and utility methods
     * 4. Should override toString() for better debugging
     */
    static class ListNode {
        int val;           // IMPROVEMENT: Should be private with getter/setter
        ListNode next;     // IMPROVEMENT: Should be private with getter/setter

        // Default constructor
        ListNode() {}

        // Constructor with value
        ListNode(int val) {
            this.val = val;
        }

        // Constructor with value and next node
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        /**
         * Override toString for better debugging and testing
         * @return string representation of the node
         */
        @Override
        public String toString() {
            return "ListNode{val=" + val + "}";
        }
    }

    /**
     * Reverses a singly linked list iteratively
     *
     * ALGORITHM EXPLANATION:
     * Uses three pointers (prev, curr, next) to reverse the direction of links:
     * 1. Store the next node before breaking the link
     * 2. Reverse the current node's link to point to previous node
     * 3. Move prev and curr pointers forward
     * 4. Repeat until we reach the end
     *
     * CODING STANDARDS ANALYSIS:
     * ✅ Good: Simple and efficient algorithm
     * ✅ Good: Meaningful variable names (prev, curr, next)
     * ❌ Missing: Input validation for edge cases
     * ❌ Missing: Method documentation
     * ❌ Missing: Space after 'while' keyword
     * ❌ Missing: Comprehensive test cases
     *
     * @param head the head of the linked list to reverse
     * @return the new head of the reversed linked list
     */
    public ListNode reverseList(ListNode head) {
        // IMPROVEMENT NEEDED: Add input validation
        // Edge case: empty list or single node
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;  // Previous node (initially null)
        ListNode curr = head;  // Current node being processed

        // IMPROVEMENT: Added space after 'while' for better formatting
        while (curr != null) {
            ListNode next = curr.next;  // Store next node before breaking link
            curr.next = prev;           // Reverse the link
            prev = curr;                // Move prev pointer forward
            curr = next;                // Move curr pointer forward
        }

        return prev;  // prev is now the new head of reversed list
    }

    /**
     * Alternative recursive solution for comparison
     *
     * PROS: More elegant and easier to understand conceptually
     * CONS: Uses O(n) space due to recursion stack
     *
     * @param head the head of the linked list to reverse
     * @return the new head of the reversed linked list
     */
    public ListNode reverseListRecursive(ListNode head) {
        // Base case: empty list or single node
        if (head == null || head.next == null) {
            return head;
        }

        // Recursively reverse the rest of the list
        ListNode reversedHead = reverseListRecursive(head.next);

        // Reverse the current connection
        head.next.next = head;
        head.next = null;

        return reversedHead;
    }

    /**
     * Utility method to create a linked list from an array
     *
     * @param values array of integers to create list from
     * @return head of the created linked list
     */
    public static ListNode createLinkedList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        ListNode head = new ListNode(values[0]);
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return head;
    }

    /**
     * Utility method to convert linked list to array for easy comparison
     *
     * @param head the head of the linked list
     * @return array representation of the linked list
     */
    public static int[] linkedListToArray(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        // First pass: count nodes
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        // Second pass: fill array
        int[] result = new int[count];
        temp = head;
        for (int i = 0; i < count; i++) {
            result[i] = temp.val;
            temp = temp.next;
        }

        return result;
    }

    /**
     * Utility method to print linked list in a readable format
     *
     * @param head the head of the linked list to print
     * @return string representation of the linked list
     */
    public static String printLinkedList(ListNode head) {
        if (head == null) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        ListNode current = head;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }

        sb.append("]");
        return sb.toString();
    }

    /**
     * Main method to test the solution with various test cases
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        LC206ReverseLinkedList solution = new LC206ReverseLinkedList();

        System.out.println("=== LeetCode 206: Reverse Linked List ===\n");

        // Test cases
        int[][] testCases = {
            {1, 2, 3, 4, 5},     // Normal case
            {1, 2},              // Two nodes
            {1},                 // Single node
            {},                  // Empty list
            {1, 2, 3},           // Odd number of nodes
            {1, 2, 3, 4}         // Even number of nodes
        };

        int[][] expectedResults = {
            {5, 4, 3, 2, 1},
            {2, 1},
            {1},
            {},
            {3, 2, 1},
            {4, 3, 2, 1}
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.printf("Test Case %d:\n", i + 1);

            // Create original list
            ListNode original = createLinkedList(testCases[i]);
            System.out.printf("Original:  %s\n", printLinkedList(original));

            // Test iterative solution
            ListNode reversedIterative = solution.reverseList(original);
            int[] resultIterative = linkedListToArray(reversedIterative);
            System.out.printf("Reversed:  %s\n", printLinkedList(reversedIterative));

            // Verify result
            boolean isCorrect = java.util.Arrays.equals(resultIterative, expectedResults[i]);
            System.out.printf("Expected:  %s\n", java.util.Arrays.toString(expectedResults[i]));
            System.out.printf("Status:    %s\n", isCorrect ? "✅ PASS" : "❌ FAIL");

            // Test recursive solution (recreate list since it was modified)
            ListNode originalRecursive = createLinkedList(testCases[i]);
            ListNode reversedRecursive = solution.reverseListRecursive(originalRecursive);
            int[] resultRecursive = linkedListToArray(reversedRecursive);
            boolean isRecursiveCorrect = java.util.Arrays.equals(resultRecursive, expectedResults[i]);
            System.out.printf("Recursive: %s\n", isRecursiveCorrect ? "✅ PASS" : "❌ FAIL");

            System.out.println();
        }

        // Demonstrate step-by-step reversal
        System.out.println("=== Step-by-Step Reversal Demo ===");
        demonstrateReversal();
    }

    /**
     * Demonstrates the step-by-step process of reversing a linked list
     */
    private static void demonstrateReversal() {
        System.out.println("Original list: [1 -> 2 -> 3 -> 4 -> null]");
        System.out.println("\nStep-by-step reversal process:");

        // Create a simple list: 1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode prev = null;
        ListNode curr = head;
        int step = 1;

        System.out.printf("Initial: prev=null, curr=%d\n", curr.val);

        while (curr != null) {
            ListNode next = curr.next;
            System.out.printf("\nStep %d:\n", step);
            System.out.printf("  Before: prev=%s, curr=%d, next=%s\n",
                prev == null ? "null" : String.valueOf(prev.val),
                curr.val,
                next == null ? "null" : String.valueOf(next.val));

            curr.next = prev;  // Reverse the link
            prev = curr;       // Move prev forward
            curr = next;       // Move curr forward

            System.out.printf("  After:  prev=%d, curr=%s\n",
                prev.val,
                curr == null ? "null" : String.valueOf(curr.val));

            step++;
        }

        System.out.printf("\nFinal result: %s\n", printLinkedList(prev));
    }
}

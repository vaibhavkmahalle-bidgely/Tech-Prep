package dsa.hashmap;

import java.util.HashSet;

/**
 * LeetCode Problem 1876: Substrings of Size Three with Distinct Characters
 *
 * Problem: Given a string s, return the number of good substrings of length 3 in s.
 * A string is good if there are no repeated characters.
 *
 * Example: "xyzzaz" -> 1 (only "xyz" is good)
 */
public class LeetCode1876 {

    /**
     * Solution class containing the main algorithm
     *
     * CODING STANDARDS IMPROVEMENTS NEEDED:
     * 1. Class should be static or moved outside for better encapsulation
     * 2. Method documentation should include time/space complexity
     * 3. Variable names could be more descriptive
     * 4. Algorithm can be optimized for better performance
     */
    static class Solution {

        /**
         * Counts the number of good substrings of length 3
         *
         * ALGORITHM ANALYSIS:
         * Current approach uses a HashSet to check for distinct characters
         * Time Complexity: O(n) where n is the length of string
         * Space Complexity: O(1) as HashSet size is at most 3
         *
         * IMPROVEMENTS NEEDED:
         * 1. Variable 'k' is confusing - should be renamed to 'charIndex' or similar
         * 2. The while loop is unnecessary - can be replaced with direct character access
         * 3. Missing input validation for null string
         * 4. Spacing inconsistencies around if statements and operators
         *
         * @param s the input string to analyze
         * @return count of good substrings of length 3
         */
        public int countGoodSubstrings(String s) {
            // INPUT VALIDATION MISSING: Should check for null input
            if (s == null) {
                return 0;
            }

            HashSet<Character> characterSet = new HashSet<>(); // IMPROVEMENT: More descriptive name

            int stringLength = s.length(); // IMPROVEMENT: More descriptive name
            if (stringLength < 3) {
                return 0;
            }

            // IMPROVEMENT NEEDED: Variable 'k' is poorly named and the logic is overly complex
            int k = 0; // TODO: Rename to more descriptive name
            int goodSubstringCount = 0; // IMPROVEMENT: More descriptive name

            for (int i = 0; i < stringLength - 2; i++) {
                // IMPROVEMENT NEEDED: This while loop is unnecessary and confusing
                // Can be replaced with direct access to s.charAt(i), s.charAt(i+1), s.charAt(i+2)
                while (k < 3) {
                    characterSet.add(s.charAt(k + i));
                    k++;
                }

                // IMPROVEMENT NEEDED: Add space after 'if' and around '=='
                if (characterSet.size() == 3) { // Fixed spacing
                    goodSubstringCount++;
                }

                characterSet.clear();
                k = 0;
            }

            return goodSubstringCount;
        }

        /**
         * OPTIMIZED VERSION (RECOMMENDED):
         * A more efficient and cleaner implementation would be:
         *
         * public int countGoodSubstringsOptimized(String s) {
         *     if (s == null || s.length() < 3) return 0;
         *
         *     int count = 0;
         *     for (int i = 0; i <= s.length() - 3; i++) {
         *         char first = s.charAt(i);
         *         char second = s.charAt(i + 1);
         *         char third = s.charAt(i + 2);
         *
         *         if (first != second && second != third && first != third) {
         *             count++;
         *         }
         *     }
         *     return count;
         * }
         */
    }

    /**
     * Main method to test the solution with various test cases
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        String[] testCases = {
            "xyzzaz",    // Expected: 1 (only "xyz")
            "aababcabc",  // Expected: 4 ("aab", "aba", "abc", "bca")
            "aa",         // Expected: 0 (length < 3)
            "abc",        // Expected: 1 ("abc")
            "aaa",        // Expected: 0 (no distinct characters)
            "",           // Expected: 0 (empty string)
            "abcabc"      // Expected: 4 ("abc", "bca", "cab", "abc")
        };

        int[] expectedResults = {1, 4, 0, 1, 0, 0, 4};

        System.out.println("=== LeetCode 1876: Substrings of Size Three with Distinct Characters ===\n");

        for (int i = 0; i < testCases.length; i++) {
            String testCase = testCases[i];
            int result = solution.countGoodSubstrings(testCase);
            int expected = expectedResults[i];

            System.out.printf("Test Case %d:\n", i + 1);
            System.out.printf("Input: \"%s\"\n", testCase);
            System.out.printf("Output: %d\n", result);
            System.out.printf("Expected: %d\n", expected);
            System.out.printf("Status: %s\n", result == expected ? "✅ PASS" : "❌ FAIL");
            System.out.println();
        }

        // Dry run explanation for "xyzzaz"
        System.out.println("=== DRY RUN for input \"xyzzaz\" ===");
        dryRunExplanation("xyzzaz");
    }

    /**
     * Provides a detailed dry run explanation for the given input
     *
     * @param input the string to analyze step by step
     */
    private static void dryRunExplanation(String input) {
        System.out.printf("Input string: \"%s\"\n", input);
        System.out.printf("String length: %d\n", input.length());
        System.out.println("\nStep-by-step analysis:");

        int count = 0;
        for (int i = 0; i <= input.length() - 3; i++) {
            String substring = input.substring(i, i + 3);
            char first = substring.charAt(0);
            char second = substring.charAt(1);
            char third = substring.charAt(2);

            boolean isGood = (first != second && second != third && first != third);
            if (isGood) count++;

            System.out.printf("Position %d: \"%s\" -> Characters: '%c', '%c', '%c' -> %s\n",
                i, substring, first, second, third, isGood ? "GOOD ✅" : "NOT GOOD ❌");
        }

        System.out.printf("\nTotal good substrings: %d\n", count);
    }
}

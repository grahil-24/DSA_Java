package SlidingWindow;

import java.util.*;
import java.util.stream.Collectors;

public class PermutationInString {

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] arr = new int[26];
        Arrays.fill(arr, 0);

        int length1 = s1.length();
        int length2 = s2.length();

        // Initialize frequency array for s1
        for (int i = 0; i < length1; i++) {
            arr[s1.charAt(i) - 'a']++;
        }

        // Initialize sliding window
        int start = 0, end = 0, count = length1;

        while (end < length2) {
            // Decrement count if character is present in s1
            if (arr[s2.charAt(end) - 'a'] > 0) {
                count--;
            }
            arr[s2.charAt(end) - 'a']--;
            end++;

            // Check if the window size is equal to s1 length
            if (end - start == length1) {
                if (count == 0) {
                    return true; // Found a permutation
                }

                // Increment count and move the window
                if (arr[s2.charAt(start) - 'a'] >= 0) {
                    count++;
                }
                arr[s2.charAt(start) - 'a']++;
                start++;
            }
        }

        return false; // No
    }

    public static void main(String[] args) {
        System.out.println(PermutationInString.checkInclusion("ab", "eidboaaa"));
    }
}

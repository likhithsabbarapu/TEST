import java.util.*;

public class ListNode {
    int val;
    ListNode next;

    // Constructor to create a node
    ListNode(int val) {
        this.val = val;
    }

    public static void main(String[] args) {
        // Create List 1: 2 -> 4 -> 3
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // Create List 2: 5 -> 6 -> 4
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // Run the addition logic
        ListNode result = addTwoNumbers(l1, l2);

        // Print the result: 7 -> 0 -> 8
        System.out.print("Result: ");
        while (result != null) {
            System.out.print(result.val + (result.next != null ? " -> " : ""));
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // A "fake" start to build our list
        ListNode curr = dummyHead;
        int carry = 0;

        // Keep going as long as there are numbers to add or a leftover carry
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0; // Use 0 if the list ended
            int val2 = (l2 != null) ? l2.val : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10; // Get the tens place (e.g., 1 from 10)

            curr.next = new ListNode(sum % 10); // Get the ones place (e.g., 0 from 10)
            curr = curr.next; // Move forward in our result list

            if (l1 != null) l1 = l1.next; // Move forward in List 1
            if (l2 != null) l2 = l2.next; // Move forward in List 2
        }

        return dummyHead.next; // Return the list, skipping our "fake" 0 at the start
    }
}